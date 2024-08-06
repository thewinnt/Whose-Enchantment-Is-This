//package net.thewinnt.weit.mixin;
//
//import com.llamalad7.mixinextras.sugar.Local;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.ChatFormatting;
//import net.minecraft.client.gui.screens.Screen;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.network.chat.Component;
//import net.minecraft.network.chat.MutableComponent;
//import net.minecraft.world.item.enchantment.Enchantment;
//import net.thewinnt.weit.Weit;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.Redirect;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Environment(EnvType.CLIENT)
//@Mixin(value = Enchantment.class, priority = 1001)
//public class EnchantmentMixin {
//    @Redirect(method = "getFullname", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;getDescriptionId()Ljava/lang/String;"))
//    private String weit$showEnchantmentId(Enchantment instance) {
//        if (Screen.hasAltDown()) {
//            return BuiltInRegistries.ENCHANTMENT.getKey(instance).toString();
//        }
//        return instance.getDescriptionId();
//    }
//
//    @Inject(method = "getFullname", at = @At(value = "RETURN"))
//    private void weit$showModName(int i, CallbackInfoReturnable<Component> cir, @Local MutableComponent component) {
//        if (Screen.hasControlDown()) {
//            String modId = BuiltInRegistries.ENCHANTMENT.getKey((Enchantment) (Object) this).getNamespace();
//            component.append(" - ").append(Component.literal(Weit.platform().getModName(modId)).withStyle(ChatFormatting.ITALIC));
//        }
//    }
//}
