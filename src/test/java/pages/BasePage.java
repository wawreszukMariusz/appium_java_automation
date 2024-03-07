package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ExtentReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static tests.BaseTest.driver;

public class BasePage {

    private static Point point;

    public void clickElement(WebElement element, String elementName) {
        try {
            element.click();
            ExtentReport.pass("Click on " + elementName + " passed");
        } catch (Exception | AssertionError e) {
            ExtentReport.fail("Click on " + elementName + " failed");
            throw e;
        }
    }

    public void elementDisplayed(WebElement element, String elementName) {
        try {
            Assert.assertTrue(element.isDisplayed());
            ExtentReport.pass("Checking display of " + elementName + " passed");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of " + elementName + " failed");
            throw e;
        }
    }

    public void elementDisplayed(List<WebElement> listElement, int numberOfElements, String listElementName) {
        try {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertEquals(listElement.size(), numberOfElements);
            ExtentReport.pass("Checking display of " + listElementName + " passed");
        } catch (AssertionError e) {
            ExtentReport.fail("Checking display of " + listElementName + " failed: " + e.getMessage());
            throw e;
        }
    }

    public void elementSendKeys(WebElement element, String sendPhrase, String elementName) {
        try {
            element.sendKeys(sendPhrase);
            ExtentReport.pass("Sending keys to " + elementName + " passed");
        } catch (Exception | AssertionError e) {
            ExtentReport.fail("Sending keys to " + elementName + " failed");
            throw e;
        }
    }


    public void selectDateInCalendar(String day, List<WebElement> calendarDayList) {
        for (WebElement element : calendarDayList) {
            if (element.getText().equals(day)) {
                element.click();
            }
        }
    }

    public void selectDateInCalendar(String dayFrom, String dayTo, List<WebElement> calendarDayList) {
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

    public void acceptAlert(String alertName) {
        try {
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            alert.accept();
            ExtentReport.pass("Accepting " + alertName + " alert passed");
        } catch (Exception | AssertionError e) {
            ExtentReport.fail("Accepting " + alertName + " alert failed");
            try {
                throw e;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void checkAlertText(String alertName, String alertText) {
        try {
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            Assert.assertTrue(alert.getText().contains(alertText));
            ExtentReport.pass("Checking if " + alertName + " is having '" + alertText + "' text passed");
        } catch (Exception | AssertionError e) {
            ExtentReport.fail("Checking if " + alertName + " is having '" + alertText + "' text failed");
            try {
                throw e;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void compareElements(WebElement elementToCompare, String stringToCompare, String message) {
        try {
            Assert.assertTrue(elementToCompare.isDisplayed());
            Assert.assertEquals(elementToCompare.getText(), stringToCompare);
            ExtentReport.pass("Checking display of " + message + " passed");
        } catch (Exception e) {
            ExtentReport.fail("Checking display of " + message + " failed");
        }
    }

    public String randomEmail() {
        return "tester" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyHHmmss")) + "@tester.com";
    }

    public MobileElement scrollToElement(String locator) {
        String selector = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + locator + "\").instance(0))";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }

    public MobileElement scrollForward() {
        String selector = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }

    public MobileElement scrollBackward() {
        String selector = "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()";
        return (MobileElement) driver.findElementByAndroidUIAutomator(selector);
    }
}


