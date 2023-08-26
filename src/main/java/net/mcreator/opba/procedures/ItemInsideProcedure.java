package net.mcreator.opba.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandFunction;

import net.mcreator.opba.network.OpbaModVariables;

import java.util.Random;
import java.util.Optional;

public class ItemInsideProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double rand = 0;
		rand = Mth.nextInt(new Random(), 3, 10);
		if (rand <= (NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).IronPerMob) {
			{
				double _setval = (NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).IronPerMob - rand;
				NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IronPerMob = _setval;
					capability.syncPlayerVariables(NearestEntityProcedure.execute(world, x, y, z, entity));
				});
			}
			if (NearestEntityProcedure.execute(world, x, y, z, entity) instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("cut_inside").bypassArmor(), (float) rand);
			if (world instanceof ServerLevel _level && _level.getServer() != null) {
				Optional<CommandFunction> _fopt = _level.getServer().getFunctions().get(new ResourceLocation("opba:jojo/stand/metalica_iron_spawn"));
				if (_fopt.isPresent())
					_level.getServer().getFunctions().execute(_fopt.get(),
							new CommandSourceStack(CommandSource.NULL,
									new Vec3((NearestEntityProcedure.execute(world, x, y, z, entity).getX()), (NearestEntityProcedure.execute(world, x, y, z, entity).getY()), (NearestEntityProcedure.execute(world, x, y, z, entity).getZ())),
									Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null));
			}
		} else {
			if (NearestEntityProcedure.execute(world, x, y, z, entity) instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("cut_inside").bypassArmor(),
						(float) (NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new OpbaModVariables.PlayerVariables())).IronPerMob);
			{
				double _setval = 0;
				NearestEntityProcedure.execute(world, x, y, z, entity).getCapability(OpbaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IronPerMob = _setval;
					capability.syncPlayerVariables(NearestEntityProcedure.execute(world, x, y, z, entity));
				});
			}
		}
	}
}
