
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.opba.world.inventory.PunkGibsonGuiMenu;
import net.mcreator.opba.world.inventory.KeyMakerWorkMenu;
import net.mcreator.opba.world.inventory.FractionChooseMenu;
import net.mcreator.opba.world.inventory.FractionChoose2Menu;
import net.mcreator.opba.world.inventory.ChooserMenu;
import net.mcreator.opba.world.inventory.AbilityChooseSukeMenu;
import net.mcreator.opba.world.inventory.AbilityChooseMicroSaikinMenu;
import net.mcreator.opba.world.inventory.AbilityChooseMetalicaMenu;
import net.mcreator.opba.world.inventory.AbilityChooseJikiMenu;
import net.mcreator.opba.world.inventory.AbilityChooseGoroMenu;
import net.mcreator.opba.world.inventory.AbilityChooseCyborgMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<AbilityChooseMetalicaMenu> ABILITY_CHOOSE_METALICA = register("ability_choose_metalica", (id, inv, extraData) -> new AbilityChooseMetalicaMenu(id, inv, extraData));
	public static final MenuType<KeyMakerWorkMenu> KEY_MAKER_WORK = register("key_maker_work", (id, inv, extraData) -> new KeyMakerWorkMenu(id, inv, extraData));
	public static final MenuType<ChooserMenu> CHOOSER = register("chooser", (id, inv, extraData) -> new ChooserMenu(id, inv, extraData));
	public static final MenuType<AbilityChooseGoroMenu> ABILITY_CHOOSE_GORO = register("ability_choose_goro", (id, inv, extraData) -> new AbilityChooseGoroMenu(id, inv, extraData));
	public static final MenuType<AbilityChooseJikiMenu> ABILITY_CHOOSE_JIKI = register("ability_choose_jiki", (id, inv, extraData) -> new AbilityChooseJikiMenu(id, inv, extraData));
	public static final MenuType<AbilityChooseMicroSaikinMenu> ABILITY_CHOOSE_MICRO_SAIKIN = register("ability_choose_micro_saikin", (id, inv, extraData) -> new AbilityChooseMicroSaikinMenu(id, inv, extraData));
	public static final MenuType<AbilityChooseSukeMenu> ABILITY_CHOOSE_SUKE = register("ability_choose_suke", (id, inv, extraData) -> new AbilityChooseSukeMenu(id, inv, extraData));
	public static final MenuType<FractionChooseMenu> FRACTION_CHOOSE = register("fraction_choose", (id, inv, extraData) -> new FractionChooseMenu(id, inv, extraData));
	public static final MenuType<AbilityChooseCyborgMenu> ABILITY_CHOOSE_CYBORG = register("ability_choose_cyborg", (id, inv, extraData) -> new AbilityChooseCyborgMenu(id, inv, extraData));
	public static final MenuType<FractionChoose2Menu> FRACTION_CHOOSE_2 = register("fraction_choose_2", (id, inv, extraData) -> new FractionChoose2Menu(id, inv, extraData));
	public static final MenuType<PunkGibsonGuiMenu> PUNK_GIBSON_GUI = register("punk_gibson_gui", (id, inv, extraData) -> new PunkGibsonGuiMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
