
package net.mcreator.opba.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.opba.procedures.MeditationEffectExpiresProcedure;

public class MeditationMobEffect extends MobEffect {
	public MeditationMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -5046304);
	}

	@Override
	public String getDescriptionId() {
		return "effect.opba.meditation";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MeditationEffectExpiresProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
