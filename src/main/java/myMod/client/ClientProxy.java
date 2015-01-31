package myMod.client;

import myMod.client.model.ModelRainbowSheep_1;
import myMod.client.model.ModelRainbowSheep_2;
import myMod.client.renderer.entity.RenderRainbowSheep;
import myMod.common.CommonProxy;
import myMod.entity.EntityRainbowSheep;
import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * This is the client-side proxy which registers renderers and such on the client side.
 */
public class ClientProxy extends CommonProxy
{
    public void registerRenderers() 
    {
	RenderingRegistry.registerEntityRenderingHandler(EntityRainbowSheep.class, new RenderRainbowSheep(new ModelRainbowSheep_2(), new ModelRainbowSheep_1(), 0.8f));
    }
}
