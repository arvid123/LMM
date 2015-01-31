package myMod.biome;

import myMod.common.MyMod;
import myMod.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenMy extends BiomeGenBase
{
    public BiomeGenMy(int id)
    {
	super(id);
	// The name of your biome.
	this.setBiomeName(Reference.MY_BIOME_NAME);
	// The upper-most blocks in your biome (ex. grass in a plains biome).
	this.topBlock = Blocks.grass;
	// The blocks just under your top blocks (ex. dirt in a plains biome).
	this.fillerBlock = MyMod.myOre;
	// How many mushrooms should exist, per chunk, in your biome.
	this.theBiomeDecorator.bigMushroomsPerChunk = 5;
	// This actually sets the color of the grass, these values makes the grass look just like in the jungle.
	this.setTemperatureRainfall(2.1f, 1.9f);
	// How much tall grass there should be in your biome.
	this.theBiomeDecorator.grassPerChunk = 0;
	// How many flowers there should be per chunk.
	this.theBiomeDecorator.flowersPerChunk = 3;
	// Adds a flower to the list of flowers to be generated.
	// the values are: 1: block to be used as flower, 2: metadata of block,
	// 3: weight of the flower, meaning how likely it is to be generated instead of another flower (red flower = 10, yellow = 20). 
	this.addFlower(Blocks.dragon_egg, 0, 2);
    }
}
