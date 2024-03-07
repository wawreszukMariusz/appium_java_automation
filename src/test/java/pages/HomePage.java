package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "titletexthome")
    private WebElement homeTextTitle;

    @FindBy(id = "subtitletexthome")
    private WebElement homeTextSubtitle;

    @FindBy(id = "main_div")
    private List<WebElement> productList;

    @FindBy(id = "txtFeaturedHotel")
    private WebElement featuredHotelText;

    @FindBy(id = "txtFeaturedHotel")
    private WebElement featuredHotelCard;

    @FindBy(id = "sidedrawer")
    private WebElement menuButton;

    @FindBy(id = "loginreg")
    private WebElement menuLoginRegisterButton;

    @FindBy(id = "home")
    private WebElement menuHomeButton;

    @FindBy(id = "blog")
    private WebElement menuBlogButton;

    @FindBy(id = "contactus")
    private WebElement menuContactUsButton;

    @FindBy(id = "setting")
    private WebElement menuSettingsButton;

    @FindBy(id = "navigation")
    private WebElement menuFrameLayout;

    public void clickMenuButton() {
        clickElement(this.menuButton, "menu button");
    }

    public void clickMenuLoginRegisterButton() {
        clickElement(this.menuLoginRegisterButton, "menu login and register button");
    }

    public void clickProduct(int productNumber) {
        clickElement(productList.get(productNumber), "product");
    }

    public void menuLoginRegisterButtonDisplayed() {
        elementDisplayed(this.menuLoginRegisterButton, "menu login and register button");
    }

    public void menuFrameLayoutDisplayed() {
        elementDisplayed(this.menuFrameLayout, "menu frame layout");
    }

    public void menuSettingsButtonDisplayed() {
        elementDisplayed(this.menuSettingsButton, "menu settings button");
    }


    public void menuContactUsButtonDisplayed() {
        elementDisplayed(this.menuContactUsButton, "menu contact us button");
    }

    public void menuButtonDisplayed() {
        elementDisplayed(this.menuButton, "menu button");
    }

    public void menuHomeButtonDisplayed() {
        elementDisplayed(this.menuHomeButton, "menu home button");
    }

    public void menuBlogButtonDisplayed() {
        elementDisplayed(this.menuBlogButton, "menu blog button");
    }

    public void homeTextTitleDisplayed() {
        elementDisplayed(homeTextTitle, "home text title");
    }

    public void homeTextSubtitleDisplayed() {
        elementDisplayed(homeTextSubtitle, "home text subtitle");
    }

    public void featuredHotelTextDisplayed() {
        elementDisplayed(featuredHotelText, "featured hotel text");
    }

    public void featuredHotelCardDisplayed() {
        elementDisplayed(featuredHotelCard, "featured hotel card");
    }

    public void productListDisplayed() {
        elementDisplayed(this.productList, 4, "product list");
    }

    public HomePage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void menuModalDisplayed() {
        this.menuLoginRegisterButtonDisplayed();
        this.menuHomeButtonDisplayed();
        this.menuBlogButtonDisplayed();
        this.menuContactUsButtonDisplayed();
        this.menuSettingsButtonDisplayed();
    }

    public void screenDisplayed() {
        this.homeTextTitleDisplayed();
        this.homeTextSubtitleDisplayed();
        this.productListDisplayed();
        this.featuredHotelTextDisplayed();
        this.featuredHotelCardDisplayed();
        this.menuButtonDisplayed();
    }

}
