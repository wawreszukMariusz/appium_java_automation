package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static tests.BaseTest.driver;

public class ExtentReport {

    private static ExtentReports extent;
    private static ExtentTest test;

    private ExtentReport() {}

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("src/test/reports/report.html");

        final File CONF = new File("src/test/resources/spark-config.json");
        try {
            spark.loadJSONConfig(CONF);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent.attachReporter(spark);
    }

    public static void flushReports() {
        extent.flush();
    }

    public static void createTest(String testCaseName) {
        test = extent.createTest(testCaseName);
    }

    public static void pass(String message) {
        test.pass(message);
    }

    public static void fail(String message) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        String filePath = "src/test/reports/screenshots/screenshot_" + timestamp + ".png";

        test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
    }
}
