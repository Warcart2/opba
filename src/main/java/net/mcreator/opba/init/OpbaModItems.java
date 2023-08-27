
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.opba.item.WantedPosterItem;
import net.mcreator.opba.item.ToxicBacteriaWItem;
import net.mcreator.opba.item.SukeSukeNoMiItem;
import net.mcreator.opba.item.SukeExternalInvisWItem;
import net.mcreator.opba.item.StrawHatItem;
import net.mcreator.opba.item.StandArrowItem;
import net.mcreator.opba.item.SaikinSaikinNoMiItem;
import net.mcreator.opba.item.RejectDialItem;
import net.mcreator.opba.item.RaigoWItem;
import net.mcreator.opba.item.PunkgibsonItem;
import net.mcreator.opba.item.KikoKikoNoMiItem;
import net.mcreator.opba.item.KeyItem;
import net.mcreator.opba.item.KairosekiItem;
import net.mcreator.opba.item.JikiJikiNoMiItem;
import net.mcreator.opba.item.ImpactDialItem;
import net.mcreator.opba.item.GoroGoroNoMiItem;
import net.mcreator.opba.item.FreshFireWItem;
import net.mcreator.opba.item.ElThorWItem;
import net.mcreator.opba.OpbaMod;

public class OpbaModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, OpbaMod.MODID);
	public static final RegistryObject<Item> GORO_GORO_NO_MI = REGISTRY.register("goro_goro_no_mi", () -> new GoroGoroNoMiItem());
	public static final RegistryObject<Item> EL_THOR_W = REGISTRY.register("el_thor_w", () -> new ElThorWItem());
	public static final RegistryObject<Item> IMPACT_DIAL = REGISTRY.register("impact_dial", () -> new ImpactDialItem());
	public static final RegistryObject<Item> REJECT_DIAL = REGISTRY.register("reject_dial", () -> new RejectDialItem());
	public static final RegistryObject<Item> JIKI_JIKI_NO_MI = REGISTRY.register("jiki_jiki_no_mi", () -> new JikiJikiNoMiItem());
	public static final RegistryObject<Item> STAND_ARROW = REGISTRY.register("stand_arrow", () -> new StandArrowItem());
	public static final RegistryObject<Item> KEY = REGISTRY.register("key", () -> new KeyItem());
	public static final RegistryObject<Item> KEY_MAKER = block(OpbaModBlocks.KEY_MAKER, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> MICRO_MICRO_NO_MI_MODEL_SAIKIN = REGISTRY.register("micro_micro_no_mi_model_saikin", () -> new SaikinSaikinNoMiItem());
	public static final RegistryObject<Item> TOXIC_BACTERIA_W = REGISTRY.register("toxic_bacteria_w", () -> new ToxicBacteriaWItem());
	public static final RegistryObject<Item> KAIROSEKI = REGISTRY.register("kairoseki", () -> new KairosekiItem());
	public static final RegistryObject<Item> SUKE_SUKE_NO_MI = REGISTRY.register("suke_suke_no_mi", () -> new SukeSukeNoMiItem());
	public static final RegistryObject<Item> STRAW_HAT_HELMET = REGISTRY.register("straw_hat_helmet", () -> new StrawHatItem.Helmet());
	public static final RegistryObject<Item> WANTED_POSTER = REGISTRY.register("wanted_poster", () -> new WantedPosterItem());
	public static final RegistryObject<Item> WANTED_POSTER_PACKAGE = block(OpbaModBlocks.WANTED_POSTER_PACKAGE, OpbaModTabs.TAB_DEVIL_FRUITS);
	public static final RegistryObject<Item> RAIGO_W = REGISTRY.register("raigo_w", () -> new RaigoWItem());
	public static final RegistryObject<Item> MARINE_SOLDIER_SPAWN_EGG = REGISTRY.register("marine_soldier_spawn_egg",
			() -> new ForgeSpawnEggItem(OpbaModEntities.MARINE_SOLDIER, -8139009, -12895233, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> SUKE_EXTERNAL_INVIS_W = REGISTRY.register("suke_external_invis_w", () -> new SukeExternalInvisWItem());
	public static final RegistryObject<Item> FRESH_FIRE_W = REGISTRY.register("fresh_fire_w", () -> new FreshFireWItem());
	public static final RegistryObject<Item> TRASH = block(OpbaModBlocks.TRASH, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> PUNKGIBSON = REGISTRY.register("punkgibson", () -> new PunkgibsonItem());
	public static final RegistryObject<Item> KIKO_KIKO_NO_MI = REGISTRY.register("kiko_kiko_no_mi", () -> new KikoKikoNoMiItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
