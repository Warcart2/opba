
package net.mcreator.opba.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.opba.entity.MarineSoldierEntity;
import net.mcreator.opba.client.model.Modelmarine;

public class MarineSoldierRenderer extends MobRenderer<MarineSoldierEntity, Modelmarine<MarineSoldierEntity>> {
	public MarineSoldierRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmarine(context.bakeLayer(Modelmarine.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MarineSoldierEntity entity) {
		return new ResourceLocation("opba:textures/entities/marine.png");
	}
}
