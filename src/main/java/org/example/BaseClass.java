package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentManagerReport;


import static org.slf4j.helpers.Reporter.info;

public class BaseClass {

        protected WebDriver driver;
        protected static ExtentReports extent;
        protected ExtentTest test;


        @BeforeSuite
        public void setupReport() {
            extent = ExtentManagerReport.getReportInstance();
        }

        @AfterSuite
        public void teardownReport() {
            extent.flush();
            //String reportPath = ExtentReportManager.reportPath;
            //EmailUtils.sendTestReport(reportPath);
        }

        @BeforeMethod
        public void setUp() {

            info("Starting WebDriver...");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            info("Navigating to URL...");
            driver.get("https://admin-demo.nopcommerce.com/login");

        }

        @AfterMethod
        public void tearDown(ITestResult result) {

            if(result.getStatus() == ITestResult.FAILURE) {

                String screenshotPath = ExtentManagerReport.captureScreenshot(driver, "LoginFailure");
                test.fail("Test Failed.. Check Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }


            if (driver != null) {
                info("Closing Browser...");
                driver.quit();
            }
        }

    }


