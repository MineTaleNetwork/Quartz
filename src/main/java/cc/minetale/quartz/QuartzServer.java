package cc.minetale.quartz;

import cc.minetale.quartz.config.Config;
import cc.minetale.quartz.config.ConfigLoader;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.velocity.VelocityProxy;

import java.io.File;
import java.io.IOException;

public class QuartzServer {

    public static void main(String[] args) {
        Config config = null;

        try {
            File configFile = new File("config.json");
            config = ConfigLoader.loadConfig(new Config(), configFile);
        } catch (IOException e) {
            e.printStackTrace();
            MinecraftServer.stopCleanly();
        }

        if(config != null) {
            MinecraftServer minecraftServer = MinecraftServer.init();

            MinecraftServer.setBrandName("§b§lQuartz§r");

            MinecraftServer.getCommandManager().setUnknownCommandCallback((sender, command) -> sender.sendMessage(Component.text("You have entered an unknown command.", NamedTextColor.RED)));

            VelocityProxy.enable(config.getVelocitySecret());

            minecraftServer.start(config.getAddress(), config.getPort());
        }
    }

}
