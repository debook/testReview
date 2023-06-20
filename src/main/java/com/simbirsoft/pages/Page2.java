package com.simbirsoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Page2 {
    private WebDriver driver;
    private WebDriverWait driverWait;

    private By input1 = By.cssSelector("input");
    private By button1 = By.cssSelector(".xxClass");
    private By resultField = By.cssSelector(".resultField");

    public Page2(WebDriver driver) {
        this.driver = driver;
        driverWait = new WebDriverWait(driver, Duration.ofMillis(10_000));
    }

    @Step("Ввод значения {number} в поле input1")
    public Page2 inputNumberToField(Integer number) {
        driverWait.until(presenceOfElementLocated(input1))
                .sendKeys(number.toString());
        return this;
    }

    @Step("Нажатие на кнопку button1")
    public Page2 clickButton1() {
        driver.findElement(button1).click();
        return this;
    }

    public boolean checkResult(String expectedResult) {
        return driverWait.until(presenceOfElementLocated(resultField)).getText().equals(expectedResult);
    }
}
