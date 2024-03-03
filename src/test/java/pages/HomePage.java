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


    public void homeTextTitleDisplayed(){
        elementDisplayed(homeTextTitle, "home text title");
    }
    public void homeTextSubtitleDisplayed(){
        elementDisplayed(homeTextSubtitle, "home text subtitle");
    }

    public void featuredHotelTextDisplayed(){
        elementDisplayed(featuredHotelText, "featured hotel text");
    }

    public void featuredHotelCardDisplayed(){
        elementDisplayed(featuredHotelCard, "featured hotel card");
    }

    public void productListDisplayed(){
        elementDisplayed(this.productList, 4, "product list");
    }

    public void clickProduct(int productNumber){
        clickElement(productList.get(productNumber), "product");
    }

    public HomePage(AndroidDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void screenDisplayed(){
        this.homeTextTitleDisplayed();
        this.homeTextSubtitleDisplayed();
        this.productListDisplayed();
        this.featuredHotelTextDisplayed();
        this.featuredHotelCardDisplayed();
    }

}
