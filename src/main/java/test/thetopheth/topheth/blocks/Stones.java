package test.thetopheth.topheth.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static test.thetopheth.topheth.TophethMod.BLOCKS;
import static test.thetopheth.topheth.TophethMod.ITEMS;

public class Stones {

    public static DeferredBlock<Block> TOPHETH_STONE_BRICKS;
    public static DeferredItem<BlockItem> TOPHETH_STONE_ITEM;
    public static DeferredBlock<Block> TOPHETH_STONE;
    public static DeferredItem<BlockItem> TOPHETH_STONE_BRICKS_ITEM;
    public static DeferredBlock<Block> IMMOLATED_GLOWSTONE;
    public static DeferredItem<BlockItem> IMMOLATED_GLOWSTONE_ITEM;


    static void init() {
        TOPHETH_STONE = BLOCKS.registerBlock(
                "topheth_stone", (props -> new Block(props
                        .destroyTime(4.0f)
                        .explosionResistance(312.0f)
                        .requiresCorrectToolForDrops()
                        .lightLevel(state -> 0)
                        .sound(SoundType.STONE)
                        .pushReaction(PushReaction.NORMAL)
                        .isRedstoneConductor((state, world, pos) -> true)
                )));

        TOPHETH_STONE_ITEM = ITEMS.registerSimpleBlockItem("topheth_stone"
                , TOPHETH_STONE);

        TOPHETH_STONE_BRICKS = BLOCKS.registerBlock(
                "topheth_stone_bricks",
                (props) -> new Block(
                        props
                                .destroyTime(4.4f)
                                .explosionResistance(312.0f)
                                .requiresCorrectToolForDrops()
                                .lightLevel(state -> 0)
                                .sound(SoundType.STONE)
                                .pushReaction(PushReaction.NORMAL)
                                .isRedstoneConductor((state, world, pos) -> true)
                ));
        TOPHETH_STONE_BRICKS_ITEM = ITEMS.registerSimpleBlockItem("topheth_stone_bricks"
                , TOPHETH_STONE_BRICKS);

        IMMOLATED_GLOWSTONE = BLOCKS.registerBlock(
                "immolated_glowstone",
                (props) -> new Block(
                        props
                                .destroyTime(0.1488f)
                                .explosionResistance(1.0f)
                                .lightLevel(state -> 15)
                                .sound(SoundType.GLASS)
                                .pushReaction(PushReaction.DESTROY)
                                .instabreak()
                                .isRedstoneConductor((state, world, pos) -> false)));

        IMMOLATED_GLOWSTONE_ITEM = ITEMS.registerSimpleBlockItem(
                "immolated_glowstone", IMMOLATED_GLOWSTONE);
    }
}
