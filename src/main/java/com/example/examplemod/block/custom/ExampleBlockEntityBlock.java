package com.example.examplemod.block.custom;

import com.example.examplemod.blockentity.BlockEntityInit;
import com.example.examplemod.blockentity.ExampleBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleBlockEntityBlock extends HorizontalDirectionalBlock implements EntityBlock {


    public ExampleBlockEntityBlock(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return BlockEntityInit.EXAMPLE_BLOCK_ENTITY.get().create(pPos, pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(FACING);
    }

    @Override
    public @NotNull InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND){
            BlockEntity be = pLevel.getBlockEntity(pPos);
            if(be instanceof ExampleBlockEntity blockEntity){
                int count = blockEntity.getCount();
                blockEntity.setCount(count + 1);
                pPlayer.sendSystemMessage(Component.literal("Blok zostal użyty %d razy".formatted(blockEntity.getCount())));
                return InteractionResult.sidedSuccess(pLevel.isClientSide());
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
