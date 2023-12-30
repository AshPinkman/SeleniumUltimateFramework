package tests;

import annotations.FrameworkAnnotation;
import base.BaseTest;
import dataproviders.FrameworkDataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class E2ETest extends BaseTest {

    @FrameworkAnnotation(author = {"Ashfaq"},category = {"Sanity"})
    @Test(dataProvider = "getDataForPlaceOrderTest", dataProviderClass = FrameworkDataProvider.class)
    public void placeAnOrderTest(Map<String, String> data) {
        searchResultsPage = dashboardPage.doSearch(data.get("searchproduct"));
        productInfoPage = searchResultsPage.selectProduct(data.get("selectproduct"));
        cartPage = productInfoPage.addProductToCart(Integer.parseInt(data.get("noofproducts"))).navigateToCartPage();
        checkoutPage = cartPage.navigateToCheckoutPage();
        checkoutPage.checkoutOrder();
    }

}
