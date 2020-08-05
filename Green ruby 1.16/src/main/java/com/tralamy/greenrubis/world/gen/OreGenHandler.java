package com.tralamy.greenrubis.world.gen;

import com.tralamy.greenrubis.GreenRubis;
import com.tralamy.greenrubis.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = GreenRubis.MODE_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGenHandler {

    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone", new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event)
    {
        for (Biome biome :
                ForgeRegistries.BIOMES)
        {
            if(biome.getCategory() == Biome.Category.NETHER) // Nether Gen
            {
                genOre(biome, 7, 5 ,5, 90+5, OreFeatureConfig.FillerBlockType.NETHERRACK,
                        ModBlocks.RUBY_ORE_NETHER.get().getDefaultState(), 4);
            }
            else if(biome.getCategory() == Biome.Category.THEEND) // End
            {
                genOre(biome, 8, 5 ,5, 90+5, END_STONE,
                        ModBlocks.RUBY_ORE_END.get().getDefaultState(), 3);
            }
            else // World gen
            {
                genOre(biome, 6, 8 ,5, 9+5, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        ModBlocks.RUBY_ORE_OVERWORLD.get().getDefaultState(), 5);
            }
        }
    }

    private static void genOre(Biome biome,int count, int bottomOffset, int topOffset, int max,
                               OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size)
    {
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig featureConfig = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement configuredPlacement = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(featureConfig).withPlacement(configuredPlacement));
    }
}
