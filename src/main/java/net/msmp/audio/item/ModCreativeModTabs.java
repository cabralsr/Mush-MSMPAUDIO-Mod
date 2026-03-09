package net.msmp.audio.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.audio.MsmpAudio;
import net.msmp.audio.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MsmpAudio.MOD_ID);


    public static final RegistryObject<CreativeModeTab> MSMP_TAB_VHS = CREATIVE_MODE_TABS.register("msmp_tab_vhs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VHS_MUSIC_1.get()))
                    .displayItems((itemDisplayParameters, output) -> {

                        //TOCA VHS
                        output.accept(ModBlocks.VHS_PLAYER.get());

                        //VHS
                        output.accept(ModItems.VHS_MUSIC_1.get());

                        output.accept(ModItems.VHS_RADIO_1.get());

                        output.accept(ModItems.VHS_ZIGGY_1.get());

                        output.accept(ModItems.VHS_TEDDYBEAR_1.get());

                        output.accept(ModItems.VHS_HELENA_E_HENRIQUE_1.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_1.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_2.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_3.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_4.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_5.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_6.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_7.get());

                        output.accept(ModItems.VHS_LAURA_MENEZES_8.get());

                    }).title(Component.translatable("creativetab.msmp_tab_vhs")).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
