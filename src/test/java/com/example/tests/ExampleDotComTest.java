package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ExampleDotComTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
       WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @Test
    public void openExampleDotCom() {
        driver.get("http://example.com");
        String title = driver.getTitle();
        System.out.println("Example.com title: " + title);
        Assert.assertEquals(title, "Example Domain");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
