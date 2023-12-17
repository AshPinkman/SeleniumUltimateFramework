package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;

import java.util.List;

public class DashboardPageTest extends BaseTest {


    @Test
    public void dashboardPageTitleTest() {
        Assert.assertEquals(dashboardPage.getDashboardPageTitle(), AppConstants.DASHBOARD_PAGE_TITLE);
    }

    @Test
    public void dashboardPageURLTest() {
        Assert.assertTrue(dashboardPage.getDashboardPageURL().contains(AppConstants.DASHBOARD_PAGE_URL_FRACTION));
    }

    @Test
    public void isLogoutLinkPresentTest() {
        Assert.assertTrue(dashboardPage.isLogoutLinkPresent());
    }

    @Test
    public void isSearchFieldPresentTest() {
        Assert.assertTrue(dashboardPage.isSearchFieldPresent());
    }

    @Test
    public void dashboardPageHeadersCountTest() {
        List<String> actdashboardPageHeadersList = dashboardPage.getAccountHeaders();
        Assert.assertEquals(actdashboardPageHeadersList.size(), AppConstants.DASHBOARD_PAGE_HEADERS_COUNT);
    }

    @Test
    public void dashboardPageHeadersTest() {
        List<String> actdashboardPageHeadersList = dashboardPage.getAccountHeaders();
        Assert.assertEquals(actdashboardPageHeadersList, AppConstants.DASHBOARD_PAGE_HEADER_LIST);
    }

    @Test
    public void searchTest() {
        searchResultsPage = dashboardPage.doSearch("MacBook");
        productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
        String actProductHeader = productInfoPage.getProductHeaderName();
        Assert.assertEquals(actProductHeader, "MacBook Pro");
    }


}
