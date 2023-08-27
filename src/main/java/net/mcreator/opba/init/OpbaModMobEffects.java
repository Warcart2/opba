
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.opba.potion.MetalizedMobEffect;
import net.mcreator.opba.potion.MeditationMobEffect;
import net.mcreator.opba.potion.IronWitheringMobEffect;
import net.mcreator.opba.potion.FatigueMobEffect;
import net.mcreator.opba.potion.DeathMobEffect;
import net.mcreator.opba.potion.BlockedMobEffect;
import net.mcreator.opba.OpbaMod;

public class OpbaModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, OpbaMod.MODID);
	public static final RegistryObject<MobEffect> METALIZED = REGISTRY.register("metalized", () -> new MetalizedMobEffect());
	public static final RegistryObject<MobEffect> MEDITATION = REGISTRY.register("meditation", () -> new MeditationMobEffect());
	public static final RegistryObject<MobEffect> BLOCKED = REGISTRY.register("blocked", () -> new BlockedMobEffect());
	public static final RegistryObject<MobEffect> IRON_WITHERING = REGISTRY.register("iron_withering", () -> new IronWitheringMobEffect());
	public static final RegistryObject<MobEffect> DEATH = REGISTRY.register("death", () -> new DeathMobEffect());
	public static final RegistryObject<MobEffect> FATIGUE = REGISTRY.register("fatigue", () -> new FatigueMobEffect());
}
