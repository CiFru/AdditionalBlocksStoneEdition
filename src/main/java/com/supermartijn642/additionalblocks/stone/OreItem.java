package com.supermartijn642.additionalblocks.stone;

import net.minecraft.item.Item;

import java.util.function.Supplier;

public class OreItem extends Item implements IConfigObject {

    private final Supplier<Boolean> enable;

    public OreItem(String registryName, Supplier<Boolean> enable, Properties properties) {
        super(properties);
        this.setRegistryName(registryName);
        this.enable = enable;
    }

    @Override
    public boolean isEnabled() {
        return this.enable.get();
    }
}
