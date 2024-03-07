package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsModalPage extends BasePage {

    @FindBy(id = "tvOrigin")
    private WebElement originDropdown;

    @FindBy(id = "tvDestination")
    private WebElement destinationDropdown;

    @FindBy(id = "departDateHint")
    private WebElement departureDateDropdown;

    @FindBy(id = "departDateHint")
    private WebElement returnDateDropdown;

    @FindBy(id = "fSeatClass")
    private WebElement selectClassDropdown;

    @FindBy(id = "travellersFlight")
    private WebElement setTravellersDropdown;

    @FindBy(id = "search_flight")
    private WebElement searchFlightButton;

    @FindBy(id = "flightTitle")
    private WebElement flightsModalTitle;

    @FindBy(id = "onewaytripe")
    private WebElement oneWayFlightOptionButton;

    @FindBy(id = "roundtripe")
    private WebElement roundTripFlightOptionButton;

    @FindBy(id = "top")
    private List<WebElement> flightOptionList;

    @FindBy(xpath = "//android.widget.TextView[@content-desc]")
    private List<WebElement> calendarDaysList;

    @FindBy(id = "confirm_button")
    private WebElement calendarOkButton;

    @FindBy(id = "tvOrigin")
    private WebElement fromCountryCode;

    @FindBy(id = "tvDestination")
    private WebElement toCountryCode;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.phptravelsnative:id/adutTxt']/../android.widget.NumberPicker/android.widget.Button")
    private List<WebElement> adultNumberChooserList;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.phptravelsnative:id/childsTxt']/../android.widget.NumberPicker/android.widget.Button")
    private List<WebElement> childNumberChooserList;

    @FindBy(id = "btnSaveTravller")
    private WebElement saveTravellersButton;

    public FlightsModalPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOriginDropdown() {
        clickElement(this.originDropdown, "origin dropdown");
    }

    public void clickDestinationDropdown() {
        clickElement(this.destinationDropdown, "destination dropdown");
    }

    public void clickDepartureDateDropdown() {
        clickElement(this.departureDateDropdown, "departure date dropdown");
    }

    public void clickFlightOption(int option) {
        clickElement(this.flightOptionList.get(option), "flight option");
    }

    public void clickCalendarOkButton() {
        clickElement(this.calendarOkButton, "calendar ok button");
    }

    public void clickSearchFlightButton() {
        clickElement(this.searchFlightButton, "search flight button");
    }

    public void clickSetTravellersDropDown() {
        clickElement(this.setTravellersDropdown, "set travellers dropdown");
    }

    public void clickReturnDateDropdown() {
        clickElement(this.returnDateDropdown, "click return date dropdown");
    }

    public void clickSaveTravellersButton() {
        clickElement(this.saveTravellersButton, "save travellers button");
    }

    public void clickRoundTripFlightOptionButton() {
        clickElement(this.roundTripFlightOptionButton, "round trip flight option button");
    }

    public void flightModalTitleDisplayed() {
        elementDisplayed(this.flightsModalTitle, "flight modal title");
    }

    public void oneWayFlightOptionButtonDisplayed() {
        elementDisplayed(this.oneWayFlightOptionButton, "one way flight option button");
    }

    public void roundTripFlightOptionButtonDisplayed() {
        elementDisplayed(this.roundTripFlightOptionButton, "round trip flight option button");
    }

    public void originDropdownDisplayed() {
        elementDisplayed(this.originDropdown, "origin dropdown");
    }

    public void destinationDropdownDisplayed() {
        elementDisplayed(this.destinationDropdown, "destination dropdown");
    }

    public void departureDateDropdownDisplayed() {
        elementDisplayed(this.departureDateDropdown, "departure date dropdown");
    }

    public void selectClassDropdownDisplayed() {
        elementDisplayed(this.selectClassDropdown, "select class dropdown");
    }

    public void setTravellersDropdownDisplayed() {
        elementDisplayed(this.setTravellersDropdown, "set travellers dropdown");
    }

    public void searchFlightButtonDisplayed() {
        elementDisplayed(this.searchFlightButton, "search flight button");
    }

    public void selectDate(String day) {
        for (WebElement element : this.calendarDaysList) {
            if (element.getText().equals(day)) {
                element.click();
            }
        }
    }

    public void selectDate(String dayFrom, String dayTo) {
        for (WebElement element : this.calendarDaysList) {
            if (element.getText().equals(dayFrom)) {
                element.click();
                break;
            }
        }
        for (WebElement element : this.calendarDaysList) {
            if (element.getText().equals(dayTo)) {
                element.click();
                break;
            }
        }
    }

    public void setNumberOfAdult(int numberOfAdult) {
        for (int i = 2; i <= numberOfAdult; i++) {
            for (WebElement element : adultNumberChooserList) {
                if (element.getText().equals(String.valueOf(i))) {
                    clickElement(element, numberOfAdult + "adults option");
                }
            }
        }
    }

    public void setNumberOfChild(int numberOfChild) {
        for (int i = 1; i <= numberOfChild; i++) {
            for (WebElement element : childNumberChooserList) {
                if (element.getText().equals(String.valueOf(i))) {
                    clickElement(element, numberOfChild + "child option");
                }
            }
        }
    }

    public String getFromCountryCode() {
        return this.fromCountryCode.getText();
    }

    public String getToCountryCode() {
        return this.toCountryCode.getText();
    }

    public void modalDisplayed() {
        this.searchFlightButtonDisplayed();
        this.setTravellersDropdownDisplayed();
        this.selectClassDropdownDisplayed();
        this.departureDateDropdownDisplayed();
        this.destinationDropdownDisplayed();
        this.originDropdownDisplayed();
        this.roundTripFlightOptionButtonDisplayed();
        this.oneWayFlightOptionButtonDisplayed();
        this.flightModalTitleDisplayed();
    }
}
