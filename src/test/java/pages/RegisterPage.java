package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends BasePage {
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "Last_name")
    private WebElement lastNameInput;

    @FindBy(id = "input_country")
    private WebElement selectCountryDropDown;

    @FindBy(id = "row_title")
    private List<WebElement> selectCountryDropdownTitleList;

    @FindBy(id = "row_icon")
    private List<WebElement> selectCountryDropdownIconList;

    @FindBy(id = "country_picker_search")
    private WebElement selectCountryDropDownSearchInput;

    @FindBy(id = "input_phone")
    private WebElement phoneInput;

    @FindBy(id = "input_email")
    private WebElement emailInput;

    @FindBy(id = "input_password")
    private WebElement passwordInput;

    @FindBy(id = "btn_signup")
    private WebElement signUpButton;

    @FindBy(id = "link_login")
    private WebElement loginLink;

    public RegisterPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpButton() {
        clickElement(this.signUpButton, "sign up button");
    }

    public void clickSelectCountryDropDown() {
        clickElement(this.selectCountryDropDown, "select country dropdown");
    }

    public void signUpButtonDisplayed() {
        elementDisplayed(this.signUpButton, "sign up button");
    }

    public void loginLinkDisplayed() {
        elementDisplayed(this.loginLink, "login link");
    }

    public void firstNameInputDisplayed() {
        elementDisplayed(this.firstNameInput, "first name input");
    }

    public void lastNameInputDisplayed() {
        elementDisplayed(this.lastNameInput, "last name input");
    }

    public void selectCountryDropDownDisplayed() {
        elementDisplayed(this.selectCountryDropDown, "select country dropdown");
    }

    public void phoneInputDisplayed() {
        elementDisplayed(this.phoneInput, "phone input");
    }

    public void emailInputDisplayed() {
        elementDisplayed(this.emailInput, "email input");
    }

    public void selectCountryDropDownSearchInputDisplayed() {
        elementDisplayed(this.selectCountryDropDownSearchInput, "select country dropdown search input");
    }

    public void passwordInputDisplayed() {
        elementDisplayed(this.passwordInput, "password input");
    }

    public void firstNameInputSendKeys(String firstName) {
        elementSendKeys(this.firstNameInput, firstName, "first name input");
    }

    public void lastNameInputSendKeys(String lastName) {
        elementSendKeys(this.lastNameInput, lastName, "last name input");
    }

    public void phoneInputSendKeys(String phone) {
        elementSendKeys(this.phoneInput, phone, "phone input");
    }

    public void emailInputSendKeys() {
        elementSendKeys(this.emailInput, randomEmail(), "email input");
    }

    public void emailInputSendKeys(String email) {
        elementSendKeys(this.emailInput, email, "email input");
    }

    public void passwordInputSendKeys(String password) {
        elementSendKeys(this.passwordInput, password, "password input");
    }

    public void selectCountryDropDownSearchInputSendKeys(String searchPhrase) {
        elementSendKeys(this.selectCountryDropDownSearchInput, searchPhrase, "select country dropdown search input");
    }

    public void acceptAccountCreatedAlert() {
        acceptAlert("account created");
    }

    public void selectCountry(String countryName) {
        for (int i = 0; i < selectCountryDropdownTitleList.size(); i++) {
            if (selectCountryDropdownTitleList.get(i).getText().contains(countryName)) {
                selectCountryDropdownTitleList.get(i).click();
                break;
            }
        }
    }

    public void searchAndSelectCountry(String countryName, String searchPhrase) {


        for (int i = 0; i < selectCountryDropdownTitleList.size(); i++) {
            if (selectCountryDropdownTitleList.get(i).getText().contains(countryName)) {
                selectCountryDropdownTitleList.get(i).click();
                break;
            }
        }
    }

    public void screenDisplayed() {
        this.firstNameInputDisplayed();
        this.lastNameInputDisplayed();
        this.selectCountryDropDownDisplayed();
        this.phoneInputDisplayed();
        this.emailInputDisplayed();
        this.passwordInputDisplayed();
        this.signUpButtonDisplayed();
        this.loginLinkDisplayed();
    }

    public void selectCountryModalDisplayed() {
        this.selectCountryDropDownSearchInputDisplayed();
        //todo icons and title
    }
}
