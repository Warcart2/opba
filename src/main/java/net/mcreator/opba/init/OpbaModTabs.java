
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class OpbaModTabs {
	public static CreativeModeTab TAB_DEVIL_FRUITS;
	public static CreativeModeTab TAB_JO_JO;

	public static void load() {
		TAB_DEVIL_FRUITS = new CreativeModeTab("tabdevil_fruits") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(OpbaModItems.JIKI_JIKI_NO_MI.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_JO_JO = new CreativeModeTab("tabjo_jo") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(OpbaModItems.STAND_ARROW.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
