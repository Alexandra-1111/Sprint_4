package org.example.pages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends PageTest{
    private final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;
    public OrderTest(String name, String surname, String address,
                     String metro, String phone, String date, String period,
                     String color, String comment){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] getTexts() {
        return new Object[][]{
                {"Маша", "Иванова", "Москва", "Черкизовская", "89999999999",
                        "2", "сутки", "черный", "нет"},

                {"Александра", "Горянская", "Москва", "Технопарк", "89999999988",
                        "3", "двое суток", "серый", "комментарий"}
        };
    }

    @Test
    public void trueWayOrder() {
        webDriver.get(PAGE_URL);
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickCookieButtonAccept();
        mainPage.clickOrderInHeader();
        orderPage.inputName(name);
        orderPage.inputSurname(surname);
        orderPage.inputAddress(address);
        orderPage.inputMetro(metro);

        orderPage.inputPhone(phone);
        orderPage.clickNextBtn();

        orderPage.inputDate(date);
        orderPage.selectPeriod(period);
        orderPage.selectColor(color);
        orderPage.inputComment(comment);

        orderPage.clickOrderBtn();
        orderPage.clickAcceptBtn();

        assertTrue(orderPage.checkSuccessOrder());
    }
}
