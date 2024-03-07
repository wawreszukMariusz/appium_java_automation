package tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ExtentReport;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;
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
        loginPage.clickSignUpLink();

        registerPage = new RegisterPage(driver);
        registerPage.screenDisplayed();
    }

    @Test
    public void properRegisterTest() {
        registerPage.firstNameInputSendKeys("Mariusz");
        registerPage.lastNameInputSendKeys("Tester");
        registerPage.clickSelectCountryDropDown();
        registerPage.selectCountryModalDisplayed();
        registerPage.selectCountry("Albania");
        registerPage.phoneInputSendKeys("+48123123123");
        registerPage.emailInputSendKeys();
        registerPage.passwordInputSendKeys("Pass123@");
        registerPage.clickSignUpButton();
        registerPage.acceptAccountCreatedAlert();
    }

    @Test
    public void searchCountriesRegisterTest() {
        registerPage.firstNameInputSendKeys("Mariusz");
        registerPage.lastNameInputSendKeys("Tester");
        registerPage.clickSelectCountryDropDown();
        registerPage.selectCountryModalDisplayed();
        registerPage.selectCountryDropDownSearchInputSendKeys("China");
        registerPage.selectCountry("China");
        registerPage.phoneInputSendKeys("+48123123123");
        registerPage.emailInputSendKeys();
        registerPage.passwordInputSendKeys("Pass123@");
        registerPage.clickSignUpButton();
        registerPage.acceptAccountCreatedAlert();
    }

    @Test
    public void noDataProvidedRegisterTest() {
        registerPage.clickSignUpButton();
        registerPage.screenDisplayed();
    }

    @Test
    public void incorrectPasswordProvidedRegisterTest() {
        registerPage.firstNameInputSendKeys("Mariusz");
        registerPage.lastNameInputSendKeys("Tester");
        registerPage.clickSelectCountryDropDown();
        registerPage.selectCountryModalDisplayed();
        registerPage.selectCountry("Albania");
        registerPage.phoneInputSendKeys("+48123123123");
        registerPage.emailInputSendKeys();
        registerPage.passwordInputSendKeys("p");
        registerPage.clickSignUpButton();
        registerPage.screenDisplayed();
    }

    @Test
    public void incorrectEmailProvidedRegisterTest() {
        registerPage.firstNameInputSendKeys("Mariusz");
        registerPage.lastNameInputSendKeys("Tester");
        registerPage.clickSelectCountryDropDown();
        registerPage.selectCountryModalDisplayed();
        registerPage.selectCountry("Albania");
        registerPage.phoneInputSendKeys("+48123123123");
        registerPage.emailInputSendKeys("test");
        registerPage.passwordInputSendKeys("p");
        registerPage.clickSignUpButton();
        registerPage.screenDisplayed();
    }

    @Test
    public void leaveRegisterScreenTest() {
        registerPage.navigateBack();
        registerPage.acceptAlert("exit alert");
    }
}
