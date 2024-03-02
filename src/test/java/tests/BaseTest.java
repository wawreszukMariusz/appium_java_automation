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
import utils.PropertiesLoader;

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
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, PropertiesLoader.loadProperty("automation.name") );
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertiesLoader.loadProperty("platform.name") );
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesLoader.loadProperty("device.name") );
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, PropertiesLoader.loadProperty("auto.grant.permissions"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, PropertiesLoader.loadProperty("app.package"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, PropertiesLoader.loadProperty("app.activity"));

        driver = new AndroidDriver(new URL(PropertiesLoader.loadProperty("appium.url")), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReports();
    }


}