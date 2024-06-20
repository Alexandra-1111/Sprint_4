package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver webDriver;


    //ввод имя
    private By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    //Ввод фамилия
    private By surnameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    //ввод Адрес
    private By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private By metroInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    //телефон
    private By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private By nextBtnLocator = By.xpath("//button[contains(text(), 'Далее')]");

    //Когда привезти самокат
    private By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Срок аренды
    private By periodSelectLocator = By.xpath("//div[contains(text(), '* Срок аренды')]");
    //Цвет самоката черный
    private By blackColorLocator = By.id("black");
    //Цвет самоката серый
    private By greyColorLocator = By.id("grey");
    //Комментарий для курьера
    private By commentForCurierLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private By orderBtnLocator = By.xpath("//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']");
    //Кнопка соглашения с заказом
    private By acceptBtnLocator = By.xpath("//button[contains(text(), 'Да')]");
    //Всплывающее окно о успешном заказе
    private By successOrder = By.xpath("//div[contains(text(),'Заказ оформлен')]");
    //Некорректный номер
    private By invalidNumberLocator = By.xpath("//div[contains(text(), 'Введите корректный номер')]");


    public OrderPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void inputName(String name){
        webDriver.findElement(nameInputLocator).sendKeys(name);
    }

    public void inputSurname(String surname){
        webDriver.findElement(surnameInputLocator).sendKeys(surname);
    }

    public void inputAddress(String address){
        webDriver.findElement(addressInputLocator).sendKeys(address);
    }

    public void inputMetro(String metro){
        webDriver.findElement(metroInputLocator).click();
        webDriver.findElement(By.xpath("//div[contains(text(), '"+metro+"')]")).click();
    }

    public void inputPhone(String phone){
        webDriver.findElement(phoneInputLocator).sendKeys(phone);
    }

    public void clickNextBtn(){
        webDriver.findElement(nextBtnLocator).click();
    }

    public void inputDate(String date){
        webDriver.findElement(dateInputLocator).sendKeys(date);
        webDriver.findElement(dateInputLocator).sendKeys(Keys.ENTER);
    }

    public void selectPeriod(String period){
        webDriver.findElement(periodSelectLocator).click();
        webDriver.findElement(By.xpath("//div[contains(text(), '" +period+"')]")).click();
    }

    public void selectColor(String color){
        if (color.equals("черный")){
            webDriver.findElement(blackColorLocator).click();
        }
        if (color.equals("серый")){
            webDriver.findElement(greyColorLocator).click();
        }
    }

    public void inputComment(String comment){
        webDriver.findElement(commentForCurierLocator).sendKeys(comment);
    }

    public void clickOrderBtn() {
        webDriver.findElement(orderBtnLocator).click();

    }

    public void clickAcceptBtn() {
        webDriver.findElement(acceptBtnLocator).click();
    }

    public boolean checkSuccessOrder(){
        return webDriver.findElement(successOrder).isDisplayed();
    }
    public boolean checkMessageInvalidNumber(){
        return webDriver.findElement(invalidNumberLocator).isDisplayed();
    }

}
