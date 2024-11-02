package com.existingeevee.moretcon.mixin.late.common;

import javax.annotation.Nonnull;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.existingeevee.moretcon.other.StaticVars;
import com.existingeevee.moretcon.traits.traits.abst.IAdditionalTraitMethods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.AmmoHelper;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mixin(EntityProjectileBase.class)
public class MixinEntityProjectileBase {

	@Inject(at = @At(value = "TAIL"), method = { "onCollideWithPlayer", "func_70100_b_" }, remap = false)
	public void moretcon$TAIL_Inject$onCollideWithPlayer(@Nonnull EntityPlayer player, CallbackInfo ci) {
		EntityProjectileBase $this = (EntityProjectileBase) (Object) this;
		ItemStack stack = StaticVars.lastArrowPickup.get();
		if ($this.isDead && !stack.isEmpty()) {

			for (ITrait t : ToolHelper.getTraits(stack)) {
				if (t instanceof IAdditionalTraitMethods) {
					((IAdditionalTraitMethods) t).onPickup($this, stack, player);
				}
			}

			StaticVars.lastArrowPickup.set(ItemStack.EMPTY);
		}
	}

	@Redirect(method = "onHitEntity(Lnet/minecraft/util/math/RayTraceResult;)V", at = @At(value = "INVOKE", target = "Lslimeknights/tconstruct/library/utils/AmmoHelper;getMatchingItemstackFromInventory(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/Entity;Z)Lnet/minecraft/item/ItemStack;"))
	private ItemStack moretcon$INVOKE_Redirect_getMatchingItemstackFromInventory$onHitEntity(ItemStack stack, Entity entity, boolean damagedOnly) {
		if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("PreventInvLink")) {
			return ItemStack.EMPTY;
		} 
		return AmmoHelper.getMatchingItemstackFromInventory(stack, entity, damagedOnly);
	}

}
