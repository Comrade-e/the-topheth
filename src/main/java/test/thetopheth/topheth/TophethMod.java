package test.thetopheth.topheth;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import test.thetopheth.topheth.blocks.Stones;
import test.thetopheth.topheth.blocks.TophethBlocksInitializer;

import static test.thetopheth.topheth.blocks.Stones.*;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TophethMod.MODID)
public class TophethMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "topheth";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "topheth" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> TOPHETH_TAB;
    public TophethMod(IEventBus modEventBus, ModContainer modContainer)
    {

        BLOCKS.register(modEventBus);

        ITEMS.register(modEventBus);

        TophethBlocksInitializer.init();

        TOPHETH_TAB = CREATIVE_MODE_TABS.register("topheth", () -> CreativeModeTab.builder()
                .build());

        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::addItemsToCreativeTab);


        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        /// NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void addItemsToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == TOPHETH_TAB.get()) {
            event.accept(TOPHETH_STONE_ITEM);
            event.accept(TOPHETH_STONE_BRICKS_ITEM);
            event.accept(IMMOLATED_GLOWSTONE_ITEM);
        }
    }

}
