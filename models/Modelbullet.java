// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelbullet extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone7;
	private final ModelRenderer bone6;
	private final ModelRenderer bone5;
	private final ModelRenderer bone4;
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;

	public Modelbullet() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -1.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -4.0F, 0.0F);
		bone.addChild(bone7);
		bone7.setTextureOffset(0, 6).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone7.setTextureOffset(12, 1).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(9, 0).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-3.0F, -2.0F, 0.0F);
		bone.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, 1.5708F);
		bone6.setTextureOffset(5, 7).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone6.setTextureOffset(13, 13).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(10, 12).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-1.0F, -2.0F, 3.0F);
		bone.addChild(bone5);
		setRotationAngle(bone5, 1.5272F, 0.0F, 1.5708F);
		bone5.setTextureOffset(9, 3).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone5.setTextureOffset(14, 3).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(0, 14).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-1.0F, -2.0F, -1.0F);
		bone.addChild(bone4);
		setRotationAngle(bone4, 1.5272F, 0.0F, 1.5708F);
		bone4.setTextureOffset(0, 10).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(3, 15).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(15, 0).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(1.0F, -2.0F, 0.0F);
		bone.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 1.5708F);
		bone3.setTextureOffset(10, 8).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(15, 7).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(7, 15).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(5, 11).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(11, 15).addBox(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(15, 9).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}