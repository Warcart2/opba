package net.mcreator.opba.procedures;

import org.checkerframework.checker.units.qual.Speed;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.opba.init.OpbaModMobEffects;

import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.List;
import java.util.Comparator;

public class RepelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Speed = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entityiterator.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.is(ItemTags.create(new ResourceLocation("opba:metal")))) {
								Speed = Speed + (itemstackiterator).getCount();
							}
						}
					}
				}
				entityiterator.setDeltaMovement(
						new Vec3((entity.getDeltaMovement().x() + (entityiterator.getX() - entity.getX()) * Speed), (entityiterator.getDeltaMovement().y()), (entity.getDeltaMovement().z() + (entityiterator.getZ() - entity.getZ()) * Speed)));
				if (entityiterator instanceof LivingEntity _livEnt ? _livEnt.hasEffect(OpbaModMobEffects.METALIZED.get()) : false) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("cut_inside").bypassArmor(),
								(float) Math.pow(5, entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(OpbaModMobEffects.METALIZED.get()) ? _livEnt.getEffect(OpbaModMobEffects.METALIZED.get()).getAmplifier() : 0));
				}
			}
		}
	}
}
