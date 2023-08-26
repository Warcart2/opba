
package net.mcreator.opba.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FatigueMobEffect extends MobEffect {
	public FatigueMobEffect() {
		super(MobEffectCategory.HARMFUL, -9079435);
	}

	@Override
	public String getDescriptionId() {
		return "effect.opba.fatigue";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
