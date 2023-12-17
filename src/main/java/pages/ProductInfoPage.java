package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductInfoPage {

    private WebDriver driver;
    private ElementUtil eleUtil;


    private By productHeader = By.cssSelector("div#content h1");
    private By productImages = By.cssSelector("ul.thumbnails img");
    private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
    private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
    private Map<String, String> productMap = new LinkedHashMap<>();

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getProductHeaderName() {
        return eleUtil.getElementText(productHeader);
    }

    public int getProductImagesCount() {
        return eleUtil.waitForVisibilityOfElements(productImages, AppConstants.MEDIUM_DEFAULT_WAIT).size();
    }

    private void getProductMetaData() {
        List<WebElement> metaDataList = eleUtil.waitForVisibilityOfElements(productMetaData, AppConstants.MEDIUM_DEFAULT_WAIT);
        for (WebElement e : metaDataList) {
            String metaData = e.getText();
            String metaKey = metaData.split(":")[0].trim();
            String metaValue = metaData.split(":")[1].trim();
            productMap.put(metaKey, metaValue);
        }
    }

    private void getProductPriceData() {
        List<WebElement> metaPriceList = eleUtil.waitForVisibilityOfElements(productPriceData, AppConstants.MEDIUM_DEFAULT_WAIT);

        String productPrice = metaPriceList.get(0).getText();
        String productExTaxPrice = metaPriceList.get(1).getText().split(":")[1].trim();

        productMap.put("price", productPrice);
        productMap.put("extaxprice", productExTaxPrice);
    }

    public Map<String, String> getProductDetails(){
        productMap.put("productname",getProductHeaderName());
        getProductMetaData();
        getProductPriceData();
        return productMap;
    }


}
