package com.tralamy.greenrubis.items;

import com.tralamy.greenrubis.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item {

    public final static ItemGroup TAB = new ItemGroup("GreenRubisTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };

    public ItemBase() {
        super(new Item.Properties().group(TAB));
    }
}
