
package net.mcreator.opba.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MetalizedMobEffect extends MobEffect {
	public MetalizedMobEffect() {
		super(MobEffectCategory.HARMFUL, -6710887);
	}

	@Override
	public String getDescriptionId() {
		return "effect.opba.metalized";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
