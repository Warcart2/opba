package net.mcreator.opba.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class RejectDialLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("Dial_force").bypassArmor(), (float) (itemstack.getOrCreateTag().getDouble("Force") * 10));
		if (sourceentity instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("Dial_force").bypassArmor(), (float) (itemstack.getOrCreateTag().getDouble("Force") * 5));
		itemstack.getOrCreateTag().putDouble("Force", 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("opba:dial")), SoundSource.PLAYERS, 1, (float) 0.7);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("opba:dial")), SoundSource.PLAYERS, 1, (float) 0.7, false);
			}
		}
	}
}
