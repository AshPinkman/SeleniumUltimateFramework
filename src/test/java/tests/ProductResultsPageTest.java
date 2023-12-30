package tests;

import annotations.FrameworkAnnotation;
import base.BaseTest;
import dataproviders.FrameworkDataProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductResultsPageTest extends BaseTest {

    @FrameworkAnnotation(author = "Ashfaq",category = "Sanity")
    @Test(dataProvider = "getDataForProductImagesTest", dataProviderClass = FrameworkDataProvider.class)
    public void productImagesTest(String searchKey, String productName, int imageCount) {
        searchResultsPage = dashboardPage.doSearch(searchKey);
        productInfoPage = searchResultsPage.selectProduct(productName);
        Assert.assertEquals(productInfoPage.getProductImagesCount(), imageCount);
    }

    @FrameworkAnnotation(author = "Ashfaq",category = "Sanity")
    @Test
    public void productInfoTest() {
        searchResultsPage = dashboardPage.doSearch("MacBook");
        productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
        Map<String, String> productDetailsMap = productInfoPage.getProductDetails();

        softAssert.assertEquals(productDetailsMap.get("Brand"), "Apple");
        softAssert.assertEquals(productDetailsMap.get("Availability"), "In Stock");
        softAssert.assertEquals(productDetailsMap.get("Product Code"), "Product 18");
        softAssert.assertEquals(productDetailsMap.get("Reward Points"), "801");

        softAssert.assertEquals(productDetailsMap.get("price"), "$2,000.00");
        softAssert.assertEquals(productDetailsMap.get("extaxprice"), "$2,000.00");

        softAssert.assertAll();
    }


}
