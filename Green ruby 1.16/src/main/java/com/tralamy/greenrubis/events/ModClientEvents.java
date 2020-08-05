package com.tralamy.greenrubis.events;

import com.tralamy.greenrubis.GreenRubis;
import com.tralamy.greenrubis.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = GreenRubis.MODE_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    public static List<EffectInstance> onFullRubyArmorEffect = new ArrayList<>();

    private static int start = 0;
    private static void Start()
    {
        onFullRubyArmorEffect.add(new EffectInstance(Effects.INVISIBILITY, 60*20, 2));
        onFullRubyArmorEffect.add(new EffectInstance(Effects.HASTE, 60*20, 2));
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event)
    {
        if(start == 0){
            Start();
            start++;
        }
        List<ItemStack> narmor = new ArrayList<>();
        narmor.add(new ItemStack(ModItems.RUBY_HELMET.get()));
        narmor.add(new ItemStack(ModItems.RUBY_CHESTPLATE.get()));
        narmor.add(new ItemStack(ModItems.RUBY_LEGGINGS.get()));
        narmor.add(new ItemStack(ModItems.RUBY_BOOTS.get()));

        PlayerEntity player = event.player;
        List<ItemStack> armor = (List<ItemStack>) player.getArmorInventoryList();

        if(
                armor.get(3).getStack().isItemEqualIgnoreDurability(narmor.get(0)) &&
                armor.get(2).getStack().isItemEqualIgnoreDurability(narmor.get(1)) &&
                armor.get(1).getStack().isItemEqualIgnoreDurability(narmor.get(2)) &&
                armor.get(0).getStack().isItemEqualIgnoreDurability(narmor.get(3)))
        {
            for (EffectInstance effect :
                    onFullRubyArmorEffect) {
                if (!player.isPotionActive(effect.getPotion())){
                    player.addPotionEffect(effect);
                }
            }
        }
        else
        {
            for (EffectInstance effect :
                    onFullRubyArmorEffect) {
                if (player.isPotionActive(effect.getPotion())) {
                    player.removePotionEffect(effect.getPotion());
                }
            }
        }
    }
}
