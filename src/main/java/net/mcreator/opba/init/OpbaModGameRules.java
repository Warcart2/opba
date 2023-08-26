
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> PERMANENTSHICHIBUKAI = GameRules.register("permanentShichibukai", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
