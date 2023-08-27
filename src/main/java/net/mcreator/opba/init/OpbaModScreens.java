
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.opba.client.gui.PunkGibsonGuiScreen;
import net.mcreator.opba.client.gui.KeyMakerWorkScreen;
import net.mcreator.opba.client.gui.FractionChooseScreen;
import net.mcreator.opba.client.gui.FractionChoose2Screen;
import net.mcreator.opba.client.gui.ChooserScreen;
import net.mcreator.opba.client.gui.AbilityChooseSukeScreen;
import net.mcreator.opba.client.gui.AbilityChooseMicroSaikinScreen;
import net.mcreator.opba.client.gui.AbilityChooseMetalicaScreen;
import net.mcreator.opba.client.gui.AbilityChooseJikiScreen;
import net.mcreator.opba.client.gui.AbilityChooseGoroScreen;
import net.mcreator.opba.client.gui.AbilityChooseCyborgScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OpbaModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_METALICA, AbilityChooseMetalicaScreen::new);
			MenuScreens.register(OpbaModMenus.KEY_MAKER_WORK, KeyMakerWorkScreen::new);
			MenuScreens.register(OpbaModMenus.CHOOSER, ChooserScreen::new);
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_GORO, AbilityChooseGoroScreen::new);
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_JIKI, AbilityChooseJikiScreen::new);
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_MICRO_SAIKIN, AbilityChooseMicroSaikinScreen::new);
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_SUKE, AbilityChooseSukeScreen::new);
			MenuScreens.register(OpbaModMenus.FRACTION_CHOOSE, FractionChooseScreen::new);
			MenuScreens.register(OpbaModMenus.ABILITY_CHOOSE_CYBORG, AbilityChooseCyborgScreen::new);
			MenuScreens.register(OpbaModMenus.FRACTION_CHOOSE_2, FractionChoose2Screen::new);
			MenuScreens.register(OpbaModMenus.PUNK_GIBSON_GUI, PunkGibsonGuiScreen::new);
		});
	}
}
