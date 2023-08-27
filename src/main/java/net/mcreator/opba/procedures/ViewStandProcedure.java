package net.mcreator.opba.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.Minecraft;

import java.io.File;

public class ViewStandProcedure {
	public static boolean execute(LevelAccessor world) {
		File file = new File("");
		file = new File((FMLPaths.GAMEDIR.get().toString() + "" + File.separator + "worldstand"),
				File.separator + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()));
		return file.exists();
	}
}
