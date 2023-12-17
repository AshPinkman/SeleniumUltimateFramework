package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class SearchResultsPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public ProductInfoPage selectProduct(String productName) {
        eleUtil.waitForVisibilityOfElement(By.linkText(productName), AppConstants.MEDIUM_DEFAULT_WAIT).click();
        return new ProductInfoPage(driver);
    }

}
