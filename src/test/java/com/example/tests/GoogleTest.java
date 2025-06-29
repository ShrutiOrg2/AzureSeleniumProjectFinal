package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
    } else {
        // On GitHub Actions, assuming chromedriver is in PATH after setup-chrome
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    }
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertTrue(title.contains("Google"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
