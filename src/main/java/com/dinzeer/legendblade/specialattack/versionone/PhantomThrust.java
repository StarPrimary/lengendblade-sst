package com.dinzeer.legendblade.specialattack.versionone;


import com.dinzeer.legendblade.Legendblade;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class PhantomThrust {

        public static void doSlash(LivingEntity playerIn, float speed,boolean what)
        {
            int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(ISlashBladeState::getColorCode).orElse(0xFF3333FF);
            doSlash(playerIn,speed);
        }

        public static void doSlash(LivingEntity playerIn, float speed) {
            playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.HIT_DAMAGE.get(),50,2));
            SMoveUtil.sendDashMessage((Player) playerIn,0,speed);




        }


    public static void doSlash(LivingEntity playerIn, float speed,int tyr) {

        SMoveUtil.sendDashMessage((Player) playerIn,0,speed);




    }



    }


