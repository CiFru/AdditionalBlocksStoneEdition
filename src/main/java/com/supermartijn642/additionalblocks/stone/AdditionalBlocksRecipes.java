package com.supermartijn642.additionalblocks.stone;

import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

/**
 * Created 1/29/2021 by SuperMartijn642
 */
public class AdditionalBlocksRecipes {

    private static boolean checkIngredients(Iterable<Ingredient> ingredients){
        for(Ingredient ingredient : ingredients){
            ItemStack[] itemStacks = ingredient.getItems();
            if(itemStacks.length == 1 && !checkItemStack(itemStacks[0]))
                return false;
        }
        return true;
    }

    private static boolean checkItemStack(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof IConfigObject){
            if(!((IConfigObject)item).isEnabled())
                return false;
        }else if(item instanceof BlockItem){
            Block block = ((BlockItem)item).getBlock();
            if(block instanceof IConfigObject && !((IConfigObject)block).isEnabled())
                return false;
        }
        return true;
    }

    public static class ShapedSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapedRecipe> {

        @Override
        public ShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json){
            ShapedRecipe recipe = IRecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapedRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer){
            ShapedRecipe recipe = IRecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, ShapedRecipe recipe){
            IRecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class ShapelessSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapelessRecipe> {

        @Override
        public ShapelessRecipe fromJson(ResourceLocation recipeId, JsonObject json){
            ShapelessRecipe recipe = IRecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapelessRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer){
            ShapelessRecipe recipe = IRecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, ShapelessRecipe recipe){
            IRecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class FurnaceSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<FurnaceRecipe> {

        @Override
        public FurnaceRecipe fromJson(ResourceLocation recipeId, JsonObject json){
            FurnaceRecipe recipe = IRecipeSerializer.SMELTING_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public FurnaceRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer){
            FurnaceRecipe recipe = IRecipeSerializer.SMELTING_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, FurnaceRecipe recipe){
            IRecipeSerializer.SMELTING_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class BlastFurnaceSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<BlastingRecipe> {

        @Override
        public BlastingRecipe fromJson(ResourceLocation recipeId, JsonObject json){
            BlastingRecipe recipe = IRecipeSerializer.BLASTING_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public BlastingRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer){
            BlastingRecipe recipe = IRecipeSerializer.BLASTING_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, BlastingRecipe recipe){
            IRecipeSerializer.BLASTING_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class StoneCutterSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<StonecuttingRecipe> {

        @Override
        public StonecuttingRecipe fromJson(ResourceLocation recipeId, JsonObject json){
            StonecuttingRecipe recipe = IRecipeSerializer.STONECUTTER.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public StonecuttingRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer){
            StonecuttingRecipe recipe = IRecipeSerializer.STONECUTTER.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(PacketBuffer buffer, StonecuttingRecipe recipe){
            IRecipeSerializer.STONECUTTER.toNetwork(buffer, recipe);
        }
    }
}
