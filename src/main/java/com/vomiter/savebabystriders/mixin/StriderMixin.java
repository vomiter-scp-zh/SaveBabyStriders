package com.vomiter.savebabystriders.mixin;

import com.vomiter.savebabystriders.Config;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Strider.class)
public abstract class StriderMixin extends Animal {
    @Unique
    private boolean savebabystriders$wasBaby;

    protected StriderMixin(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Strider;setSuffocating(Z)V"))
    private boolean saveStridersOnStriders(boolean flag){
        Strider $this = (Strider)(Object)this;
        if($this.getVehicle() == null) return flag;
        if($this.getVehicle() instanceof Strider parentStrider){
            return parentStrider.isSuffocating();
        }
        return flag;
    }

    @Inject(
            method = {"tick"},
            at = {@At("HEAD")}
    )
    private void rememberBabyState(CallbackInfo ci) {
        this.savebabystriders$wasBaby = isBaby();
    }

    @Inject(
            method = {"tick"},
            at = {@At("TAIL")}
    )
    private void savebabystriders$autoDismountOnGrow(CallbackInfo ci) {
        if (!this.level.isClientSide) {
            if (Config.ADULT_STRIDER_LEAVES_MOUNT_ON_GROW) {
                if (this.savebabystriders$wasBaby && !this.isBaby() && this.getVehicle() instanceof Strider) {
                    this.stopRiding();
                }

            }
        }
    }

}
