package org.example.pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class OrderTest {

    private WebDriver webDriver;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void trueWayOrder() {
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickCookieButtonAccept();
        mainPage.clickOrderInHeader();
        orderPage.inputName("Маша");
        orderPage.inputSurname("Ивановна");
        orderPage.inputAddress("Москва");
        orderPage.inputMetro("Черкизовская");

        orderPage.inputPhone("89999999999");
        orderPage.clickNextBtn();

        orderPage.inputDate("2");
        orderPage.selectPeriod("сутки");
        orderPage.selectColor("черный");
        orderPage.inputComment("нет коменнтариев");

        orderPage.clickOrderBtn();

        orderPage.clickAcceptBtn();

        assertTrue(orderPage.checkSuccessOrder());
    }

    @Test
    public void WayOrderWithInvalidNumber() {
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickCookieButtonAccept();
        mainPage.clickOrderInHeader();
        orderPage.inputName("Саша");
        orderPage.inputSurname("Горянская");
        orderPage.inputAddress("Москва");
        orderPage.inputMetro("Черкизовская");

        orderPage.inputPhone("Invalid");
        orderPage.clickNextBtn();
        assertTrue(orderPage.checkMessageInvalidNumber());
    }

    @After
    public void tearDown(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
