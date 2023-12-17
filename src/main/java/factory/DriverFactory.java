package factory;

import exceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigLoader;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver initDriver(String browserName) {

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new InvalidBrowserException("Please enter correct Browser Name");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(ConfigLoader.getInstance().get("url"));

        return driver;

    }

}
