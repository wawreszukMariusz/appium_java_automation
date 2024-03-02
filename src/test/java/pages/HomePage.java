package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ExtentReport;

import java.util.List;

public class HomePage {

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
            try {
                Assert.assertTrue(this.homeTextTitle.isDisplayed());
                ExtentReport.pass("Checking display of home text title done");
            } catch (AssertionError e) {
                ExtentReport.fail("Checking display of home text title failed");
            }
    }
    public void homeTextSubtitleDisplayed(){
        try {
            Assert.assertTrue(this.homeTextSubtitle.isDisplayed());
            ExtentReport.pass("Checking display of home text subtitle done");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of home text subtitle failed");
        }
    }

    public void featuredHotelTextDisplayed(){
        try {
            Assert.assertTrue(this.featuredHotelText.isDisplayed());
            ExtentReport.pass("Checking display of featured hotel text done");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of featured hotel text failed");
        }
    }

    public void featuredHotelCardDisplayed(){
        try {
            Assert.assertTrue(this.featuredHotelCard.isDisplayed());
            ExtentReport.pass("Checking display of featured hotel card done");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of featured hotel card failed");
        }
    }

    public void productListDisplayed(){
        try {
            Assert.assertEquals(this.productList.size(), 4);
            ExtentReport.pass("Checking display of product list done");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of product list failed");
        }
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
