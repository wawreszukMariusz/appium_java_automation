package tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExtentReport;
import utils.PropertiesLoader;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeTest(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

        homePage = new HomePage(driver);
        homePage.screenDisplayed();
        homePage.clickMenuButton();
        homePage.menuModalDisplayed();
        homePage.clickMenuLoginRegisterButton();

        loginPage = new LoginPage(driver);
        loginPage.screenDisplayed();
    }

    @Test
    public void accountNotVerifiedTest() {
        loginPage.emailInputSendKeys(PropertiesLoader.loadProperty("account.login"));
        loginPage.passwordInputSendKeys(PropertiesLoader.loadProperty("account.password"));
        loginPage.clickLoginButton();
        loginPage.checkNotVerifiedAccountAlertText();
    }
}
