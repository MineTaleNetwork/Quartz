package cc.minetale.quartz;

import net.minestom.server.MinecraftServer;
import net.minestom.server.extras.MojangAuth;
import net.minestom.server.extras.velocity.VelocityProxy;

public class Quartz {

    public static void main(String[] args) {
        var minecraftServer = MinecraftServer.init();

        MinecraftServer.setBrandName("Quartz");

        if (Boolean.getBoolean("velocityEnabled")) {
            VelocityProxy.enable(System.getProperty("velocitySecret", "none"));
        } else {
            MojangAuth.init();
        }

        minecraftServer.start(System.getProperty("bindAddress", "0.0.0.0"), Integer.getInteger("serverPort", 25565));
    }

}
