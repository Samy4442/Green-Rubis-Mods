package com.tralamy.greenrubis.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class rubyItem extends Item {
    public rubyItem() {
        super(new Item.Properties()
                .group(ItemBase.TAB)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(2.4f)
                        .effect(() -> new EffectInstance(Effects.REGENERATION, 15*20, 1), 1)
                        .effect(() -> new EffectInstance(Effects.ABSORPTION, 15*20, 1), 1)
                        .effect(() -> new EffectInstance(Effects.LUCK, 15*20, 4), 0.15f)
                        .setAlwaysEdible()
                        .meat()
                        .build()
                    )
        );
    }
}
