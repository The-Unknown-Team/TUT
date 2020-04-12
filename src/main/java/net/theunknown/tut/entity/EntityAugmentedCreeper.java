
package net.theunknown.tut.entity;

@ElementsTUT.ModElement.Tag
public class EntityAugmentedCreeper extends ElementsTUT.ModElement {

	public static final int ENTITYID = 1;
	public static final int ENTITYID_RANGED = 2;

	public EntityAugmentedCreeper(ElementsTUT instance) {
		super(instance, 68);
	}

	@Override
	public void initElements() {
		elements.entities
				.add(() -> EntityEntryBuilder.create().entity(EntityCustom.class).id(new ResourceLocation("tut", "augmentedcreeper"), ENTITYID)
						.name("augmentedcreeper").tracker(32, 3, true).egg(-16738048, -65536).build());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("tut:deadlandsplains")),};
		EntityRegistry.addSpawn(EntityCustom.class, 12, 1, 4, EnumCreatureType.MONSTER, spawnBiomes);

	}

	@SideOnly(Side.CLIENT)
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityCustom.class, renderManager -> {
			return new RenderLiving(renderManager, new Modelaugmentedcreeper(), 0.5f) {
				protected ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("tut:textures/augmentedcreeper.png");
				}
			};
		});

	}

	public static class EntityCustom extends EntityCreeper {

		public EntityCustom(World world) {
			super(world);
			setSize(0.6f, 1.7f);
			experienceValue = 8;
			this.isImmuneToFire = false;
			setNoAI(!true);

		}

		@Override
		protected void initEntityAI() {
			super.initEntityAI();

		}

		@Override
		public EnumCreatureAttribute getCreatureAttribute() {
			return EnumCreatureAttribute.UNDEFINED;
		}

		@Override
		protected Item getDropItem() {
			return null;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();

			if (this.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
			if (this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0D);

		}

	}

	// Made with Blockbench
	// Paste this code into your mod.
	// Make sure to generate all required imports

	public static class Modelaugmentedcreeper extends ModelBase {
		private final ModelRenderer body;
		private final ModelRenderer bone11;
		private final ModelRenderer bone12;
		private final ModelRenderer bone13;
		private final ModelRenderer bone14;
		private final ModelRenderer bone8;
		private final ModelRenderer bone9;
		private final ModelRenderer bone10;
		private final ModelRenderer bone3;
		private final ModelRenderer bone2;
		private final ModelRenderer bone;
		private final ModelRenderer head;
		private final ModelRenderer bone7;
		private final ModelRenderer bone4;
		private final ModelRenderer bone5;
		private final ModelRenderer bone6;
		private final ModelRenderer backleft;
		private final ModelRenderer backright;
		private final ModelRenderer frontleft;
		private final ModelRenderer frontright;

		public Modelaugmentedcreeper() {
			textureWidth = 64;
			textureHeight = 64;

			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 24.0F, 0.0F);
			body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, -8.0F, -2.0F, 8, 2, 4, 0.0F, true));
			body.cubeList.add(new ModelBox(body, 16, 21, -4.0F, -18.0F, -2.0F, 8, 4, 4, 0.0F, true));

			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(8.5091F, -0.2768F, 0.0F);
			setRotationAngle(bone11, 0.0F, 0.0F, -1.5708F);
			body.addChild(bone11);
			bone11.cubeList.add(new ModelBox(bone11, 57, 16, 9.4512F, -1.7665F, -0.5F, 2, 1, 1, 0.0F, false));

			bone12 = new ModelRenderer(this);
			bone12.setRotationPoint(0.7809F, -0.5195F, 0.0F);
			setRotationAngle(bone12, 0.0F, 0.0F, -0.2618F);
			bone11.addChild(bone12);
			bone12.cubeList.add(new ModelBox(bone12, 57, 16, 10.3706F, 1.5231F, -0.5F, 2, 1, 1, 0.0F, false));

			bone13 = new ModelRenderer(this);
			bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone13, 0.0F, 0.0F, -0.3491F);
			bone12.addChild(bone13);
			bone13.cubeList.add(new ModelBox(bone13, 57, 16, 10.7616F, 5.602F, -0.5F, 2, 1, 1, 0.0F, false));

			bone14 = new ModelRenderer(this);
			bone14.setRotationPoint(-2.2943F, 3.2766F, 0.0F);
			setRotationAngle(bone14, 0.0F, 0.0F, -0.4363F);
			bone13.addChild(bone14);
			bone14.cubeList.add(new ModelBox(bone14, 57, 16, 12.2399F, 8.3766F, -0.5F, 3, 1, 1, 0.0F, false));

			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(4.0F, 1.0F, 0.0F);
			setRotationAngle(bone8, 0.0F, 0.0F, -0.4363F);
			body.addChild(bone8);
			bone8.cubeList.add(new ModelBox(bone8, 57, 16, 3.3558F, -7.4765F, -0.5F, 1, 1, 1, 0.0F, false));

			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(2.7189F, 1.2679F, 0.0F);
			setRotationAngle(bone9, 0.0F, 0.0F, -0.2618F);
			bone8.addChild(bone9);
			bone9.cubeList.add(new ModelBox(bone9, 57, 16, 3.5855F, -8.0568F, -0.5F, 2, 1, 1, 0.0F, false));

			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
			setRotationAngle(bone10, 0.0F, 0.0F, -0.3491F);
			bone9.addChild(bone10);
			bone10.cubeList.add(new ModelBox(bone10, 57, 16, 7.6622F, -5.7209F, -0.5F, 2, 1, 1, 0.0F, false));

			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(3.5F, -8.5F, -1.5F);
			body.addChild(bone3);
			bone3.cubeList.add(new ModelBox(bone3, 60, 28, -0.5F, -5.5F, -0.5F, 1, 6, 1, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 56, 26, -7.5F, -5.5F, -0.5F, 1, 6, 1, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 58, 36, -4.0F, -5.5F, 1.0F, 1, 1, 1, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 52, 26, -0.5F, -5.5F, 2.5F, 1, 6, 1, 0.0F, false));
			bone3.cubeList.add(new ModelBox(bone3, 57, 24, -7.5F, -5.5F, 2.5F, 1, 6, 1, 0.0F, false));

			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.addChild(bone2);
			bone2.cubeList.add(new ModelBox(bone2, 0, 26, -2.0F, -13.0F, -2.0F, 4, 4, 4, 0.0F, false));

			bone = new ModelRenderer(this);
			bone.setRotationPoint(-3.5F, -8.5F, -1.5F);
			body.addChild(bone);
			bone.cubeList.add(new ModelBox(bone, 48, 28, 1.5F, -0.5F, -0.5F, 4, 1, 4, 0.0F, false));

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 6.0F, 0.0F);
			head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, true));

			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(2.0F, 19.0F, 0.0F);
			setRotationAngle(bone7, 0.0F, 0.0F, -0.3491F);
			head.addChild(bone7);
			bone7.cubeList.add(new ModelBox(bone7, 57, 16, 3.658F, -7.0603F, -0.5F, 1, 1, 1, 0.0F, false));

			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(3.5F, -7.5F, -2.5F);
			setRotationAngle(bone4, 0.6109F, 2.2689F, 0.0F);
			head.addChild(bone4);
			bone4.cubeList.add(new ModelBox(bone4, 58, 16, -0.5F, -0.5F, -0.5F, 1, 1, 3, 0.0F, false));

			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, -3.2766F, 2.2943F);
			setRotationAngle(bone5, 0.0F, 0.4363F, -0.1745F);
			bone4.addChild(bone5);
			bone5.cubeList.add(new ModelBox(bone5, 56, 0, 2.5843F, 3.1162F, -3.9655F, 1, 1, 3, 0.0F, false));

			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(-0.1098F, -0.4122F, -1.381F);
			setRotationAngle(bone6, 0.5236F, 0.0F, 0.0F);
			bone4.addChild(bone6);
			bone6.cubeList.add(new ModelBox(bone6, 44, 17, -1.0F, -1.0F, 0.0F, 1, 1, 2, 0.0F, false));

			backleft = new ModelRenderer(this);
			backleft.setRotationPoint(2.0F, 18.0F, 4.0F);
			backleft.cubeList.add(new ModelBox(backleft, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));

			backright = new ModelRenderer(this);
			backright.setRotationPoint(-2.0F, 18.0F, 4.0F);
			backright.cubeList.add(new ModelBox(backright, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));

			frontleft = new ModelRenderer(this);
			frontleft.setRotationPoint(2.0F, 18.0F, -4.0F);
			frontleft.cubeList.add(new ModelBox(frontleft, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));

			frontright = new ModelRenderer(this);
			frontright.setRotationPoint(-2.0F, 18.0F, -4.0F);
			frontright.cubeList.add(new ModelBox(frontright, 0, 16, -2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, true));
		}

		@Override
		public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
			body.render(f5);
			head.render(f5);
			backleft.render(f5);
			backright.render(f5);
			frontleft.render(f5);
			frontright.render(f5);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
			super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
			this.frontright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.backright.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.frontleft.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.backleft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
