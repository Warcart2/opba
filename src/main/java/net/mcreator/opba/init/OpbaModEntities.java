
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.opba.entity.ToxicBacteriaWEntity;
import net.mcreator.opba.entity.SukeExternalInvisWEntity;
import net.mcreator.opba.entity.StandTestEntity;
import net.mcreator.opba.entity.RaigoWEntity;
import net.mcreator.opba.entity.MarineSoldierEntity;
import net.mcreator.opba.entity.FreshFireWEntity;
import net.mcreator.opba.entity.ElThorWEntity;
import net.mcreator.opba.OpbaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, OpbaMod.MODID);
	public static final RegistryObject<EntityType<ElThorWEntity>> EL_THOR_W = register("projectile_el_thor_w",
			EntityType.Builder.<ElThorWEntity>of(ElThorWEntity::new, MobCategory.MISC).setCustomClientFactory(ElThorWEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ToxicBacteriaWEntity>> TOXIC_BACTERIA_W = register("projectile_toxic_bacteria_w",
			EntityType.Builder.<ToxicBacteriaWEntity>of(ToxicBacteriaWEntity::new, MobCategory.MISC).setCustomClientFactory(ToxicBacteriaWEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RaigoWEntity>> RAIGO_W = register("projectile_raigo_w",
			EntityType.Builder.<RaigoWEntity>of(RaigoWEntity::new, MobCategory.MISC).setCustomClientFactory(RaigoWEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MarineSoldierEntity>> MARINE_SOLDIER = register("marine_soldier",
			EntityType.Builder.<MarineSoldierEntity>of(MarineSoldierEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MarineSoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SukeExternalInvisWEntity>> SUKE_EXTERNAL_INVIS_W = register("projectile_suke_external_invis_w", EntityType.Builder.<SukeExternalInvisWEntity>of(SukeExternalInvisWEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SukeExternalInvisWEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StandTestEntity>> STAND_TEST = register("stand_test", EntityType.Builder.<StandTestEntity>of(StandTestEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(StandTestEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FreshFireWEntity>> FRESH_FIRE_W = register("projectile_fresh_fire_w",
			EntityType.Builder.<FreshFireWEntity>of(FreshFireWEntity::new, MobCategory.MISC).setCustomClientFactory(FreshFireWEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			MarineSoldierEntity.init();
			StandTestEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(MARINE_SOLDIER.get(), MarineSoldierEntity.createAttributes().build());
		event.put(STAND_TEST.get(), StandTestEntity.createAttributes().build());
	}
}
