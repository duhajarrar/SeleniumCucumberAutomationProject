package com.core;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
    private static final int WAIT_FOR_RESULTS = 15;

    private static WebDriver webDriver;
    private DriverManager(){
    }

    public static WebDriver getInstance(){
        if (webDriver == null){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static void closeDriver(){
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    public static void WaitForElement(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(WAIT_FOR_RESULTS));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
