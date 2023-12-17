package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }


    private By logoutLink = By.linkText("Logout");
    private By search = By.name("search");
    private By searchIcon = By.cssSelector("div#search button");
    private By accHeaders = By.cssSelector("div#content > h2");

    public String getDashboardPageTitle() {
        String title = eleUtil.waitForTitleIs(AppConstants.DASHBOARD_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
        System.out.println(title);
        return title;
    }

    public String getDashboardPageURL() {
        String url = eleUtil.waitForURLContains(AppConstants.DASHBOARD_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
        System.out.println(url);
        return url;
    }

    public boolean isLogoutLinkPresent() {
        return eleUtil.waitForVisibilityOfElement(logoutLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
    }

    public void logout() {
        if (isLogoutLinkPresent()) {
            eleUtil.doClick(logoutLink);
        }
    }

    public boolean isSearchFieldPresent() {
        return eleUtil.waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
    }

    public List<String> getAccountHeaders() {
        List<WebElement> headersList = eleUtil.waitForVisibilityOfElements(accHeaders, AppConstants.MEDIUM_DEFAULT_WAIT);
        List<String> headersValList = new ArrayList<>();
        for (WebElement e : headersList) {
            String text = e.getText();
            headersValList.add(text);
        }
        return headersValList;
    }


    public SearchResultsPage doSearch(String searchKey){
        eleUtil.waitForVisibilityOfElement(search, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(searchKey);
        eleUtil.doClick(searchIcon);
        return new SearchResultsPage(driver);
    }


}
