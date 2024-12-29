package com.dinzeer.legendblade.specialeffects.versionone;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versionone.Swordone;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Liulione extends SpecialEffect {
    public Liulione() {
        super(60,false,false);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
        if(ModList.get().isLoaded(SlashBladeAddon.MODID)) {
            ISlashBladeState state = event.getSlashBladeState();
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Liulione.getId())) {
                if (!(event.getUser() instanceof Player)) {
                    return;
                }

                Player player = (Player)event.getUser();
                RandomSource random = player.getRandom();
                int level = player.experienceLevel;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Liulione.get(), level)) {
                     Swordone.doSlash(player,false,2,2F,Vec3.ZERO);

                }
            }
        }
    }
}
