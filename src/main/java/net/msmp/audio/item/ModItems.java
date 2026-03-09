package net.msmp.audio.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.audio.MsmpAudio;



public class ModItems {

    public static final DeferredRegister<Item>ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MsmpAudio.MOD_ID);

    //FITAS VHS
    public static final RegistryObject<Item> VHS_MUSIC_1 = ITEMS.register("vhs_music_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "music_vhs_creep"));

    public static final RegistryObject<Item> VHS_RADIO_1 = ITEMS.register("vhs_radio_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "radio_vhs_loop"));

    public static final RegistryObject<Item> VHS_ZIGGY_1 = ITEMS.register("vhs_ziggy_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_ziggy_1"));

    public static final RegistryObject<Item> VHS_TEDDYBEAR_1 = ITEMS.register("vhs_teddybear_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_teddybear_1"));

    public static final RegistryObject<Item> VHS_HELENA_E_HENRIQUE_1 = ITEMS.register("vhs_helena_e_henrique_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_helena_e_henrique_1"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_1 = ITEMS.register("vhs_laura_menezes_1",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_1"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_2 = ITEMS.register("vhs_laura_menezes_2",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_2"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_3 = ITEMS.register("vhs_laura_menezes_3",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_3"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_4 = ITEMS.register("vhs_laura_menezes_4",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_4"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_5 = ITEMS.register("vhs_laura_menezes_5",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_5"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_6 = ITEMS.register("vhs_laura_menezes_6",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_6"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_7 = ITEMS.register("vhs_laura_menezes_7",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_7"));

    public static final RegistryObject<Item> VHS_LAURA_MENEZES_8 = ITEMS.register("vhs_laura_menezes_8",
            () -> new VHSTapeItem(new Item.Properties().stacksTo(1), "lore_laura_menezes_8"));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
