package cc.minetale.quartz;

import cc.minetale.quartz.config.Config;
import cc.minetale.quartz.config.ConfigLoader;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.extras.velocity.VelocityProxy;

import java.io.File;
import java.io.IOException;

public class QuartzServer {

    public static void main(String[] args) {
        try {
            File configFile = new File("config.json");
            Config config = ConfigLoader.loadConfig(new Config(), configFile);

            if(config != null) {
                MinecraftServer minecraftServer = MinecraftServer.init();

                MinecraftServer.setBrandName("§b§lQuartz§r");

                if (config.isVelocityEnabled())
                    VelocityProxy.enable(config.getVelocitySecret());
                else
                    MojangAuth.init();

                minecraftServer.start(config.getAddress(), config.getPort());
            } else {
                MinecraftServer.stopCleanly();
            }
        } catch (IOException e) {
            e.printStackTrace();
            MinecraftServer.stopCleanly();
        }
    }

}
