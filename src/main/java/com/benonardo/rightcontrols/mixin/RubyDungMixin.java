package com.benonardo.rightcontrols.mixin;

import com.mojang.rubydung.RubyDung;
import com.mojang.rubydung.level.Level;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RubyDung.class)
public class RubyDungMixin {

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lorg/lwjgl/input/Mouse;getEventButton()I"))
    private int invertClicks() {
        if (Mouse.getEventButton() == 1) {
            return 0;
        } else {
            return 1;
        }
    }

}
