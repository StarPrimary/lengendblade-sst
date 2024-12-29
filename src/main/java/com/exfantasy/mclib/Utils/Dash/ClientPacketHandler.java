package com.exfantasy.mclib.Utils.Dash;


import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.network.DemonBladeMessage;
import com.dinzeer.legendblade.network.DemonBladeMessageA;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.PacketDistributor;

import static com.exfantasy.mclib.Utils.Dash.DashMessage.vmove;

public class ClientPacketHandler {
    public static void handledash(DashMessage msg){

        LivingEntity entity = Minecraft.getInstance().player;
        vmove(entity, msg.dy, msg.dashDistance);
    }
    public static void sendDemonBladeMessage(Player player) {
        DemonBladeMessage msg = new DemonBladeMessage(player.getId());
        Legendblade.INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
 }
 public static void sendDemonBladeMessageA(Player player) {
        DemonBladeMessageA msg = new DemonBladeMessageA(player.getId());
        Legendblade.INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
 }
}
