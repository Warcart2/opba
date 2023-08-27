
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

import net.mcreator.opba.world.inventory.AbilityChooseCyborgMenu;
import net.mcreator.opba.network.AbilityChooseCyborgButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AbilityChooseCyborgScreen extends AbstractContainerScreen<AbilityChooseCyborgMenu> {
	private final static HashMap<String, Object> guistate = AbilityChooseCyborgMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_change_slot;
	Button button_fresh_fire;

	public AbilityChooseCyborgScreen(AbilityChooseCyborgMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/ability_choose_cyborg.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.ability_choose_cyborg.label_slot_varintegerslotchoose"), 51, -20, -65536);
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
		button_change_slot = new Button(this.leftPos + 42, this.topPos + 133, 82, 20, new TranslatableComponent("gui.opba.ability_choose_cyborg.button_change_slot"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseCyborgButtonMessage(0, x, y, z));
				AbilityChooseCyborgButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_change_slot", button_change_slot);
		this.addRenderableWidget(button_change_slot);
		button_fresh_fire = new Button(this.leftPos + 42, this.topPos + 7, 77, 20, new TranslatableComponent("gui.opba.ability_choose_cyborg.button_fresh_fire"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseCyborgButtonMessage(1, x, y, z));
				AbilityChooseCyborgButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_fresh_fire", button_fresh_fire);
		this.addRenderableWidget(button_fresh_fire);
	}
}
