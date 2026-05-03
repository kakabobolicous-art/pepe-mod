package com.pepe.webtrap;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WebTrapMod implements ModInitializer {
    
    private static long lastWebPlaceTime = 0;
    private static final long COOLDOWN_MS = 5000;

    @Override
    public void onInitialize() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && player instanceof PlayerEntity && entity instanceof LivingEntity) {
                handleAttack((PlayerEntity) player, (LivingEntity) entity, world);
            }
            return ActionResult.PASS;
        });
    }
    
    private static void handleAttack(PlayerEntity attacker, LivingEntity victim, World world) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWebPlaceTime < COOLDOWN_MS) return;
        
        int webSlot = findWebInHotbar(attacker);
        if (webSlot == -1) return;
        
        lastWebPlaceTime = currentTime;
        
        BlockPos targetPos = new BlockPos(
            MathHelper.floor(victim.getX()),
            MathHelper.floor(victim.getY() - 1),
            MathHelper.floor(victim.getZ())
        );
        
        int originalSlot = attacker.getInventory().selectedSlot;
        attacker.getInventory().selectedSlot = webSlot;
        tryPlaceWeb(attacker, world, targetPos);
        attacker.getInventory().selectedSlot = originalSlot;
    }
    
    private static int findWebInHotbar(PlayerEntity player) {
        for (int i = 0; i < 9; i++) {
            if (player.getInventory().getStack(i).getItem() == Items.COBWEB) {
                return i;
            }
        }
        return -1;
    }
    
    private static void tryPlaceWeb(PlayerEntity player, World world, BlockPos pos) {
        if (world.getBlockState(pos).getMaterial().isReplaceable()) {
            try {
                var hitResult = new net.minecraft.util.hit.BlockHitResult(
                    pos.toCenterPos(),
                    net.minecraft.util.math.Direction.UP,
                    pos,
                    false
                );
                world.getBlockState(pos).onUse(world, player, net.minecraft.util.Hand.MAIN_HAND, hitResult);
            } catch (Exception e) {}
        }
    }
}
