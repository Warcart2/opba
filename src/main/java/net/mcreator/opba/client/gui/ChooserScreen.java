
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

import net.mcreator.opba.world.inventory.ChooserMenu;
import net.mcreator.opba.procedures.IfCyborgProcedure;
import net.mcreator.opba.procedures.HaveStandProcedure;
import net.mcreator.opba.procedures.HaveFruitProcedure;
import net.mcreator.opba.network.ChooserButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChooserScreen extends AbstractContainerScreen<ChooserMenu> {
	private final static HashMap<String, Object> guistate = ChooserMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_devil_fruit;
	Button button_stand;
	Button button_cyborg;

	public ChooserScreen(ChooserMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/chooser.png");

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
		button_devil_fruit = new Button(this.leftPos + 42, this.topPos + 7, 77, 20, new TranslatableComponent("gui.opba.chooser.button_devil_fruit"), e -> {
			if (HaveFruitProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new ChooserButtonMessage(0, x, y, z));
				ChooserButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (HaveFruitProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_devil_fruit", button_devil_fruit);
		this.addRenderableWidget(button_devil_fruit);
		button_stand = new Button(this.leftPos + 51, this.topPos + 34, 51, 20, new TranslatableComponent("gui.opba.chooser.button_stand"), e -> {
			if (HaveStandProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new ChooserButtonMessage(1, x, y, z));
				ChooserButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (HaveStandProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_stand", button_stand);
		this.addRenderableWidget(button_stand);
		button_cyborg = new Button(this.leftPos + 51, this.topPos + 61, 56, 20, new TranslatableComponent("gui.opba.chooser.button_cyborg"), e -> {
			if (IfCyborgProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new ChooserButtonMessage(2, x, y, z));
				ChooserButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (IfCyborgProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_cyborg", button_cyborg);
		this.addRenderableWidget(button_cyborg);
	}
}
