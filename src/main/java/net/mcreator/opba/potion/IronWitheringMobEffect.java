
package net.mcreator.opba.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.opba.procedures.IronWitheringOnEffectActiveTickProcedure;

public class IronWitheringMobEffect extends MobEffect {
	public IronWitheringMobEffect() {
		super(MobEffectCategory.HARMFUL, -13027015);
	}

	@Override
	public String getDescriptionId() {
		return "effect.opba.iron_withering";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		IronWitheringOnEffectActiveTickProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
