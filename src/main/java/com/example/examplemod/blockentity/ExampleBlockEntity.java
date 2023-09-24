package com.example.examplemod.blockentity;

import com.example.examplemod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ExampleBlockEntity extends BlockEntity {

    private int count = 0;

    public ExampleBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityInit.EXAMPLE_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.count = pTag.getInt("count");
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putInt("count", this.count);
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int nun){
        this.count = nun;
    }
}
