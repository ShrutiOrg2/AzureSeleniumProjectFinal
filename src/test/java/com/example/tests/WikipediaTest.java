package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WikipediaTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openWikipediaMainPage() {
        driver.get("https://www.wikipedia.org");
        String heading = driver.findElement(By.className("central-textlogo__image")).getAttribute("alt");
        System.out.println("Wikipedia heading image alt text: " + heading);
        Assert.assertEquals(heading, "Wikipediaa");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
