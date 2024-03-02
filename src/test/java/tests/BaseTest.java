package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.ExtentReport;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.android.nativekey.AndroidKey.N;

public class BaseTest {

    protected static AndroidDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        ExtentReport.initReports();
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2" );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android" );
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "test_device" );
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.phptravelsnative");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.phptravelsnative.Activities.SplashActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReports();
    }


}