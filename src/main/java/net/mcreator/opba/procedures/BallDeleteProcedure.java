package net.mcreator.opba.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BallDeleteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState block, double radius) {
		double yLoop = 0;
		double SphereRadius = 0;
		double loop = 0;
		double particleAmount = 0;
		double SubX = 0;
		double SubY = 0;
		double SubZ = 0;
		SphereRadius = radius;
		particleAmount = 16 * SphereRadius + 1;
		yLoop = -1;
		while (yLoop <= 1) {
			loop = 0;
			while (loop < particleAmount - particleAmount * Math.pow(yLoop, 2)) {
				SubX = x + 0.5 + Math.cos(((Math.PI * 2) / (particleAmount - particleAmount * Math.pow(yLoop, 2))) * loop) * SphereRadius * (1 - Math.pow(yLoop, 2));
				SubY = y + 0.5 + yLoop * SphereRadius;
				SubZ = z + 0.5 + Math.sin(((Math.PI * 2) / (particleAmount - particleAmount * Math.pow(yLoop, 2))) * loop) * SphereRadius * (1 - Math.pow(yLoop, 2));
				if (SubY > 0 && SubY < 256 && !(world.getBlockState(new BlockPos(SubX, SubY, SubZ)).getDestroySpeed(world, new BlockPos(SubX, SubY, SubZ)) < 0
						|| (world.getBlockState(new BlockPos(SubX, SubY, SubZ))).getMaterial() == net.minecraft.world.level.material.Material.STONE)) {
					world.setBlock(new BlockPos(SubX, SubY, SubZ), block, 3);
				}
				loop = loop + 1;
			}
			yLoop = yLoop + 2 / particleAmount;
		}
		SphereRadius = SphereRadius - 1;
		if (SphereRadius > 0) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					BallDeleteProcedure.execute(world, x, y, z, block, radius-1);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 10);
		}
	}
}
