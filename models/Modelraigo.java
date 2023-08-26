// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelraigo extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bone6;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone7;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer bone5;
	private final ModelRenderer cube_r6;

	public Modelraigo() {
		textureWidth = 8;
		textureHeight = 4;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -130.0F, 1.0F, 2.0F, 2.0F, 2.0F, 127.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone2.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone6);
		setRotationAngle(bone6, 1.5708F, 0.0F, 0.0F);
		bone6.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone6.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone6.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone7);
		setRotationAngle(bone7, -1.5708F, 0.0F, 0.0F);
		bone7.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone7.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone7.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone7.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r3.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 1.5708F);
		bone3.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone3.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone3.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone3.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r4.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, -3.1416F);
		bone4.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone4.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone4.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone4.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r5.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -128.0F, 0.0F);
		bone.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -1.5708F);
		bone5.setTextureOffset(0, 0).addBox(-1.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone5.setTextureOffset(0, 0).addBox(85.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		bone5.setTextureOffset(0, 0).addBox(-87.0F, 169.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, 128.0F, 0.0F);
		bone5.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(85.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
		cube_r6.setTextureOffset(0, 0).addBox(-87.0F, 41.0F, 0.0F, 2.0F, 2.0F, 2.0F, 42.0F, false);
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}