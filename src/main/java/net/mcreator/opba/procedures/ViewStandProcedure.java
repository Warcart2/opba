package net.mcreator.opba.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ViewStandProcedure {
	public static boolean execute(LevelAccessor world) {
		File file = new File("");
		String player = "";
		boolean it = false;
		it = false;
		file = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "you_are.plfile");
		if (file.exists()) {
			try {
				BufferedReader fileReader = new BufferedReader(new FileReader(file));
				String stringiterator = "";
				while ((stringiterator = fileReader.readLine()) != null) {
					player = stringiterator;
				}
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if ((player).equals(entityiterator.getDisplayName().getString())) {
					it = true;
					break;
				}
			}
		}
		return it;
	}
}
