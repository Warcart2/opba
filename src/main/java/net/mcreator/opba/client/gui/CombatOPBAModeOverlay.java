
package net.mcreator.opba.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.client.Minecraft;

import net.mcreator.opba.procedures.FuelViewProcedure;
import net.mcreator.opba.procedures.CombatOPBAModeDisplayOverlayIngameProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class CombatOPBAModeOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level;
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			if (CombatOPBAModeDisplayOverlayIngameProcedure.execute(entity)) {
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.opba.combat_opba_mode.label_cooldown_varintegercooldown"), posX + -207, posY + -112, -65536);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.opba.combat_opba_mode.label_stamina_varintegerstamina"), posX + 90, posY + -112, -16776961);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.opba.combat_opba_mode.label_level_varintegerlvl_var"), posX + -45, posY + -40, -16711936);
				if (FuelViewProcedure.execute(entity))
					Minecraft.getInstance().font.draw(event.getMatrixStack(), new TranslatableComponent("gui.opba.combat_opba_mode.label_varcyborgfueltype_varinteg"), posX + 90, posY + -94, -16776961);
			}
		}
	}
}
