package com.vomiter.savebabystriders.mixin;

import net.minecraft.world.entity.monster.Strider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = Strider.class)
public class StriderMixin {
    @ModifyArg(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Strider;setSuffocating(Z)V"))
    private boolean saveStridersOnStriders(boolean flag){
        Strider $this = (Strider)(Object)this;
        if($this.getVehicle() == null) return flag;
        if($this.getVehicle() instanceof Strider parentStrider){
            return parentStrider.isSuffocating();
        }
        return flag;
    }
}
