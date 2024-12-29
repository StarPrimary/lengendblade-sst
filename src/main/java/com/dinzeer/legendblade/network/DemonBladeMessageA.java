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
public class DemonBladeMessageA {
    private final int entityId;

    public DemonBladeMessageA(int entityId) {
        this.entityId = entityId;
    }

    public DemonBladeMessageA(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(entityId);
    }

    public static void handle(DemonBladeMessageA msg, Supplier<NetworkEvent.Context> ctx) {
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
        List<Entity> entitiesFound = level.getEntitiesOfClass(Entity.class, new AABB(center).inflate(25 / 2d), a -> true)
                .stream()
                .sorted(Comparator.comparingDouble(ent -> ent.distanceToSqr(center.getCenter())))
                .toList();

        for (Entity entity2 : entitiesFound) {
            if (entity2 instanceof DemonBladeFragments demonBladeFragments) {
                if (!demonBladeFragments.isBack()) {
                    demonBladeFragments.setisBack(true);
                    demonBladeFragments.setPos(demonBladeFragments.position().add(new Vec3(0, 1.5, 0)));
                    demonBladeFragments.setDelay(60);
                    demonBladeFragments.setEverFire(false);
                    demonBladeFragments.setFire(true);

                }

            }
        }


    }
}
