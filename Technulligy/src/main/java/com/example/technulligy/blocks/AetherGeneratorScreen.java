package com.example.technulligy.blocks;

import com.example.technulligy.Technulligy;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class AetherGeneratorScreen extends ContainerScreen<AetherGeneratorContainer> {

	private ResourceLocation GUI = new ResourceLocation(Technulligy.MOD_ID, "textures/gui/simplegui.png");

	public AetherGeneratorScreen(AetherGeneratorContainer container, PlayerInventory inv, ITextComponent name) {
		super(container, inv, name);
	}
//draw GUI container background
	@Override
	protected void func_230450_a_(MatrixStack Matrixstack, float partialTicks, int mousex, int mouseY) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(GUI);
		int relX = (this.width - this.xSize) / 2;
		int relY = (this.height - this.ySize) / 2;
		this.blit(relX, relY, 0, 0, this.xSize, this.ySize);

	}

// draw GUI container foreground
	@Override
	protected void func_230451_b_(MatrixStack p_230451_1_, int mouseX, int mouseY) {
		drawString(Minecraft.getInstance().fontRenderer, "Energy: " + container.getEnergy(), 10, 10, 0xffffff);
	}
    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
}
