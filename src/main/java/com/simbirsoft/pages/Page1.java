package com.simbirsoft.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page1 {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @FindBy(xpath = "//select[@id='userSelect']")
    public WebElement button1;

    @FindBy(css = ".xxClass")
    public WebElement element1;

    @FindBy(id = "username")
    public WebElement element2;

    public Page1(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofMillis(10_000));
    }

    @Step("Выбор пользователя {username}")
    public Page1 selectCustomerUser(String username) {
        button1.click();
        String selectLocator = "//select";
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectLocator)))
                .sendKeys(username);
        driver.findElement(By.cssSelector(".btn-default")).click();
        Assertions.assertEquals("Ожидаемый текст элемента", element2.getText());
        return this;
    }
}
