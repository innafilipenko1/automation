package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ifilipenko on 1/26/2015.
 */
public class RegistrationForm {

/*    1. Проверяем значения по умолчанию во всех контролах (полях, чек боксах, дропдаунах)
      2. Проверяем текст всех заголовков
      3. Заполняем всю форму верными значениями*/

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/registration/");

        WebElement firstName = driver.findElement(By.id("name_3_firstname"));
            if(!firstName.getSize().equals(0)) {
                System.out.println("Test passed. Element found.");
//                WebElement firstNameLabel = driver.findElement(By.xpath("//div[@class='fieldset']/input[@id='name_3_firstname']//label"));
//                firstNameLabel.getText();

            }

/*
        WebElement countryList = driver.findElement(By.id("dropdown_7"));
        Select selectCountry = new Select(countryList);
        String countryListDefault = selectCountry.getFirstSelectedOption().getText();
        System.out.println(countryListDefault);
        if (countryListDefault.equals("Afghanistan")) System.out.println("Test passed");
        else  System.out.println("Test failed");;
*/






    }


}
