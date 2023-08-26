
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.opba.client.renderer.StandTestRenderer;
import net.mcreator.opba.client.renderer.RaigoWRenderer;
import net.mcreator.opba.client.renderer.MarineSoldierRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OpbaModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(OpbaModEntities.EL_THOR_W.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.TOXIC_BACTERIA_W.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.RAIGO_W.get(), RaigoWRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.MARINE_SOLDIER.get(), MarineSoldierRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.SUKE_EXTERNAL_INVIS_W.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.STAND_TEST.get(), StandTestRenderer::new);
		event.registerEntityRenderer(OpbaModEntities.FRESH_FIRE_W.get(), ThrownItemRenderer::new);
	}
}
