package myMod.event;

import net.minecraft.item.ItemStack;
import myMod.common.MyMod;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class MyOnCraftEvent
{
    @SubscribeEvent
    public void onSmelt(PlayerEvent.ItemCraftedEvent e)
    {
	if (e.crafting.getItem() == MyMod.mySword) 
	{
	    e.player.addStat(MyMod.achievementMySword, 1);
	}
    }
}
