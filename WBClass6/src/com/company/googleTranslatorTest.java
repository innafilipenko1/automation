package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ifilipenko on 1/26/2015.
 */
public class googleTranslatorTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://translate.google.com.ua/");
        String[] input = {"fellow", "hello", "good bye"};
        WebElement source = driver.findElement(By.id("source"));

        for (int i = 0; i < input.length ; i++) {
            source.clear();
            source.sendKeys(input[i]);
            Thread.sleep(1000);
            driver.findElement(By.id("result_box")).getText();
      }



    }

}
