
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

import net.mcreator.opba.world.inventory.FractionChooseMenu;
import net.mcreator.opba.network.FractionChooseButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FractionChooseScreen extends AbstractContainerScreen<FractionChooseMenu> {
	private final static HashMap<String, Object> guistate = FractionChooseMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_become_marine;
	Button button_empty;

	public FractionChooseScreen(FractionChooseMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 234;
		this.imageHeight = 221;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/fraction_choose.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("opba:textures/screens/one_piece_marines_flag.png"));
		this.blit(ms, this.leftPos + 89, this.topPos + 7, 0, 0, 64, 45, 64, 45);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_become_a_champion_of_justice_a"), 8, 52, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_civilians_prospering_in_this_wor"), 8, 61, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_you_will_get_the_recognition_of"), 8, 70, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_and_just_as_important"), 8, 79, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_you_will_get_the_recognition_of1"), 8, 88, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_empty"), 8, 97, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_fleet_of_justice_wont_leave_you"), 8, 97, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_trouble_which_is_no_less_import"), 8, 106, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_and_become_part_of_a_mighty_army"), 8, 124, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_brings_peace_to_the_world"), 8, 133, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_your_efforts_and_strength_will_n"), 17, 142, -13004609);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_forgotten_in_the_marine"), 17, 151, -13004609);
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.fraction_choose.label_you_yourself_can_get_his_recogni"), 8, 115, -12829636);
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
		button_become_marine = new Button(this.leftPos + 71, this.topPos + 178, 93, 20, new TranslatableComponent("gui.opba.fraction_choose.button_become_marine"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new FractionChooseButtonMessage(0, x, y, z));
				FractionChooseButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_become_marine", button_become_marine);
		this.addRenderableWidget(button_become_marine);
		button_empty = new Button(this.leftPos + 242, this.topPos + 97, 30, 20, new TranslatableComponent("gui.opba.fraction_choose.button_empty"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new FractionChooseButtonMessage(1, x, y, z));
				FractionChooseButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
	}
}
