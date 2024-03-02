package tests;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ExtentReport;

public class TestTest extends BaseTest {

    @BeforeMethod
    public void beforeTest(ITestResult result){
        ExtentReport.createTest(result.getMethod().getMethodName());
    }

    @Test
    public void test(){
        HomePage homePage = new HomePage(driver);
        homePage.homeTextTitleDisplayed();
    }
}
