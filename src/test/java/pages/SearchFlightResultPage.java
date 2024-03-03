package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchFlightResultPage extends BasePage {

    @FindBy(id = "rlOneway")
    private List<WebElement> oneWayFlightList;

    @FindBy(id = "tv_FromCityCode")
    private WebElement fromCityIso;

    @FindBy(id = "tv_ToCityCode")
    private WebElement toCityIso;

    @FindBy(id = "pNametxt")
    private List<WebElement> flightPriceList;

    @FindBy(id = "fromcity1")
    private List<WebElement> flightCityFromList;

    @FindBy(id = "tocity1")
    private List<WebElement> flightCityToList;

    @FindBy(id = "timefrom1")
    private List<WebElement> flightTimeFromList;

    @FindBy(id = "timeto1")
    private List<WebElement> flightTimeToList;

    @FindBy(id = "airlinename")
    private List<WebElement> flightAirlineNameList;

    @FindBy(id ="toastNotfound")
    private WebElement flightNotFoundText;


    public SearchFlightResultPage(AndroidDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void fromCityCodeDisplayed(String cityNameOnSearchModal){
        Assert.assertTrue(this.fromCityIso.isDisplayed());
        Assert.assertEquals(this.fromCityIso.getText(), cityNameOnSearchModal);
    }

    public void toCityCodeDisplayed(String cityNameOnSearchModal){
        Assert.assertTrue(this.toCityIso.isDisplayed());
        Assert.assertEquals(this.toCityIso.getText(), cityNameOnSearchModal);
    }

    public void oneWayFlightDisplayed(int boxNumber){
        elementDisplayed(this.oneWayFlightList.get(boxNumber), "one way flight");
    }

    public void flightPriceDisplayed(int number){
        elementDisplayed(this.flightPriceList.get(number), "flight price");
    }

    public void flightCityFromDisplayed(int number){
        elementDisplayed(this.flightCityFromList.get(number), "flight city from");
    }

    public void flightCityToDisplayed(int number){
        elementDisplayed(this.flightCityToList.get(number), "flight city to");
    }

    public void flightTimeFromDisplayed(int number){
        elementDisplayed(this.flightTimeFromList.get(number), "flight time from");
    }

    public void flightTimeToDisplayed(int number){
        elementDisplayed(this.flightTimeToList.get(number), "flight time to");
    }

    public void flightNotFoundTextDisplayed(){
        elementDisplayed(this.flightNotFoundText, "flight not found");
    }
    public void screenDisplayed(String fromCityCode, String toCityCode){
        this.oneWayFlightDisplayed(1);
        this.fromCityCodeDisplayed(fromCityCode);
        this.toCityCodeDisplayed(toCityCode);
        this.flightCityFromDisplayed(1);
        this.flightCityToDisplayed(1);
        this.flightTimeFromDisplayed(1);
        this.flightTimeToDisplayed(1);
    }

    public void flightNotFoundScreenDisplayed(String fromCityCode, String toCityCode){
        this.fromCityCodeDisplayed(fromCityCode);
        this.toCityCodeDisplayed(toCityCode);
        this.flightNotFoundTextDisplayed();
    }
}
