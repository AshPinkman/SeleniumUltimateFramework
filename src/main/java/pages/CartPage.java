package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;
import utils.JavaScriptUtil;

public class CartPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil javaScriptUtil;


    private By checkout = By.linkText("Checkout");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    public CheckoutPage navigateToCheckoutPage() {
        eleUtil.waitForVisibilityOfElement(checkout, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        return new CheckoutPage(driver);
    }

}
