package com.cifru.additionalblocks.stone.condition;

import com.cifru.additionalblocks.stone.items.AdditionalBlocksItems;
import com.cifru.additionalblocks.stone.items.ItemType;
import com.google.gson.JsonObject;
import com.supermartijn642.core.data.condition.ResourceCondition;
import com.supermartijn642.core.data.condition.ResourceConditionContext;
import com.supermartijn642.core.data.condition.ResourceConditionSerializer;
import net.minecraft.util.ResourceLocation;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class ItemEnabledResourceCondition implements ResourceCondition {

    public static final Serializer SERIALIZER = new Serializer();

    private final ItemType<?> itemType;

    public ItemEnabledResourceCondition(ItemType<?> itemType){
        this.itemType = itemType;
    }

    @Override
    public boolean test(ResourceConditionContext context){
        return this.itemType.isEnabled();
    }

    @Override
    public ResourceConditionSerializer<?> getSerializer(){
        return SERIALIZER;
    }

    private static class Serializer implements ResourceConditionSerializer<ItemEnabledResourceCondition> {

        private Serializer(){
        }

        public void serialize(JsonObject json, ItemEnabledResourceCondition condition){
            json.addProperty("item", condition.itemType.getIdentifier().toString());
        }

        public ItemEnabledResourceCondition deserialize(JsonObject json){
            if(json.has("item") && json.get("item").isJsonPrimitive() && json.getAsJsonPrimitive("item").isString()){
                ResourceLocation identifier = new ResourceLocation(json.get("item").getAsString());
                ItemType<?> itemType = null;
                for(ItemType<?> item : AdditionalBlocksItems.ALL_ITEMS){
                    if(identifier.equals(item.getIdentifier())){
                        itemType = item;
                        break;
                    }
                }
                if(itemType == null)
                    throw new RuntimeException("Condition has unknown item type identifier '" + identifier + "'!");
                return new ItemEnabledResourceCondition(itemType);
            }else{
                throw new RuntimeException("Condition must have key 'item' with a string!");
            }
        }
    }
}
