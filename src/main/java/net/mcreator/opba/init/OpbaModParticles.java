
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

import net.mcreator.opba.client.particle.SaikinInvunerabilityParticle;
import net.mcreator.opba.client.particle.RaigoCloudsParticle;
import net.mcreator.opba.client.particle.GoroInvunerabilityParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OpbaModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) OpbaModParticleTypes.GORO_INVUNERABILITY.get(), GoroInvunerabilityParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) OpbaModParticleTypes.SAIKIN_INVUNERABILITY.get(), SaikinInvunerabilityParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) OpbaModParticleTypes.RAIGO_CLOUDS.get(), RaigoCloudsParticle::provider);
	}
}
