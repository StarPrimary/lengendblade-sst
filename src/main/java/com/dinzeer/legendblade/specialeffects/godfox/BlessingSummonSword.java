package com.dinzeer.legendblade.specialeffects.godfox;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versionone.BlessingsummonSword;
import com.exfantasy.mclib.Utils.attrbute.GetplayerattrUtil;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BlessingSummonSword extends SpecialEffect {
    public BlessingSummonSword() {
        super(90,false,false);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.BlessingSummonSword.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BlessingSummonSword.get(), level)) {

                    BlessingsummonSword.doSlash(player,false, GetplayerattrUtil.getdamage(player),1F);


            }
        }

    }
}
