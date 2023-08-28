package net.mcreator.opba.procedures;

import net.mcreator.opba.procedures.StandsProcedure;
import java.util.List;
import net.minecraft.util.Mth;

import java.util.Random;

public class RandomStandProcedure {
	public static String execute() {
		List<String> stands = StandsProcedure.execute();
		return stands.get(Mth.nextInt(new Random(), 0, stands.size()));
	}
}
