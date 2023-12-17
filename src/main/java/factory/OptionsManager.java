package factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigLoader;

import java.util.Properties;

public class OptionsManager {


    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    public OptionsManager() {

    }


    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("headless").trim())) co.addArguments("--headless");
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("incognito").trim())) co.addArguments("--incognito");
        return co;
    }

    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("headless").trim())) fo.addArguments("--headless");
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("incognito").trim())) fo.addArguments("--incognito");
        return fo;
    }

    public EdgeOptions getEdgeOptions() {
        eo = new EdgeOptions();
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("headless").trim())) eo.addArguments("--headless");
        if(Boolean.parseBoolean(ConfigLoader.getInstance().get("incognito").trim())) eo.addArguments("--incognito");
        return eo;
    }


}
