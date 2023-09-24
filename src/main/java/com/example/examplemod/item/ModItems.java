package com.example.examplemod.item;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.item.custom.TinWand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_RAW = ITEMS.register("tin_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<TinWand> TIN_WAND = ITEMS.register("tin_wand", () -> new TinWand(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
