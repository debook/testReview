package com.simbirsoft.utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInstance {
    private static WebDriver driver;

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
