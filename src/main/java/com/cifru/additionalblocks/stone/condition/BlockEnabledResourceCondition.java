package com.cifru.additionalblocks.stone.condition;

import com.cifru.additionalblocks.stone.blocks.AdditionalBlocksBlocks;
import com.cifru.additionalblocks.stone.blocks.BlockType;
import com.google.gson.JsonObject;
import com.supermartijn642.core.data.condition.ResourceCondition;
import com.supermartijn642.core.data.condition.ResourceConditionContext;
import com.supermartijn642.core.data.condition.ResourceConditionSerializer;
import net.minecraft.util.ResourceLocation;

/**
 * Created 19/03/2023 by SuperMartijn642
 */
public class BlockEnabledResourceCondition implements ResourceCondition {

    public static final Serializer SERIALIZER = new Serializer();

    private final BlockType<?> blockType;

    public BlockEnabledResourceCondition(BlockType<?> blockType){
        this.blockType = blockType;
    }

    @Override
    public boolean test(ResourceConditionContext context){
        return this.blockType.isEnabled();
    }

    @Override
    public ResourceConditionSerializer<?> getSerializer(){
        return SERIALIZER;
    }

    private static class Serializer implements ResourceConditionSerializer<BlockEnabledResourceCondition> {

        private Serializer(){
        }

        public void serialize(JsonObject json, BlockEnabledResourceCondition condition){
            json.addProperty("block", condition.blockType.getIdentifier().toString());
        }

        public BlockEnabledResourceCondition deserialize(JsonObject json){
            if(json.has("block") && json.get("block").isJsonPrimitive() && json.getAsJsonPrimitive("block").isString()){
                ResourceLocation identifier = new ResourceLocation(json.get("block").getAsString());
                BlockType<?> blockType = null;
                for(BlockType<?> block : AdditionalBlocksBlocks.ALL_BLOCKS){
                    if(identifier.equals(block.getIdentifier())){
                        blockType = block;
                        break;
                    }
                }
                if(blockType == null)
                    throw new RuntimeException("Condition has unknown block type identifier '" + identifier + "'!");
                return new BlockEnabledResourceCondition(blockType);
            }else{
                throw new RuntimeException("Condition must have key 'block' with a string!");
            }
        }
    }
}
