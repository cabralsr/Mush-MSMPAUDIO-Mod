package net.msmp.audio;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSound {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MsmpAudio.MOD_ID);


    public static final RegistryObject<SoundEvent> CREEP_RADIOHEAD = registerSoundEvent("music_vhs_creep");

    public static final RegistryObject<SoundEvent> RADIO_LOOP_1 = registerSoundEvent("radio_vhs_loop");

    public static final RegistryObject<SoundEvent> ZIGGY_1  = registerSoundEvent("lore_ziggy_1");

    public static final RegistryObject<SoundEvent> TEDDYBEAR_1  = registerSoundEvent("lore_teddybear_1");

    public static final RegistryObject<SoundEvent> HELENA_E_HENRIQUE_1  = registerSoundEvent("lore_helena_e_henrique_1");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_1 = registerSoundEvent("lore_laura_menezes_1");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_2 = registerSoundEvent("lore_laura_menezes_2");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_3 = registerSoundEvent("lore_laura_menezes_3");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_4 = registerSoundEvent("lore_laura_menezes_4");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_5 = registerSoundEvent("lore_laura_menezes_5");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_6 = registerSoundEvent("lore_laura_menezes_6");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_7 = registerSoundEvent("lore_laura_menezes_7");

    public static final RegistryObject<SoundEvent> LAURA_MENEZES_8 = registerSoundEvent("lore_laura_menezes_8");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () ->
                SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MsmpAudio.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}