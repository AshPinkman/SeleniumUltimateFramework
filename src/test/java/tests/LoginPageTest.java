package tests;

import base.BaseTest;
import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginPageURLTest() {
        String actURL = loginPage.getLoginPageURL();
        Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
    }

    @Test(priority = 3)
    public void forgotPwdLinkExistTest() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @Test(priority = 4)
    public void appLogoExist() {
        Assert.assertTrue(loginPage.isLogoExist());
    }

    @Test(priority = 5)
    public void loginTest() {
        dashboardPage = loginPage.doLogin("ashfaqparvez786@gmail.com", "ashfaq12345");
        Assert.assertTrue(dashboardPage.isLogoutLinkPresent());
    }


}
