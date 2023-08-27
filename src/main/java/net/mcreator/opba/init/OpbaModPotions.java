
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.opba.OpbaMod;

public class OpbaModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, OpbaMod.MODID);
	public static final RegistryObject<Potion> METALIZED_POTION = REGISTRY.register("metalized_potion", () -> new Potion(new MobEffectInstance(OpbaModMobEffects.METALIZED.get(), 3600, 1, false, true)));
}
