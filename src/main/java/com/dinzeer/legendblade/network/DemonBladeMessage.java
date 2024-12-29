package com.dinzeer.legendblade.network;

import com.dinzeer.legendblade.entity.DemonBladeFragments;
import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class DemonBladeMessage {

    private final int entityId;

    public DemonBladeMessage(int entityId) {
        this.entityId = entityId;
    }

    public DemonBladeMessage(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(entityId);
    }

    public static void handle(DemonBladeMessage msg, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        LogicalSide side = context.getDirection().getReceptionSide();

        if (side == LogicalSide.SERVER) {
            context.enqueueWork(() -> apply(context.getSender()));
        }
        ctx.get().setPacketHandled(true);
    }

    public static void apply(LivingEntity entity) {
        ItemStack stack = entity.getMainHandItem();
        CompoundTag tag = stack.getTag();

        if (tag == null || !SlashbladeUtils.getStringNBT(tag, "translationKey").equals("item.legendblade.sevensword")) {
            return;
        }

        BlockPos center = entity.getOnPos();
        Level level = entity.level();
        List<Entity> entitiesFound = level.getEntitiesOfClass(Entity.class, new AABB(center).inflate(4 / 2d), a -> true)
                .stream()
                .sorted(Comparator.comparingDouble(ent -> ent.distanceToSqr(center.getCenter())))
                .toList();

        boolean hasFragments = false;
        for (Entity entity2 : entitiesFound) {
            if (entity2 instanceof DemonBladeFragments demonBladeFragments) {
                if (!demonBladeFragments.isBack()) {
                    demonBladeFragments.setFire(true);
                    hasFragments = true;
                }
            }
        }

        if (!hasFragments) {
            int count = 15;

            for (int i = 0; i < count; i++)
            {
                int colorCode = entity.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
                DemonBladeFragments ss = new DemonBladeFragments(LBEntiteRegristrys.dbf, level);

                level.addFreshEntity(ss);

                ss.setSpeed(2.2f);
                ss.setIsCritical(false);
                ss.setOwner(entity);
                ss.setColor(colorCode);
                ss.setRoll(0);
                ss.setDamage(entity.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.9f);
                // force riding
                ss.startRiding(entity, true);

                ss.setDelay(40);

                boolean isRight = i % 2 == 0;
                RandomSource random = level.getRandom();

                double xOffset = random.nextDouble() * 2.5 * (isRight ? 1 : -1);
                double yOffset = random.nextFloat() * 2;
                double zOffset = random.nextFloat() * 0.5;

                ss.setPos(entity.position().add(xOffset, yOffset, zOffset));
                ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                entity.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
            }
        }
    }
}