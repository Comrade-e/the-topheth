package test.thetopheth.topheth.blocks;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.neoforge.registries.DeferredBlock;

import static test.thetopheth.topheth.TophethMod.BLOCKS;

public class TophethPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    public static final BooleanProperty ENTRANCE = BooleanProperty.create("entrance");

    public static DeferredBlock<TophethPortalBlock>  TOPHETH_PORTAL_BLOCK;

    public TophethPortalBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        registerDefaultState(stateDefinition.any().setValue(AXIS, Direction.Axis.X).setValue(ENTRANCE, true));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AXIS, ENTRANCE);
    }

    static void init() {
        TOPHETH_PORTAL_BLOCK = BLOCKS.registerBlock(
                "topheth_portal",
                props -> new TophethPortalBlock(props
                        .noCollission()
                        .strength(0.0f)
                        .destroyTime(-1.0f)
                        .explosionResistance(9999999999.0f)
                        .sound(SoundType.STONE)
                        .isRedstoneConductor((state, world, pos) -> false)
                        .lightLevel(state -> 15)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(AXIS, context.getHorizontalDirection().getAxis())
                .setValue(ENTRANCE, true);
    }
}
