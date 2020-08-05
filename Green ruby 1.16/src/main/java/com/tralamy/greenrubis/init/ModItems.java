package com.tralamy.greenrubis.init;

import com.tralamy.greenrubis.GreenRubis;
import com.tralamy.greenrubis.items.BlockItemBase;
import com.tralamy.greenrubis.items.ItemBase;
import com.tralamy.greenrubis.items.rubyItem;
import com.tralamy.greenrubis.util.enums.ModArmorTier;
import com.tralamy.greenrubis.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GreenRubis.MODE_ID);


    /* Items */
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", rubyItem::new);


    /* Tools */
    public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY,7,0f, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY,2,0f, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY,9,0f, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<ShovelItem> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY,2,0f, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModItemTier.RUBY,1,0f, new Item.Properties().group(ItemBase.TAB)));


    /* Armor */
    public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorTier.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorTier.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorTier.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(ItemBase.TAB)));

    public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorTier.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(ItemBase.TAB)));


    /*Blocks item*/
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
            () -> new BlockItemBase(ModBlocks.RUBY_BLOCK.get()));

    public static final RegistryObject<Item> RUBY_ORE_OVERWORLD_ITEM = ITEMS.register("ruby_ore_overworld",
            () -> new BlockItemBase(ModBlocks.RUBY_ORE_OVERWORLD.get()));

    public static final RegistryObject<Item> RUBY_ORE_NETHER_ITEM = ITEMS.register("ruby_ore_nether",
            () -> new BlockItemBase(ModBlocks.RUBY_ORE_NETHER.get()));

    public static final RegistryObject<Item> RUBY_ORE_END_ITEM = ITEMS.register("ruby_ore_end",
            () -> new BlockItemBase(ModBlocks.RUBY_ORE_END.get()));

}
