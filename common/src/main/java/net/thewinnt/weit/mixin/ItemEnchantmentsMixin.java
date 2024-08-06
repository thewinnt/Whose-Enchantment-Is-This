package net.thewinnt.weit.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.thewinnt.weit.Weit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(ItemEnchantments.class)
public class ItemEnchantmentsMixin {
    @Redirect(method = "addToTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/Enchantment;getFullname(I)Lnet/minecraft/network/chat/Component;"))
    private Component weit$showInfo(Enchantment instance, int i) {
        MutableComponent component;
        if (Screen.hasAltDown()) {
            component = Component.literal(BuiltInRegistries.ENCHANTMENT.getKey(instance).toString());
            if (instance.isCurse()) {
                component.withStyle(ChatFormatting.RED);
            } else {
                component.withStyle(ChatFormatting.GRAY);
            }

            if (i != 1 || instance.getMaxLevel() != 1) {
                component.append(CommonComponents.SPACE).append(Component.translatable("enchantment.level." + i));
            }
        } else {
            component = (MutableComponent) instance.getFullname(i);
        }
        if (Screen.hasControlDown()) {
            String modId = BuiltInRegistries.ENCHANTMENT.getKey(instance).getNamespace();
            component.append(" - ").append(Component.literal(Weit.platform().getModName(modId)).withStyle(ChatFormatting.ITALIC));
        }
        return component;
    }
}
