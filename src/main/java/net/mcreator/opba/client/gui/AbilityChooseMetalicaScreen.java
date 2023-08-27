
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

import net.mcreator.opba.world.inventory.AbilityChooseMetalicaMenu;
import net.mcreator.opba.network.AbilityChooseMetalicaButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AbilityChooseMetalicaScreen extends AbstractContainerScreen<AbilityChooseMetalicaMenu> {
	private final static HashMap<String, Object> guistate = AbilityChooseMetalicaMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_internal_iron_out;
	Button button_internal_iron_cristalizing;
	Button button_change_slot;
	Button button_invisibility;

	public AbilityChooseMetalicaScreen(AbilityChooseMetalicaMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/ability_choose_metalica.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.ability_choose_metalica.label_slot_varintegerslotchoose"), 60, -20, -65536);
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
		button_internal_iron_out = new Button(this.leftPos + 33, this.topPos + 7, 113, 20, new TranslatableComponent("gui.opba.ability_choose_metalica.button_internal_iron_out"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMetalicaButtonMessage(0, x, y, z));
				AbilityChooseMetalicaButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_internal_iron_out", button_internal_iron_out);
		this.addRenderableWidget(button_internal_iron_out);
		button_internal_iron_cristalizing = new Button(this.leftPos + 6, this.topPos + 34, 161, 20, new TranslatableComponent("gui.opba.ability_choose_metalica.button_internal_iron_cristalizing"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMetalicaButtonMessage(1, x, y, z));
				AbilityChooseMetalicaButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_internal_iron_cristalizing", button_internal_iron_cristalizing);
		this.addRenderableWidget(button_internal_iron_cristalizing);
		button_change_slot = new Button(this.leftPos + 42, this.topPos + 142, 82, 20, new TranslatableComponent("gui.opba.ability_choose_metalica.button_change_slot"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMetalicaButtonMessage(2, x, y, z));
				AbilityChooseMetalicaButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_change_slot", button_change_slot);
		this.addRenderableWidget(button_change_slot);
		button_invisibility = new Button(this.leftPos + 42, this.topPos + 61, 88, 20, new TranslatableComponent("gui.opba.ability_choose_metalica.button_invisibility"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMetalicaButtonMessage(3, x, y, z));
				AbilityChooseMetalicaButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_invisibility", button_invisibility);
		this.addRenderableWidget(button_invisibility);
	}
}
