package com.dinzeer.legendblade.specialeffects.compat.l2hostily;

import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import dev.xkmc.l2hostility.content.item.curio.curse.CurseOfWrath;
import dev.xkmc.l2hostility.content.logic.DifficultyLevel;
import dev.xkmc.l2hostility.init.L2Hostility;
import dev.xkmc.l2hostility.init.data.LHConfig;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import static com.dinzeer.legendblade.Legendblade.MODID;

@Mod.EventBusSubscriber
public class Ark extends SpecialEffect {


    public Ark() {
        super(100,true,true);

    }
    @SubscribeEvent
    public static void apply(LivingDamageEvent event) {
        if(!ModList.get().isLoaded(L2Hostility.MODID))return;
        if (event.getSource().getEntity() instanceof Player player) {
        if (SlashbladeUtils.hasSpecialEffect(player.getMainHandItem(),MODID+":ark")){
                int level = DifficultyLevel.ofAny(event.getEntity()) - DifficultyLevel.ofAny(player);
                if (level > 0) {
                    double rate = (Double) LHConfig.COMMON.wrathDamageBonus.get();
                    event.setAmount(event.getAmount()* ((float) (1.0 + (double) level * rate)));
                }
            }
        }
    }

}
