package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "input_email")
    private WebElement emailInput;

    @FindBy(id = "input_password")
    private WebElement passwordInput;

    @FindBy(id = "btn_login")
    private WebElement loginButton;

    @FindBy(id = "link_signup")
    private WebElement signUpLink;

    @FindBy(id = "forget_password")
    private WebElement resetPasswordLink;

    @FindBy(id = "text_input_end_icon")
    private WebElement showPasswordEye;

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        clickElement(this.loginButton, "login button");
    }

    public void clickSignUpLink() {
        clickElement(this.signUpLink, "sign up link");
    }

    public void emailInputDisplayed() {
        elementDisplayed(this.emailInput, "email input");
    }

    public void passwordInputDisplayed() {
        elementDisplayed(this.passwordInput, "password input");
    }

    public void loginButtonDisplayed() {
        elementDisplayed(this.loginButton, "login button");
    }

    public void signUpLinkDisplayed() {
        elementDisplayed(this.signUpLink, "sign up link");
    }

    public void resetPasswordLinkDisplayed() {
        elementDisplayed(this.loginButton, "reset password link");
    }

    public void showPasswordEyeDisplayed() {
        elementDisplayed(this.showPasswordEye, "show password eye");
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

    public void checkNotVerifiedAccountAlertText() {
        checkAlertText("not verified account", "user account not verified");
    }


    public void screenDisplayed() {
        this.emailInputDisplayed();
        this.passwordInputDisplayed();
        this.loginButtonDisplayed();
        this.signUpLinkDisplayed();
        this.resetPasswordLinkDisplayed();
        this.showPasswordEyeDisplayed();
    }

}
