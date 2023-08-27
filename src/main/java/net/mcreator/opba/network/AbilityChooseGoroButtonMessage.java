
package net.mcreator.opba.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.opba.world.inventory.AbilityChooseGoroMenu;
import net.mcreator.opba.procedures.VoltageSet200mProcedure;
import net.mcreator.opba.procedures.VoltageSet100mProcedure;
import net.mcreator.opba.procedures.SlotChoosingProcedure;
import net.mcreator.opba.procedures.RaigoEquipingProcedure;
import net.mcreator.opba.procedures.ElThorEqupingProcedure;
import net.mcreator.opba.procedures.DevoltageProcedure;
import net.mcreator.opba.OpbaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbilityChooseGoroButtonMessage {
	private final int buttonID, x, y, z;

	public AbilityChooseGoroButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AbilityChooseGoroButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AbilityChooseGoroButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AbilityChooseGoroButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = AbilityChooseGoroMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ElThorEqupingProcedure.execute(entity);
		}
		if (buttonID == 1) {

			RaigoEquipingProcedure.execute(entity);
		}
		if (buttonID == 2) {

			VoltageSet100mProcedure.execute(entity);
		}
		if (buttonID == 3) {

			VoltageSet200mProcedure.execute(entity);
		}
		if (buttonID == 4) {

			DevoltageProcedure.execute(entity);
		}
		if (buttonID == 5) {

			SlotChoosingProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		OpbaMod.addNetworkMessage(AbilityChooseGoroButtonMessage.class, AbilityChooseGoroButtonMessage::buffer, AbilityChooseGoroButtonMessage::new, AbilityChooseGoroButtonMessage::handler);
	}
}
