package cc.minetale.quartz.config;

import lombok.Getter;

@Getter
public class Config {

    private String address = "0.0.0.0";
    private int port = 25565;
    private boolean velocityEnabled = false;
    private String velocitySecret = "";

}
