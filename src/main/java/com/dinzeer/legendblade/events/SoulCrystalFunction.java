package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.github.alexthe666.citadel.repack.jcodec.common.logging.Logger;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AdvancementHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SoulCrystalFunction {
    @SubscribeEvent
    public static void hitBladeShelf(SlashBladeEvent.BladeStandAttackEvent event){
        if (event.getDamageSource().getEntity() instanceof Player player){
            if (player.getMainHandItem().getItem() == LBModItems.soul_crystal.get()){
                event.setCanceled(true);
                ISlashBladeState slashBladeState = event.getSlashBladeState();

                swordoneEX(slashBladeState);
                slashBladeState.setKillCount(slashBladeState.getKillCount()+100);
                slashBladeState.setProudSoulCount(slashBladeState.getProudSoulCount()+300);
                slashBladeState.setRefine(slashBladeState.getRefine()+1);
                slashBladeState.setMaxDamage(slashBladeState.getMaxDamage()+1);
                slashBladeState.setColorCode(slashBladeState.getColorCode()+1);
                player.getMainHandItem().shrink(1);


        }
        }
    }


    public static void swordoneEX(ISlashBladeState slashBladeState){
        {
            int killcount=slashBladeState.getKillCount();
            int proudcount=slashBladeState.getProudSoulCount();
            int refine=slashBladeState.getRefine();
            SlashArts slashart=slashBladeState.getSlashArts();
            if (killcount>=20000){
                if (proudcount>=300000){
                    if(refine>=100){
                        if (LBslashArtRegsitry.swordone.get() == slashart){
                            slashBladeState.setSlashArtsKey(LBslashArtRegsitry.swordoneex.getId());
                        }
                    }
                }

            }
        }
    }



}


