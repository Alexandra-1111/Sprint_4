package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTest {
    protected WebDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @After
    public void tearDown(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
