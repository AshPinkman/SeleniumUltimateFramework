package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;
import utils.JavaScriptUtil;

public class CheckoutPage {

    private WebDriver driver;
    private ElementUtil eleUtil;
    private JavaScriptUtil javaScriptUtil;


    private By billingContinueBtn = By.id("button-payment-address");
    private By deliveryContinueBtn = By.id("button-shipping-address");
    private By deliveryMethodContinueBtn = By.id("button-shipping-method");
    private By paymentChkBox = By.xpath("//input[@name='agree']");
    private By paymentBtn = By.id("button-payment-method");
    private By confirmBtn = By.id("button-confirm");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
        javaScriptUtil = new JavaScriptUtil(driver);
    }

    public void checkoutOrder(){
        eleUtil.waitForVisibilityOfElement(billingContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        eleUtil.waitForVisibilityOfElement(deliveryContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        eleUtil.waitForVisibilityOfElement(deliveryMethodContinueBtn, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        eleUtil.waitForVisibilityOfElement(paymentChkBox, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        eleUtil.waitForVisibilityOfElement(paymentBtn, AppConstants.MEDIUM_DEFAULT_WAIT).click();
        eleUtil.waitForVisibilityOfElement(confirmBtn, AppConstants.MEDIUM_DEFAULT_WAIT).click();
    }

}
