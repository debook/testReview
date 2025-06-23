package com.simbirsoft.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInstance {

    private static WebDriver driver;

    public static void createLocalDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void createRemoteDriver(String url, Capabilities options) {
        try {
            driver = new RemoteWebDriver(new URL(url), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}