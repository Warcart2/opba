
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.opba.OpbaMod;

public class OpbaModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, OpbaMod.MODID);
	public static final RegistryObject<ParticleType<?>> GORO_INVUNERABILITY = REGISTRY.register("goro_invunerability", () -> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<?>> SAIKIN_INVUNERABILITY = REGISTRY.register("saikin_invunerability", () -> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<?>> RAIGO_CLOUDS = REGISTRY.register("raigo_clouds", () -> new SimpleParticleType(false));
}
