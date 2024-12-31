package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.Config;
import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.SevenSkillField;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.other.LBSounds;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitry;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import dev.xkmc.l2library.serial.advancements.AdvancementGenerator;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
@Mod.EventBusSubscriber
public class Sevenbladeslash {
    @SubscribeEvent
    public static void kill(LivingDeathEvent event){
        if (event.getSource().getEntity() instanceof Player player){
            if (player.getMainHandItem().getTag()==null)return;
            if( SlashbladeUtils.getStringNBT(player.getMainHandItem().getTag(),"translationKey").equals("item.legendblade.sevensword")){
                if (player.getMainHandItem().getOrCreateTag().contains("SACooldwon")){
                    player.getMainHandItem().getOrCreateTag().putInt("SACooldwon", player.getMainHandItem().getOrCreateTag().getInt("SACooldwon")-1);
                }
            }
        }
    }

    private static final Random random = new Random();
    public static void doSlash(LivingEntity playerIn, float speed) {
        ItemStack mainHandItem = playerIn.getMainHandItem();
if (Config.sevenbladesKill){
        if (!mainHandItem.getOrCreateTag().contains("SACooldwon") || mainHandItem.getOrCreateTag().getInt("SACooldwon") <= 0) {
            playerIn.hurt(new DamageSource(playerIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), playerIn), 4);
            mainHandItem.getOrCreateTag().putInt("SACooldwon", 40);
            playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.SUMERU.get(), 200, 5));
            playerIn.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 3));
            playerIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 3));
            LBComboRegsitry.swordoneex.get().tickAction(playerIn);
            SevenSkillField sevenSkillField = new SevenSkillField(LBEntiteRegristrys.ma, playerIn.level());
            var pos = EntityPointer.raycastForEntityTo(playerIn.level(), playerIn, 10, false);
            playerIn.level().addFreshEntity(sevenSkillField);
            sevenSkillField.setDuring(110);
            sevenSkillField.setDamage((float) ((LivingEntity) playerIn).getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.1f);
            sevenSkillField.setPos(Objects.requireNonNullElse(pos, playerIn).getOnPos().getCenter().add(0, 5, 0));
            sevenSkillField.setOwner(playerIn);
            sevenSkillField.setSIZE(8);

        }else
        {
            playerIn.sendSystemMessage(Component.translatable("message.seven_sword_cooldown",mainHandItem.getOrCreateTag().getInt("SACooldwon")));
            playerIn.playSound(SoundEvents.ANVIL_PLACE);
        }
}else {
    playerIn.hurt(new DamageSource(playerIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), playerIn), 4);

    playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.SUMERU.get(), 200, 5));
    playerIn.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 3));
    playerIn.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 3));
    LBComboRegsitry.swordoneex.get().tickAction(playerIn);
    SevenSkillField sevenSkillField = new SevenSkillField(LBEntiteRegristrys.ma, playerIn.level());
    var pos = EntityPointer.raycastForEntityTo(playerIn.level(), playerIn, 10, false);
    playerIn.level().addFreshEntity(sevenSkillField);
    sevenSkillField.setDuring(110);
    sevenSkillField.setDamage((float) ((LivingEntity) playerIn).getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.4f);
    sevenSkillField.setPos(Objects.requireNonNullElse(pos, playerIn).getOnPos().getCenter().add(0, 5, 0));
    sevenSkillField.setOwner(playerIn);
    sevenSkillField.setSIZE(8);
}


    }
    @SubscribeEvent
    public static void tooltip(ItemTooltipEvent event){
        CompoundTag tag = event.getItemStack().getTag();
        if (tag!=null){
            if (tag.contains("SACooldwon")) {
                if (tag.getInt("SACooldwon") > 0) {
                    event.getToolTip().add(Component.translatable("message.seven_sword_cooldown", tag.getInt("SACooldwon")));
                }
            }
        }
    }

}
