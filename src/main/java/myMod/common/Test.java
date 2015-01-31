package myMod.common;

import net.minecraft.item.Item;
import myMod.item.MyPickaxe;
import myMod.util.Reference;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Test
{
    public Item myPickaxe;
    
    
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
	myPickaxe = new MyPickaxe();
    }
    
    
    
    private void registerItems()
    {
	GameRegistry.registerItem(myPickaxe, Reference.MY_PICKAXE_UNLOCALIZED_NAME);
    }
    
    
    
    
    

}
