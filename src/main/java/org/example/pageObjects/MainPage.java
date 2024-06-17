package org.example.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    //Кнопка принять куки
    private final By cookieButton = new By.ByClassName("App_CookieButton__3cvqF");
    //Кнопка заказать в header
    private final By headerOrderBtnLocator = new By.ByClassName("Button_Button__ra12g");
    //Кнопка заказать в центре
    private final By middleOrderBtnLocator = new By.ByClassName("Button_Button__ra12g Button_Middle__1CSJM");

    private WebDriver webDriver;
    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickOrderInHeader(){
        webDriver.findElement(headerOrderBtnLocator).click();
    }
    public void clickOrderInMiddle(){
        webDriver.findElement(middleOrderBtnLocator).click();
    }

    public String clickAccordingButtonByText(String buttonText){
        //Локатор на элемент в списке с кнопкой
        By buttonLocator = By.xpath(
                "//div[@data-accordion-component='AccordionItemButton' and contains(text(), '"
                              +buttonText+"')]");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement buttonElement = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].scrollIntoView(true);", buttonElement);
        buttonElement.click();

        //Локатор на выпадающий элемент из списка
        By textLocator = By.xpath(
                "//div[@data-accordion-component='AccordionItemButton' and contains(text(), '"
                              +buttonText+"')]/ancestor::div[@data-accordion-component='AccordionItem']//div[@data-accordion-component='AccordionItemPanel']//p");
        WebElement textElement = wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
        return textElement.getText();
    }

    public void clickCookieButtonAccept(){
        webDriver.findElement(cookieButton).click();
    }
}
