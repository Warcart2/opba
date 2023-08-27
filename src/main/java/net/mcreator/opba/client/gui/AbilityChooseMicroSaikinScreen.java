
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

import net.mcreator.opba.world.inventory.AbilityChooseMicroSaikinMenu;
import net.mcreator.opba.procedures.SemipointOffProcedure;
import net.mcreator.opba.procedures.BasicPointOffProcedure;
import net.mcreator.opba.procedures.BacterialPointOffProcedure;
import net.mcreator.opba.network.AbilityChooseMicroSaikinButtonMessage;
import net.mcreator.opba.OpbaMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AbilityChooseMicroSaikinScreen extends AbstractContainerScreen<AbilityChooseMicroSaikinMenu> {
	private final static HashMap<String, Object> guistate = AbilityChooseMicroSaikinMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_next_slot;
	Button button_toxic_bacteria;
	Button button_gear_second;
	Button button_bacterial_point;
	Button button_semipoint;
	Button button_basic_point;

	public AbilityChooseMicroSaikinScreen(AbilityChooseMicroSaikinMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("opba:textures/screens/ability_choose_micro_saikin.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.label_slot_varintegerslotchoose"), 60, -11, -65536);
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
		button_next_slot = new Button(this.leftPos + 51, this.topPos + 142, 72, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_next_slot"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(0, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_next_slot", button_next_slot);
		this.addRenderableWidget(button_next_slot);
		button_toxic_bacteria = new Button(this.leftPos + 42, this.topPos + 7, 98, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_toxic_bacteria"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(1, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_toxic_bacteria", button_toxic_bacteria);
		this.addRenderableWidget(button_toxic_bacteria);
		button_gear_second = new Button(this.leftPos + 51, this.topPos + 34, 63, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_gear_second"), e -> {
			if (true) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(2, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_gear_second", button_gear_second);
		this.addRenderableWidget(button_gear_second);
		button_bacterial_point = new Button(this.leftPos + 33, this.topPos + 61, 103, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_bacterial_point"), e -> {
			if (BacterialPointOffProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(3, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (BacterialPointOffProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_bacterial_point", button_bacterial_point);
		this.addRenderableWidget(button_bacterial_point);
		button_semipoint = new Button(this.leftPos + 51, this.topPos + 88, 72, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_semipoint"), e -> {
			if (SemipointOffProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(4, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (SemipointOffProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_semipoint", button_semipoint);
		this.addRenderableWidget(button_semipoint);
		button_basic_point = new Button(this.leftPos + 42, this.topPos + 115, 82, 20, new TranslatableComponent("gui.opba.ability_choose_micro_saikin.button_basic_point"), e -> {
			if (BasicPointOffProcedure.execute(entity)) {
				OpbaMod.PACKET_HANDLER.sendToServer(new AbilityChooseMicroSaikinButtonMessage(5, x, y, z));
				AbilityChooseMicroSaikinButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (BasicPointOffProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_basic_point", button_basic_point);
		this.addRenderableWidget(button_basic_point);
	}
}
