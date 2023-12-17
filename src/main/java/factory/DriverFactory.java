package factory;

import exceptions.InvalidBrowserException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigLoader;

public class DriverFactory {

    private WebDriver driver;
    OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(String browserName) {

        optionsManager = new OptionsManager();

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                break;

            case "firefox":
                tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
                break;

            case "edge":
                tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
                break;

            default:
                throw new InvalidBrowserException("Please enter correct Browser Name");
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().get(ConfigLoader.getInstance().get("url"));

        return getDriver();

    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static String getBase64Image(){
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }


}
