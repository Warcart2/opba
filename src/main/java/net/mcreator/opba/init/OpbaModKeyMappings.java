
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.opba.network.ZAttackMessage;
import net.mcreator.opba.network.XAttackMessage;
import net.mcreator.opba.network.VAttackMessage;
import net.mcreator.opba.network.StandSummonMessage;
import net.mcreator.opba.network.OpenGuiChooseMessage;
import net.mcreator.opba.network.OpenFractionChooseMessage;
import net.mcreator.opba.network.FlybuttonMessage;
import net.mcreator.opba.network.CombSwitchMessage;
import net.mcreator.opba.network.BAttackMessage;
import net.mcreator.opba.OpbaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class OpbaModKeyMappings {
	public static final KeyMapping Z_ATTACK = new KeyMapping("key.opba.z_attack", GLFW.GLFW_KEY_Z, "key.categories.opbacombat");
	public static final KeyMapping X_ATTACK = new KeyMapping("key.opba.x_attack", GLFW.GLFW_KEY_X, "key.categories.opbacombat");
	public static final KeyMapping OPEN_GUI_CHOOSE = new KeyMapping("key.opba.open_gui_choose", GLFW.GLFW_KEY_Y, "key.categories.gameplay");
	public static final KeyMapping V_ATTACK = new KeyMapping("key.opba.v_attack", GLFW.GLFW_KEY_V, "key.categories.opbacombat");
	public static final KeyMapping B_ATTACK = new KeyMapping("key.opba.b_attack", GLFW.GLFW_KEY_B, "key.categories.opbacombat");
	public static final KeyMapping COMB_SWITCH = new KeyMapping("key.opba.comb_switch", GLFW.GLFW_KEY_RIGHT_SHIFT, "key.categories.opbacombat");
	public static final KeyMapping FLYBUTTON = new KeyMapping("key.opba.flybutton", GLFW.GLFW_KEY_SPACE, "key.categories.movement");
	public static final KeyMapping OPEN_FRACTION_CHOOSE = new KeyMapping("key.opba.open_fraction_choose", GLFW.GLFW_KEY_O, "key.categories.gameplay");
	public static final KeyMapping STAND_SUMMON = new KeyMapping("key.opba.stand_summon", GLFW.GLFW_KEY_L, "key.categories.opbacombat");
	private static long FLYBUTTON_LASTPRESS = 0;
	private static long STAND_SUMMON_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(Z_ATTACK);
		ClientRegistry.registerKeyBinding(X_ATTACK);
		ClientRegistry.registerKeyBinding(OPEN_GUI_CHOOSE);
		ClientRegistry.registerKeyBinding(V_ATTACK);
		ClientRegistry.registerKeyBinding(B_ATTACK);
		ClientRegistry.registerKeyBinding(COMB_SWITCH);
		ClientRegistry.registerKeyBinding(FLYBUTTON);
		ClientRegistry.registerKeyBinding(OPEN_FRACTION_CHOOSE);
		ClientRegistry.registerKeyBinding(STAND_SUMMON);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == Z_ATTACK.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new ZAttackMessage(0, 0));
						ZAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == X_ATTACK.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new XAttackMessage(0, 0));
						XAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == OPEN_GUI_CHOOSE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new OpenGuiChooseMessage(0, 0));
						OpenGuiChooseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == V_ATTACK.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new VAttackMessage(0, 0));
						VAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == B_ATTACK.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new BAttackMessage(0, 0));
						BAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == COMB_SWITCH.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new CombSwitchMessage(0, 0));
						CombSwitchMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == FLYBUTTON.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new FlybuttonMessage(0, 0));
						FlybuttonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
						FLYBUTTON_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - FLYBUTTON_LASTPRESS);
						OpbaMod.PACKET_HANDLER.sendToServer(new FlybuttonMessage(1, dt));
						FlybuttonMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == OPEN_FRACTION_CHOOSE.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new OpenFractionChooseMessage(0, 0));
						OpenFractionChooseMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == STAND_SUMMON.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						OpbaMod.PACKET_HANDLER.sendToServer(new StandSummonMessage(0, 0));
						StandSummonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
						STAND_SUMMON_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - STAND_SUMMON_LASTPRESS);
						OpbaMod.PACKET_HANDLER.sendToServer(new StandSummonMessage(1, dt));
						StandSummonMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
			}
		}
	}
}
