
package net.mcreator.opba.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.opba.world.inventory.AbilityChooseGoroMenu;
import net.mcreator.opba.procedures.ActiveVoltage200Procedure;
import net.mcreator.opba.procedures.ActiveVoltage100Procedure;
import net.mcreator.opba.procedures.ActiveAnyProcedure;
import net.mcreator.opba.network.AbilityChooseGoroButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AbilityChooseGoroScreen extends AbstractContainerScreen<AbilityChooseGoroMenu> {
	private final static HashMap<String, Object> guistate = AbilityChooseGoroMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_el_thor;
	Button button_raigo;
	Button button_100_milion_volt;
	Button button_200_milion_volt;
	Button button_devoltage;
	Button button_next_slot;

	public AbilityChooseGoroScreen(AbilityChooseGoroMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/ability_choose_goro.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.ability_choose_goro.label_slot_varintegerslotchoose"), 69, -11, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_el_thor = new Button(this.leftPos + 60, this.topPos + 7, 56, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_el_thor"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(0, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_el_thor", button_el_thor);
		this.addRenderableWidget(button_el_thor);
		button_raigo = new Button(this.leftPos + 60, this.topPos + 34, 51, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_raigo"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(1, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_raigo", button_raigo);
		this.addRenderableWidget(button_raigo);
		button_100_milion_volt = new Button(this.leftPos + 33, this.topPos + 61, 103, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_100_milion_volt"), e -> {
			if (ActiveVoltage100Procedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(2, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveVoltage100Procedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_100_milion_volt", button_100_milion_volt);
		this.addRenderableWidget(button_100_milion_volt);
		button_200_milion_volt = new Button(this.leftPos + 33, this.topPos + 88, 103, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_200_milion_volt"), e -> {
			if (ActiveVoltage200Procedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(3, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveVoltage200Procedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_200_milion_volt", button_200_milion_volt);
		this.addRenderableWidget(button_200_milion_volt);
		button_devoltage = new Button(this.leftPos + 51, this.topPos + 115, 72, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_devoltage"), e -> {
			if (ActiveAnyProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(4, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ActiveAnyProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_devoltage", button_devoltage);
		this.addRenderableWidget(button_devoltage);
		button_next_slot = new Button(this.leftPos + 51, this.topPos + 142, 72, 20, new TranslatableComponent("gui.opba.ability_choose_goro.button_next_slot"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseGoroButtonMessage(5, x, y, z));
				AbilityChooseGoroButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:button_next_slot", button_next_slot);
		this.addRenderableWidget(button_next_slot);
	}
}
