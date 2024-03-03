package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ExtentReport;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.sql.DriverManager.getDriver;
import static tests.BaseTest.driver;

public class BasePage {

    private static Point point;

    public void clickElement(WebElement element, String elementName){
        try {
            element.click();
            ExtentReport.pass("Click on " + elementName + " passed");
        } catch (Exception e) {
            ExtentReport.fail("Click on " + elementName + " failed");
        }
    }

    public void elementDisplayed(WebElement element, String elementName){
        try {
            Assert.assertTrue(element.isDisplayed());
            ExtentReport.pass("Checking display of " + elementName + " passed");
        } catch (Exception e) {
            ExtentReport.fail("Checking display of " + elementName + " failed");
        }
    }

    public void elementDisplayed(List<WebElement> listElement, int numberOfElements, String listElementName ){
        try {
            Assert.assertEquals(listElement.size(), numberOfElements);
            ExtentReport.pass("Checking display of " + listElementName + " passed");
        } catch (Exception e) {
            ExtentReport.fail("Checking display of " + listElementName + " failed");
        }
    }

    public void selectDateInCalendar(String day, List<WebElement> calendarDayList){
        for (WebElement element : calendarDayList) {
            if (element.getText().equals(day)) {
                element.click();
            }
        }
    }

    public void selectDateInCalendar(String dayFrom, String dayTo,  List<WebElement> calendarDayList){
        for (WebElement element : calendarDayList) {
            if (element.getText().equals(dayFrom)) {
                element.click();
                break;
            }
        }
        for (WebElement element : calendarDayList) {
            if (element.getText().equals(dayTo)) {
                element.click();
                break;
            }
        }
    }

    public void compareElements(WebElement elementToCompare, String stringToCompare, String message){
        try {
            Assert.assertTrue(elementToCompare.isDisplayed());
            Assert.assertEquals(elementToCompare.getText(), stringToCompare);
            ExtentReport.pass("Checking display of " + message + " passed");
        } catch (Exception e) {
            ExtentReport.fail("Checking display of " + message + " failed");
        }
    }

    public MobileElement scrollToElement(String locator){
        String selector = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+locator+"\").instance(0))";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }

    public MobileElement scrollForward(){
        String selector = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }

    public MobileElement scrollBackward(){
        String selector = "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }
}


