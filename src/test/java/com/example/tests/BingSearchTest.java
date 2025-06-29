package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BingSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
    WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void searchForSelenium() {
        driver.get("https://www.bing.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertTrue(title.toLowerCase().contains("selenium webdriver"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
