package net.mikuas.interval.entity.custom;

import net.mikuas.interval.entity.IzumiEntities;
import net.mikuas.interval.entity.ai.IzumiTigerAttackGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import org.jetbrains.annotations.Nullable;

public class IzumiTigerEntity extends AnimalEntity
{
    private static final TrackedData<Boolean> IS_ATTACKING = DataTracker.registerData(IzumiTigerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public static final AnimationState idleAnimation = new AnimationState();
    public static final AnimationState attackAnimation = new AnimationState();
    public int idleAnimationTimeOut = 0;
    public int attackAnimationTimeOut = 0;

    public IzumiTigerEntity(EntityType<? extends AnimalEntity> entityType, World world)
    {
        super(entityType, world);
    }

    private void setupAnimation()
    {
        if (idleAnimationTimeOut <= 0)
        {
            idleAnimationTimeOut = this.random.nextInt(40) + 80;
            idleAnimation.start(this.age);
        }
        else
        {
            idleAnimationTimeOut--;
        }

        if (this.isAttacking() && attackAnimationTimeOut <= 0)
        {
            attackAnimationTimeOut = 40;
            attackAnimation.start(this.age);
        }
        else
        {
            attackAnimationTimeOut--;
        }

        if (!this.isAttacking())
        {
            attackAnimation.stop();
        }
    }

    @Override
    public void tick()
    {
        super.tick();
        setupAnimation();
    }

    @Override
    protected void initGoals()
    {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.0D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.BEEF), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.25D));
        this.goalSelector.add(4, new WanderAroundGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.goalSelector.add(1, new IzumiTigerAttackGoal(this, 1.0D, true));
    }

    public static DefaultAttributeContainer.Builder createTigerAttributes()
    {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 200)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F)
                .add(EntityAttributes.GENERIC_ARMOR, 0.5F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.isOf(Items.BEEF);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity)
    {
        return IzumiEntities.TIGER.create(world);
    }

    @Override
    protected void updateLimbs(float posDelta)
    {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder)
    {
        super.initDataTracker(builder);
        builder.add(IS_ATTACKING, false);
    }

    public void setAttacking(boolean attacking)
    {
        this.dataTracker.set(IS_ATTACKING, attacking);
    }

    public boolean isAttacking()
    {
        return this.dataTracker.get(IS_ATTACKING);
    }
}
