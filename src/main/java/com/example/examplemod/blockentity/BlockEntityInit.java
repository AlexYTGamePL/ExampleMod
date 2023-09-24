package com.example.examplemod.blockentity;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {

    public static final DeferredRegister<BlockEntityType<?>> ENTITY_BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<ExampleBlockEntity>> EXAMPLE_BLOCK_ENTITY
            = ENTITY_BLOCKS.register("example_block_entity", () -> BlockEntityType.Builder.of(ExampleBlockEntity::new,
            ModBlocks.EXAMPLE_ENTITY_BLOCK.get()
    ).build(null));

}
