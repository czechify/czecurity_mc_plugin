package net.minecraft.world.entity.boss;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityPose;
import net.minecraft.world.entity.EntitySize;
import net.minecraft.world.entity.boss.enderdragon.EntityEnderDragon;

public class EntityComplexPart extends Entity {

    public final EntityEnderDragon owner;
    public final String c;
    private final EntitySize d;

    public EntityComplexPart(EntityEnderDragon entityenderdragon, String s, float f, float f1) {
        super(entityenderdragon.getEntityType(), entityenderdragon.world);
        this.d = EntitySize.b(f, f1);
        this.updateSize();
        this.owner = entityenderdragon;
        this.c = s;
    }

    @Override
    protected void initDatawatcher() {}

    @Override
    protected void loadData(NBTTagCompound nbttagcompound) {}

    @Override
    protected void saveData(NBTTagCompound nbttagcompound) {}

    @Override
    public boolean isInteractable() {
        return true;
    }

    @Override
    public boolean damageEntity(DamageSource damagesource, float f) {
        return this.isInvulnerable(damagesource) ? false : this.owner.a(this, damagesource, f);
    }

    @Override
    public boolean s(Entity entity) {
        return this == entity || this.owner == entity;
    }

    @Override
    public Packet<?> P() {
        throw new UnsupportedOperationException();
    }

    @Override
    public EntitySize a(EntityPose entitypose) {
        return this.d;
    }
}
