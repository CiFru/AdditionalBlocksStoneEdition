package com.supermartijn642.additionalblocks.stone;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AbItemGroup extends ItemGroup {
    public AbItemGroup() {
        super("abstoneedition");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(AdditionalBlocks.marble_bricks);
    }

    @Override
    public void fillItemList(NonNullList<ItemStack> items) {
        super.fillItemList(items);
        items.sort((a,b) -> {
            int indexA = a.getItem() instanceof BlockItem ?
                    ((BlockItem) a.getItem()).getBlock() instanceof IItemGroupIndex ? ((IItemGroupIndex) ((BlockItem) a.getItem()).getBlock()).getItemGroupIndex() : -1 :
                            a.getItem() instanceof IItemGroupIndex ? ((IItemGroupIndex) a.getItem()).getItemGroupIndex() : -1;
            int indexB = b.getItem() instanceof BlockItem ?
                    ((BlockItem) b.getItem()).getBlock() instanceof IItemGroupIndex ? ((IItemGroupIndex) ((BlockItem) b.getItem()).getBlock()).getItemGroupIndex() : -1 :
                    b.getItem() instanceof IItemGroupIndex ? ((IItemGroupIndex) b.getItem()).getItemGroupIndex() : -1;
            if(indexA != indexB)
                return indexA - indexB;
            String nameA = a.getHoverName().getString();
            String nameB = b.getHoverName().getString();
            int names = nameA.compareTo(nameB);
            return names;
        });
    }
}
