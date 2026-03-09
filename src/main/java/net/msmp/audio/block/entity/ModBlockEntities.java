package net.msmp.audio.block.entity;


import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.audio.MsmpAudio;
import net.msmp.audio.block.ModBlocks;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MsmpAudio.MOD_ID);

    public static final RegistryObject<BlockEntityType<VHSPlayerBlockEntity>> VHS_PLAYER_BE =
            BLOCK_ENTITIES.register("vhs_player_be", () ->
                    BlockEntityType.Builder.of(
                            VHSPlayerBlockEntity::new,
                            ModBlocks.VHS_PLAYER.get()
                    ).build(null));
    
    public static void register(IEventBus eventBus) {BLOCK_ENTITIES.register(eventBus);}
}
