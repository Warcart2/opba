package net.mcreator.opba.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.opba.init.OpbaModItems;

import java.util.concurrent.atomic.AtomicReference;

public class PunkGibsonGetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack gibson = ItemStack.EMPTY;
		double iron = 0;
		double i = 0;
		double slot = 0;
		double returnedIronSlot = 0;
		if (!entity.getPersistentData().getBoolean("gibson")) {
			gibson = new ItemStack(OpbaModItems.PUNKGIBSON.get());
			iron = 0;
			i = 0;
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("opba:metal"))) && iron < 500) {
							iron = iron + (itemstackiterator).getCount();
							{
								ItemStack _isc = gibson;
								final ItemStack _setstack = itemstackiterator;
								final int _sltid = (int) i;
								_setstack.setCount((itemstackiterator).getCount());
								_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
							{
								final int _slotid = (int) slot;
								final ItemStack _setstack = new ItemStack(Blocks.AIR);
								_setstack.setCount(1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable _modHandler)
										_modHandler.setStackInSlot(_slotid, _setstack);
								});
							}
							i = i + 1;
						}
						slot = slot + 1;
					}
				}
			}
			gibson.getOrCreateTag().putDouble("far", iron);
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				_setstack.setCount(((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getCount());
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = gibson;
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			entity.getPersistentData().putBoolean("gibson", true);
		} else {
			slot = 0;
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> _iitemhandlerref.set(capability));
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == OpbaModItems.PUNKGIBSON.get()) {
							gibson = (new Object() {
								public ItemStack getItemStack(int sltid, Entity entity) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
									return _retval.get();
								}
							}.getItemStack((int) slot, entity));
							returnedIronSlot = 0;
							for (int index0 = 0; index0 < 36; index0++) {
								if (world instanceof Level _level && !_level.isClientSide()) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, ((new Object() {
										public ItemStack getItemStack(int sltid, ItemStack _isc) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
											return _retval.get();
										}
									}.getItemStack((int) returnedIronSlot, itemstackiterator)).copy()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								returnedIronSlot = returnedIronSlot + 1;
							}
							entity.getPersistentData().putBoolean("gibson", false);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(OpbaModItems.PUNKGIBSON.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else {
							slot = slot + 1;
						}
					}
				}
			}
		}
	}
}
