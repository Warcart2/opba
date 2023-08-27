package net.mcreator.opba.network;

import org.apache.commons.lang3.math.Fraction;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.opba.OpbaMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class OpbaModVariables {
	public static double BoutyTimer = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		OpbaMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		OpbaMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Fly = original.Fly;
			clone.Cyborg = original.Cyborg;
			clone.Shichibukai = original.Shichibukai;
			clone.cooldown = original.cooldown;
			clone.Lvl = original.Lvl;
			clone.Stamina = original.Stamina;
			clone.Xp = original.Xp;
			clone.StaminaMax = original.StaminaMax;
			clone.Bounty = original.Bounty;
			clone.BountyBillion = original.BountyBillion;
			clone.StandLevel = original.StandLevel;
			clone.BAbility = original.BAbility;
			clone.DevilFruit = original.DevilFruit;
			clone.Stand = original.Stand;
			clone.VAbility = original.VAbility;
			clone.XAbility = original.XAbility;
			clone.ZAbility = original.ZAbility;
			clone.FightingStyle = original.FightingStyle;
			clone.JojoPower = original.JojoPower;
			clone.Fraction = original.Fraction;
			clone.CyborgFuelType = original.CyborgFuelType;
			if (!event.isWasDeath()) {
				clone.CombatMode = original.CombatMode;
				clone.Voltage100Milions = original.Voltage100Milions;
				clone.Voltage200Milions = original.Voltage200Milions;
				clone.SaikinSecondGear = original.SaikinSecondGear;
				clone.invisibility = original.invisibility;
				clone.ExternalInvis = original.ExternalInvis;
				clone.Dies = original.Dies;
				clone.SlotChoose = original.SlotChoose;
				clone.IronPerMob = original.IronPerMob;
				clone.GearTimer = original.GearTimer;
				clone.CyborgFuel = original.CyborgFuel;
				clone.ZoanPoint = original.ZoanPoint;
				clone.ExternalInvisPl = original.ExternalInvisPl;
				clone.atteckers = original.atteckers;
				clone.GearsWas = original.GearsWas;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					OpbaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					OpbaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					OpbaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "opba_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				OpbaMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "opba_mapvars";
		public String GoroGoroUser = "\"WRDWFkrjlgirlwtguojeit;thjgkti";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			GoroGoroUser = nbt.getString("GoroGoroUser");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("GoroGoroUser", GoroGoroUser);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				OpbaMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("opba", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public boolean CombatMode = false;
		public boolean Voltage100Milions = false;
		public boolean Voltage200Milions = false;
		public boolean Fly = false;
		public boolean SaikinSecondGear = false;
		public boolean invisibility = false;
		public boolean ExternalInvis = false;
		public boolean Dies = false;
		public boolean Cyborg = false;
		public boolean Shichibukai = false;
		public double cooldown = 0.0;
		public double Lvl = 0;
		public double Stamina = 0;
		public double Xp = 0;
		public double SlotChoose = 1.0;
		public double IronPerMob = 20.0;
		public double StaminaMax = 500.0;
		public double GearTimer = 0;
		public double Bounty = 0;
		public double BountyBillion = 0;
		public double StandLevel = 0;
		public double CyborgFuel = 500.0;
		public String BAbility = "";
		public String DevilFruit = "None";
		public String Stand = "None";
		public String VAbility = "";
		public String XAbility = "";
		public String ZAbility = "";
		public String ZoanPoint = "";
		public String FightingStyle = "None";
		public String JojoPower = "None";
		public String Fraction = "Civilian";
		public String ExternalInvisPl = "";
		public String CyborgFuelType = "";
		public String atteckers = "";
		public String GearsWas = "";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				OpbaMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putBoolean("CombatMode", CombatMode);
			nbt.putBoolean("Voltage100Milions", Voltage100Milions);
			nbt.putBoolean("Voltage200Milions", Voltage200Milions);
			nbt.putBoolean("Fly", Fly);
			nbt.putBoolean("SaikinSecondGear", SaikinSecondGear);
			nbt.putBoolean("invisibility", invisibility);
			nbt.putBoolean("ExternalInvis", ExternalInvis);
			nbt.putBoolean("Dies", Dies);
			nbt.putBoolean("Cyborg", Cyborg);
			nbt.putBoolean("Shichibukai", Shichibukai);
			nbt.putDouble("cooldown", cooldown);
			nbt.putDouble("Lvl", Lvl);
			nbt.putDouble("Stamina", Stamina);
			nbt.putDouble("Xp", Xp);
			nbt.putDouble("SlotChoose", SlotChoose);
			nbt.putDouble("IronPerMob", IronPerMob);
			nbt.putDouble("StaminaMax", StaminaMax);
			nbt.putDouble("GearTimer", GearTimer);
			nbt.putDouble("Bounty", Bounty);
			nbt.putDouble("BountyBillion", BountyBillion);
			nbt.putDouble("StandLevel", StandLevel);
			nbt.putDouble("CyborgFuel", CyborgFuel);
			nbt.putString("BAbility", BAbility);
			nbt.putString("DevilFruit", DevilFruit);
			nbt.putString("Stand", Stand);
			nbt.putString("VAbility", VAbility);
			nbt.putString("XAbility", XAbility);
			nbt.putString("ZAbility", ZAbility);
			nbt.putString("ZoanPoint", ZoanPoint);
			nbt.putString("FightingStyle", FightingStyle);
			nbt.putString("JojoPower", JojoPower);
			nbt.putString("Fraction", Fraction);
			nbt.putString("ExternalInvisPl", ExternalInvisPl);
			nbt.putString("CyborgFuelType", CyborgFuelType);
			nbt.putString("atteckers", atteckers);
			nbt.putString("GearsWas", GearsWas);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			CombatMode = nbt.getBoolean("CombatMode");
			Voltage100Milions = nbt.getBoolean("Voltage100Milions");
			Voltage200Milions = nbt.getBoolean("Voltage200Milions");
			Fly = nbt.getBoolean("Fly");
			SaikinSecondGear = nbt.getBoolean("SaikinSecondGear");
			invisibility = nbt.getBoolean("invisibility");
			ExternalInvis = nbt.getBoolean("ExternalInvis");
			Dies = nbt.getBoolean("Dies");
			Cyborg = nbt.getBoolean("Cyborg");
			Shichibukai = nbt.getBoolean("Shichibukai");
			cooldown = nbt.getDouble("cooldown");
			Lvl = nbt.getDouble("Lvl");
			Stamina = nbt.getDouble("Stamina");
			Xp = nbt.getDouble("Xp");
			SlotChoose = nbt.getDouble("SlotChoose");
			IronPerMob = nbt.getDouble("IronPerMob");
			StaminaMax = nbt.getDouble("StaminaMax");
			GearTimer = nbt.getDouble("GearTimer");
			Bounty = nbt.getDouble("Bounty");
			BountyBillion = nbt.getDouble("BountyBillion");
			StandLevel = nbt.getDouble("StandLevel");
			CyborgFuel = nbt.getDouble("CyborgFuel");
			BAbility = nbt.getString("BAbility");
			DevilFruit = nbt.getString("DevilFruit");
			Stand = nbt.getString("Stand");
			VAbility = nbt.getString("VAbility");
			XAbility = nbt.getString("XAbility");
			ZAbility = nbt.getString("ZAbility");
			ZoanPoint = nbt.getString("ZoanPoint");
			FightingStyle = nbt.getString("FightingStyle");
			JojoPower = nbt.getString("JojoPower");
			Fraction = nbt.getString("Fraction");
			ExternalInvisPl = nbt.getString("ExternalInvisPl");
			CyborgFuelType = nbt.getString("CyborgFuelType");
			atteckers = nbt.getString("atteckers");
			GearsWas = nbt.getString("GearsWas");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.CombatMode = message.data.CombatMode;
					variables.Voltage100Milions = message.data.Voltage100Milions;
					variables.Voltage200Milions = message.data.Voltage200Milions;
					variables.Fly = message.data.Fly;
					variables.SaikinSecondGear = message.data.SaikinSecondGear;
					variables.invisibility = message.data.invisibility;
					variables.ExternalInvis = message.data.ExternalInvis;
					variables.Dies = message.data.Dies;
					variables.Cyborg = message.data.Cyborg;
					variables.Shichibukai = message.data.Shichibukai;
					variables.cooldown = message.data.cooldown;
					variables.Lvl = message.data.Lvl;
					variables.Stamina = message.data.Stamina;
					variables.Xp = message.data.Xp;
					variables.SlotChoose = message.data.SlotChoose;
					variables.IronPerMob = message.data.IronPerMob;
					variables.StaminaMax = message.data.StaminaMax;
					variables.GearTimer = message.data.GearTimer;
					variables.Bounty = message.data.Bounty;
					variables.BountyBillion = message.data.BountyBillion;
					variables.StandLevel = message.data.StandLevel;
					variables.CyborgFuel = message.data.CyborgFuel;
					variables.BAbility = message.data.BAbility;
					variables.DevilFruit = message.data.DevilFruit;
					variables.Stand = message.data.Stand;
					variables.VAbility = message.data.VAbility;
					variables.XAbility = message.data.XAbility;
					variables.ZAbility = message.data.ZAbility;
					variables.ZoanPoint = message.data.ZoanPoint;
					variables.FightingStyle = message.data.FightingStyle;
					variables.JojoPower = message.data.JojoPower;
					variables.Fraction = message.data.Fraction;
					variables.ExternalInvisPl = message.data.ExternalInvisPl;
					variables.CyborgFuelType = message.data.CyborgFuelType;
					variables.atteckers = message.data.atteckers;
					variables.GearsWas = message.data.GearsWas;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
