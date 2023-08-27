
package net.mcreator.opba.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.opba.world.inventory.AbilityChooseMicroSaikinMenu;
import net.mcreator.opba.procedures.ToxicBacteriaEquipProcedure;
import net.mcreator.opba.procedures.SlotChoosingProcedure;
import net.mcreator.opba.procedures.SemipointProcedure;
import net.mcreator.opba.procedures.SaikinSecondGearEquipProcedure;
import net.mcreator.opba.procedures.BasicPointProcedure;
import net.mcreator.opba.procedures.BacterialPointProcedure;
import net.mcreator.opba.OpbaMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AbilityChooseMicroSaikinButtonMessage {
	private final int buttonID, x, y, z;

	public AbilityChooseMicroSaikinButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AbilityChooseMicroSaikinButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AbilityChooseMicroSaikinButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AbilityChooseMicroSaikinButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AbilityChooseMicroSaikinMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SlotChoosingProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ToxicBacteriaEquipProcedure.execute(entity);
		}
		if (buttonID == 2) {

			SaikinSecondGearEquipProcedure.execute(entity);
		}
		if (buttonID == 3) {

			BacterialPointProcedure.execute(entity);
		}
		if (buttonID == 4) {

			SemipointProcedure.execute(entity);
		}
		if (buttonID == 5) {

			BasicPointProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		OpbaMod.addNetworkMessage(AbilityChooseMicroSaikinButtonMessage.class, AbilityChooseMicroSaikinButtonMessage::buffer, AbilityChooseMicroSaikinButtonMessage::new, AbilityChooseMicroSaikinButtonMessage::handler);
	}
}
