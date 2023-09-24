package com.example.examplemod.block;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.custom.ExampleBlockEntityBlock;
import com.example.examplemod.blockentity.ExampleBlockEntity;
import com.example.examplemod.item.ModItems;
import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);




    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    public static final RegistryObject<ExampleBlockEntityBlock> EXAMPLE_ENTITY_BLOCK = registerBlock("example_entity_block",
            () -> new ExampleBlockEntityBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
