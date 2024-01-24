package test.test.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties",
})
public interface BrowserDriverConfig extends Config {
    @Key("browser")
    String getBrowserName();
    @Key("version")
    String getBrowserVersion();
    @Key("remote")
    String getRemoteWebDriver();
}
