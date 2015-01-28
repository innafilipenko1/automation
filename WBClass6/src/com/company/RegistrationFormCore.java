package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 1/28/15.
 */
public class RegistrationFormCore {

    public static void open(WebDriver driver) {
        driver.get("http://demoqa.com/registration/");
    }

    public static void setFirstName(WebDriver driver, String i){
        WebElement firstName = driver.findElement(By.xpath("\"//div[@class='fields pageFields_1 ']|//input[@id='name_3_firstname']\""));
        firstName.sendKeys(i);

    }

}
