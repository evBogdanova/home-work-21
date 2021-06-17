package config;

import org.aeonbits.owner.Config;

import java.net.URL;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${device.host}.properties",
        "classpath:config/local.properties"
})
public interface AppiumConfig extends Config {

    @Key("selenoid.url")
    String appiumServerUrl();

    @Key("selenoid.user")
    String appiumServerUser();

    @Key("selenoid.password")
    String appiumServerPassword();

    @Key("video.storage")
    String videoStorage();

    @Key("platform.name")
    String platformName();

    @Key("device.name")
    String deviceName();

    @Key("version")
    String version();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("app.package")
    String appPackage();

    @Key("app.activity")
    String appActivity();

    @Key("app.url")
    URL appUrl();
}