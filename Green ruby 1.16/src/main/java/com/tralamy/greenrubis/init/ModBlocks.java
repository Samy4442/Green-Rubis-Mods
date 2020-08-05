package com.tralamy.greenrubis.init;

import com.tralamy.greenrubis.GreenRubis;
import com.tralamy.greenrubis.blocks.RubyBlock;
import com.tralamy.greenrubis.blocks.RubyOre;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GreenRubis.MODE_ID);

    /* Blocks */
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<OreBlock> RUBY_ORE_OVERWORLD = BLOCKS.register("ruby_ore_overworld", RubyOre::new);
    public static final RegistryObject<OreBlock> RUBY_ORE_NETHER = BLOCKS.register("ruby_ore_nether", RubyOre::new);
    public static final RegistryObject<OreBlock> RUBY_ORE_END = BLOCKS.register("ruby_ore_end", RubyOre::new);
}
