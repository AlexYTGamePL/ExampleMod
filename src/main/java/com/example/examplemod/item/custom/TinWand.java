package com.example.examplemod.item.custom;

import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class TinWand extends Item {
    public TinWand(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, Player player) {

        player.setHealth(0.0f);

        return super.onDroppedByPlayer(item, player);
    }
}
