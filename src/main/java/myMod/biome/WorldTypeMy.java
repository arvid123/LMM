package myMod.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeMy extends WorldType
{
    public WorldTypeMy(String name)
    {
	super(name);
    }
    
    // This method is called by minecraft to determine which "Layer" (biomes) to generate.
    public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer)
    {
        GenLayer ret = new MyGenLayerBiome(200L, parentLayer, this);
        ret = GenLayerZoom.magnify(1000L, ret, 2);
        ret = new GenLayerBiomeEdge(1000L, ret);
        return ret;
    }
}
