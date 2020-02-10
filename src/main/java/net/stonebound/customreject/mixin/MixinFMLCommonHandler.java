package net.stonebound.customreject.mixin;

import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.stonebound.customreject.CustomReject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = FMLCommonHandler.class, priority = 1001, remap = false)
public class MixinFMLCommonHandler {
    @ModifyVariable(method = "handleServerHandshake",
            at = @At(value = "STORE", ordinal = 1), name = "text")
    private TextComponentString text(TextComponentString text) {
        return new TextComponentString(CustomReject.ModConfig.rejectionMessageNoFML);
    }
}

