package pages;

import constants.AppConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementUtil;

public class LoginPage {

    private WebDriver driver;
    private ElementUtil eleUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By forgotPwdLink = By.linkText("Forgotten Password");
    private By logo = By.cssSelector("img[title='naveenopencart']");
    private By registerLink = By.linkText("Register");


    public String getLoginPageTitle() {
        String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAULT_WAIT);
        System.out.println(title);
        return title;
    }

    public String getLoginPageURL() {
        String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAULT_WAIT);
        System.out.println(url);
        return url;
    }

    public boolean isForgotPwdLinkExist() {
        return eleUtil.waitForVisibilityOfElement(forgotPwdLink, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
    }

    public boolean isLogoExist() {
        return eleUtil.waitForVisibilityOfElement(logo, AppConstants.SHORT_DEFAULT_WAIT).isDisplayed();
    }


    public DashboardPage doLogin(String username, String pwd) {
        eleUtil.waitForVisibilityOfElement(email, AppConstants.MEDIUM_DEFAULT_WAIT).sendKeys(username);
        eleUtil.doSendKeys(password, pwd);
        eleUtil.doClick(loginBtn);
        return new DashboardPage(driver);
    }

    public RegisterPage navigateToRegisterPage(){
        eleUtil.waitForVisibilityOfElement(registerLink, AppConstants.SHORT_DEFAULT_WAIT).click();
        return new RegisterPage(driver);
    }


}
