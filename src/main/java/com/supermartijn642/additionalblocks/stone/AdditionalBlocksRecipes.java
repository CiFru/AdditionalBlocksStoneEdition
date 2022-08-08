package com.supermartijn642.additionalblocks.stone;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

/**
 * Created 1/29/2021 by SuperMartijn642
 */
public class AdditionalBlocksRecipes {

    private static boolean checkIngredients(Iterable<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            ItemStack[] itemStacks = ingredient.getItems();
            if (itemStacks.length == 1 && !checkItemStack(itemStacks[0]))
                return false;
        }
        return true;
    }

    private static boolean checkItemStack(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof IConfigObject) {
            if (!((IConfigObject) item).isEnabled())
                return false;
        } else if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            if (block instanceof IConfigObject && !((IConfigObject) block).isEnabled())
                return false;
        }
        return true;
    }

    public static class ShapedSerializer implements RecipeSerializer<ShapedRecipe> {

        @Override
        public ShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            ShapedRecipe recipe = RecipeSerializer.SHAPED_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ShapedRecipe recipe) {
            RecipeSerializer.SHAPED_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class ShapelessSerializer implements RecipeSerializer<ShapelessRecipe> {

        @Override
        public ShapelessRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ShapelessRecipe recipe = RecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public ShapelessRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            ShapelessRecipe recipe = RecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ShapelessRecipe recipe) {
            RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class FurnaceSerializer implements RecipeSerializer<SmeltingRecipe> {

        @Override
        public SmeltingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            SmeltingRecipe recipe = RecipeSerializer.SMELTING_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public SmeltingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            SmeltingRecipe recipe = RecipeSerializer.SMELTING_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, SmeltingRecipe recipe) {
            RecipeSerializer.SMELTING_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class BlastFurnaceSerializer implements RecipeSerializer<BlastingRecipe> {

        @Override
        public BlastingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            BlastingRecipe recipe = RecipeSerializer.BLASTING_RECIPE.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public BlastingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            BlastingRecipe recipe = RecipeSerializer.BLASTING_RECIPE.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, BlastingRecipe recipe) {
            RecipeSerializer.BLASTING_RECIPE.toNetwork(buffer, recipe);
        }
    }

    public static class StoneCutterSerializer implements RecipeSerializer<StonecutterRecipe> {

        @Override
        public StonecutterRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            StonecutterRecipe recipe = RecipeSerializer.STONECUTTER.fromJson(recipeId, json);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Nullable
        @Override
        public StonecutterRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            StonecutterRecipe recipe = RecipeSerializer.STONECUTTER.fromNetwork(recipeId, buffer);
            return checkIngredients(recipe.getIngredients()) && checkItemStack(recipe.getResultItem()) ? recipe : null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StonecutterRecipe recipe) {
            RecipeSerializer.STONECUTTER.toNetwork(buffer, recipe);
        }
    }
}
