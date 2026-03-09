package net.msmp.audio.item;

import net.minecraft.world.item.Item;


public class VHSTapeItem extends Item {
    private final String audioId;

    public VHSTapeItem(Properties pProperties, String audioId) {
        super(pProperties);
        this.audioId = audioId;
    }

    public String getAudioId() {
        return audioId;
    }
}