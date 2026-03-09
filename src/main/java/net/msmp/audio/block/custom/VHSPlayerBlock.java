package net.msmp.audio.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import net.msmp.audio.MsmpAudio;
import net.msmp.audio.block.entity.VHSPlayerBlockEntity;
import net.msmp.audio.item.VHSTapeItem;
import org.jetbrains.annotations.Nullable;

public class VHSPlayerBlock extends BaseEntityBlock {
    public static final BooleanProperty PLAYING = BooleanProperty.create("playing");

    public VHSPlayerBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PLAYING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(PLAYING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {

            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof VHSPlayerBlockEntity vhsEntity) {

                ItemStack itemInHand = pPlayer.getItemInHand(pHand);
                ItemStack itemInSlot = vhsEntity.getItemHandler().getStackInSlot(0);

                if (pPlayer.isCrouching() && !itemInSlot.isEmpty()) {
                    if (pState.getValue(PLAYING) && itemInSlot.getItem() instanceof VHSTapeItem vhsItem) {
                        stopSound(pLevel, pPos, vhsItem.getAudioId());
                        pLevel.setBlock(pPos, pState.setValue(PLAYING, false), 3);
                    }

                    pPlayer.getInventory().add(vhsEntity.getItemHandler().extractItem(0, 1, false));
                    pLevel.playSound(null, pPos, SoundEvents.LEVER_CLICK, SoundSource.BLOCKS, 1f, 1f);
                    return InteractionResult.SUCCESS;
                }

                if (itemInSlot.isEmpty() && itemInHand.getItem() instanceof VHSTapeItem) {
                    vhsEntity.getItemHandler().insertItem(0, itemInHand.copy(), false);
                    itemInHand.shrink(1);
                    pLevel.playSound(null, pPos, SoundEvents.DISPENSER_DISPENSE, SoundSource.BLOCKS, 1f, 1f);
                    pLevel.setBlock(pPos, pState.setValue(PLAYING, false), 3);
                    return InteractionResult.SUCCESS;
                }

                if (!itemInSlot.isEmpty()) {
                    VHSTapeItem vhsItem = (VHSTapeItem) itemInSlot.getItem();
                    boolean isPlaying = pState.getValue(PLAYING);

                    if (isPlaying) {
                        stopSound(pLevel, pPos, vhsItem.getAudioId());
                        pLevel.setBlock(pPos, pState.setValue(PLAYING, false), 3);

                    } else {
                        String audioID = vhsItem.getAudioId();
                        ResourceLocation soundLocation = ResourceLocation.fromNamespaceAndPath(MsmpAudio.MOD_ID, audioID);
                        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(soundLocation);

                        if (soundEvent != null) {
                            pLevel.playSound(null, pPos, soundEvent, SoundSource.RECORDS, 1f, 1f);
                            pLevel.setBlock(pPos, pState.setValue(PLAYING, true), 3);
                        }
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof VHSPlayerBlockEntity vhsEntity) {

                ItemStack stack = vhsEntity.getItemHandler().getStackInSlot(0);
                if (!stack.isEmpty() && stack.getItem() instanceof VHSTapeItem vhsItem) {
                    stopSound(pLevel, pPos, vhsItem.getAudioId());
                }

                vhsEntity.drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VHSPlayerBlockEntity(pPos, pState);
    }

    private void stopSound(Level level, BlockPos pos, String audioID) {
        if (!level.isClientSide) {
            ResourceLocation soundLoc = ResourceLocation.fromNamespaceAndPath(MsmpAudio.MOD_ID, audioID);
            ClientboundStopSoundPacket stopPacket = new ClientboundStopSoundPacket(soundLoc, SoundSource.RECORDS);

            for (Player player : level.players()) {
                if (player instanceof ServerPlayer serverPlayer) {
                    if (serverPlayer.distanceToSqr(pos.getX(), pos.getY(), pos.getZ()) < 32 * 32) {
                        serverPlayer.connection.send(stopPacket);
                    }
                }
            }
        }
    }
}