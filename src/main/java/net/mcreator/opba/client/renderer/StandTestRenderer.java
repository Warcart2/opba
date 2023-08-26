
package net.mcreator.opba.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.opba.entity.StandTestEntity;
import net.mcreator.opba.client.model.Modelmarine;

public class StandTestRenderer extends MobRenderer<StandTestEntity, Modelmarine<StandTestEntity>> {
	public StandTestRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmarine(context.bakeLayer(Modelmarine.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(StandTestEntity entity) {
		return new ResourceLocation("opba:textures/entities/marine.png");
	}
}
