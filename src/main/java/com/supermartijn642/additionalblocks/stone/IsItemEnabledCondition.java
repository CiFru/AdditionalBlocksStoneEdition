package com.supermartijn642.additionalblocks.stone;

import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.registries.ForgeRegistries;

public class IsItemEnabledCondition implements ICondition {

    private static final ResourceLocation NAME = new ResourceLocation("abstoneedition","isitemenabled");
    private final ResourceLocation item;

    public IsItemEnabledCondition(ResourceLocation location){
        this.item = location;
    }

    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test() {
        System.out.println("TEST!");
//        return false;
        Item item = ForgeRegistries.ITEMS.getValue(this.item);
        if(item instanceof BlockItem){
            System.out.println("TEST2!");
            Block block = ((BlockItem) item).getBlock();
            if(block instanceof IConfigObject){
                System.out.println("TEST3!");
                System.out.println("TEST!"+((IConfigObject) block).isEnabled());
                return ((IConfigObject) block).isEnabled();
            }
        }
        if(item instanceof IConfigObject){
            System.out.println("TEST4!");
            return ((IConfigObject) item).isEnabled();
        }
        System.out.println("TEST5!");
        return true;
    }

    public static class Serializer implements IConditionSerializer<IsItemEnabledCondition>{

        @Override
        public void write(JsonObject json, IsItemEnabledCondition value) {
            json.addProperty("item",value.item.toString());

        }

        @Override
        public IsItemEnabledCondition read(JsonObject json) {
            return new IsItemEnabledCondition(new ResourceLocation(JSONUtils.getString(json,"item")));
        }

        @Override
        public ResourceLocation getID() {
            return NAME;
        }
    }
}
