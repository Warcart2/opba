
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.opba.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.opba.block.WantedPosterPackageBlock;
import net.mcreator.opba.block.TrashBlock;
import net.mcreator.opba.block.KeyMakerBlock;
import net.mcreator.opba.OpbaMod;

public class OpbaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, OpbaMod.MODID);
	public static final RegistryObject<Block> KEY_MAKER = REGISTRY.register("key_maker", () -> new KeyMakerBlock());
	public static final RegistryObject<Block> WANTED_POSTER_PACKAGE = REGISTRY.register("wanted_poster_package", () -> new WantedPosterPackageBlock());
	public static final RegistryObject<Block> TRASH = REGISTRY.register("trash", () -> new TrashBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			WantedPosterPackageBlock.registerRenderLayer();
		}
	}
}
