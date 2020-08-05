package com.tralamy.greenrubis;

import com.tralamy.greenrubis.init.ModBlocks;
import com.tralamy.greenrubis.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
// The val  ue here should match an entry in the META-INF/mods.toml file
@Mod("greenrubis")
public class GreenRubis
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODE_ID = "greenrubis";

    public GreenRubis() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }
    private void doClientStuff(final FMLClientSetupEvent event) { }

    private void init()
    {
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
