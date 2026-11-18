package liltojustice.novehicleasphyxiation.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class HurtMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void hurt(DamageSource p_36154_, float p_36155_, CallbackInfoReturnable<Boolean> cir)
    {
        Player playerEntity = (Player)(Object)this;
        if (p_36154_.is(DamageTypes.IN_WALL) && playerEntity.getVehicle() != null) {
            cir.setReturnValue(false);
        }
    }
}
