package cc.minetale.quartz.generator;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.ChunkGenerator;
import net.minestom.server.instance.ChunkPopulator;
import net.minestom.server.instance.batch.ChunkBatch;
import net.minestom.server.world.biomes.Biome;

import java.util.Arrays;
import java.util.List;

public class VoidGenerator implements ChunkGenerator {

    @Override
    public void generateChunkData(ChunkBatch batch, int chunkX, int chunkZ) {}

    @Override
    public void fillBiomes(Biome[] biomes, int chunkX, int chunkZ) {
        Arrays.fill(biomes, MinecraftServer.getBiomeManager().getById(0));
    }

    @Override
    public List<ChunkPopulator> getPopulators() {
        return null;
    }
}
