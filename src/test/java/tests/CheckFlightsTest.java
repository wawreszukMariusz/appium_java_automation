package tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FlightsModalPage;
import pages.HomePage;
import pages.SearchFlightResultPage;
import utils.ExtentReport;

public class CheckFlightsTest extends BaseTest {

    HomePage homePage;
    FlightsModalPage flightsModalPage;

    @BeforeMethod
    public void beforeTest(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

        homePage = new HomePage(driver);
        homePage.screenDisplayed();
        homePage.clickProduct(0);

        flightsModalPage = new FlightsModalPage(driver);
        flightsModalPage.modalDisplayed();
    }

    @Test
    public void findFlightForOnePersonTest() {
        flightsModalPage.clickOriginDropdown();
        flightsModalPage.clickFlightOption(0);

        String fromCountryIso = flightsModalPage.getFromCountryCode();

        flightsModalPage.clickDestinationDropdown();
        flightsModalPage.clickFlightOption(0);

        String toCountryIso = flightsModalPage.getToCountryCode();

        flightsModalPage.clickDepartureDateDropdown();
        flightsModalPage.selectDate("26");
        flightsModalPage.clickCalendarOkButton();
        flightsModalPage.clickSearchFlightButton();

        SearchFlightResultPage searchFlightResultPage = new SearchFlightResultPage(driver);
        searchFlightResultPage.screenDisplayed(fromCountryIso, toCountryIso);
    }

    @Test
    public void findFlightsForCouple() {
        flightsModalPage.clickOriginDropdown();
        flightsModalPage.clickFlightOption(0);

        String fromCountryIso = flightsModalPage.getFromCountryCode();

        flightsModalPage.clickDestinationDropdown();
        flightsModalPage.clickFlightOption(0);

        String toCountryIso = flightsModalPage.getToCountryCode();

        flightsModalPage.clickDepartureDateDropdown();
        flightsModalPage.selectDate("26");
        flightsModalPage.clickCalendarOkButton();
        flightsModalPage.clickSetTravellersDropDown();
        flightsModalPage.setNumberOfAdult(2);
        flightsModalPage.clickSaveTravellersButton();
        flightsModalPage.clickSearchFlightButton();

        SearchFlightResultPage searchFlightResultPage = new SearchFlightResultPage(driver);
        searchFlightResultPage.screenDisplayed(fromCountryIso, toCountryIso);
    }

    @Test
    public void findFlightsForOneChildFamily() {
        flightsModalPage.clickOriginDropdown();
        flightsModalPage.clickFlightOption(0);

        String fromCountryIso = flightsModalPage.getFromCountryCode();

        flightsModalPage.clickDestinationDropdown();
        flightsModalPage.clickFlightOption(0);

        String toCountryIso = flightsModalPage.getToCountryCode();

        flightsModalPage.clickDepartureDateDropdown();
        flightsModalPage.selectDate("26");
        flightsModalPage.clickCalendarOkButton();
        flightsModalPage.clickSetTravellersDropDown();
        flightsModalPage.setNumberOfAdult(2);
        flightsModalPage.clickSaveTravellersButton();
        flightsModalPage.clickSearchFlightButton();

        SearchFlightResultPage searchFlightResultPage = new SearchFlightResultPage(driver);
        searchFlightResultPage.screenDisplayed(fromCountryIso, toCountryIso);
    }

    @Test
    public void findFlightsForTwoChildFamily() {
        flightsModalPage.clickOriginDropdown();
        flightsModalPage.clickFlightOption(0);

        String fromCountryIso = flightsModalPage.getFromCountryCode();

        flightsModalPage.clickDestinationDropdown();
        flightsModalPage.clickFlightOption(0);

        String toCountryIso = flightsModalPage.getToCountryCode();

        flightsModalPage.clickDepartureDateDropdown();
        flightsModalPage.selectDate("26");
        flightsModalPage.clickCalendarOkButton();
        flightsModalPage.clickSetTravellersDropDown();
        flightsModalPage.setNumberOfAdult(2);
        flightsModalPage.setNumberOfChild(2);
        flightsModalPage.clickSaveTravellersButton();
        flightsModalPage.clickSearchFlightButton();

        SearchFlightResultPage searchFlightResultPage = new SearchFlightResultPage(driver);
        searchFlightResultPage.screenDisplayed(fromCountryIso, toCountryIso);
    }

    @Test
    public void flightsNotFoundTest() {
        flightsModalPage.clickOriginDropdown();
        flightsModalPage.clickFlightOption(0);

        String fromCountryIso = flightsModalPage.getFromCountryCode();

        flightsModalPage.clickDestinationDropdown();
        flightsModalPage.clickFlightOption(0);

        String toCountryIso = flightsModalPage.getToCountryCode();

        flightsModalPage.clickDepartureDateDropdown();
        flightsModalPage.selectDate("3");
        flightsModalPage.clickCalendarOkButton();
        flightsModalPage.clickSetTravellersDropDown();
        flightsModalPage.clickSaveTravellersButton();
        flightsModalPage.clickSearchFlightButton();

        SearchFlightResultPage searchFlightResultPage = new SearchFlightResultPage(driver);
        searchFlightResultPage.flightNotFoundScreenDisplayed(fromCountryIso, toCountryIso);
    }
}
