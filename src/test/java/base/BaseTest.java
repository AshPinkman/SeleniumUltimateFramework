package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import pages.*;
import utils.ConfigLoader;

public class BaseTest {

    protected WebDriver driver;
    private DriverFactory df;
    protected SoftAssert softAssert;
    protected RegisterPage registerPage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SearchResultsPage searchResultsPage;
    protected ProductInfoPage productInfoPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;


    @BeforeMethod
    public void setUp() {
        df = new DriverFactory();
        driver = df.initDriver(ConfigLoader.getInstance().get("browser"));
        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
        dashboardPage = loginPage.doLogin(ConfigLoader.getInstance().get("username"), ConfigLoader.getInstance().get("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
