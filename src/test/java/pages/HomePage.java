package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ExtentReport;

public class HomePage {

    @FindBy(id = "titletexthome")
    private WebElement homeTextTitle;

    public void homeTextTitleDisplayed(){
            try {
                Assert.assertTrue(this.homeTextTitle.isDisplayed());
                ExtentReport.pass("Checking display of sent email alert done");
            } catch (Exception e) {
                ExtentReport.fail("Checking display of sent email alert failed");
            }
    }

    public HomePage(AndroidDriver driver){
        PageFactory.initElements(driver, this);
    }

}
