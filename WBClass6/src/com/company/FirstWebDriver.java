package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by ifilipenko on 1/23/2015.
 */
public class FirstWebDriver {


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("java");

        while(driver.findElements(By.name("btnG")).size() == 0);
        WebElement button1 = driver.findElement(By.name("btnG"));
        button1.click();

        while(driver.findElements(By.tagName("a")).size() == 0);
        WebElement link = driver.findElement(By.tagName("a"));

        String linkhref = link.getAttribute("href");
        System.out.println(linkhref);

        if(linkhref.equals("https://www.java.com/en/")) System.out.println("Test passed");
        else System.out.println("Test failed");

        driver.quit();

        }

    }

