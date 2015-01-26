package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

/**
 * Created by ifilipenko on 1/26/2015.
 */
public class RegistrationForm {

/*    1. Проверяем значения по умолчанию во всех контролах (полях, чек боксах, дропдаунах)
      2. Проверяем текст всех заголовков
      3. Заполняем всю форму верными значениями*/

    public static void main(String[] args) {
/*        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");*/
        System.setProperty("webdriver.chrome.driver",
                "D:/aut5/tools/chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.get("http://demoqa.com/registration/");

        WebElement firstName = driver.findElement(By.id("name_3_firstname"));
        System.out.println("Test passed. Element found.");

        //need to try find the label by selecting 1st div within fieldset and then get label out of there
/*                WebElement firstNameLabel = driver.findElement(By.id("pie_register")).findElements(By.tagName("label")).get(0);
                System.out.println(firstNameLabel.getText());*/

        WebElement firstNameLabel = driver.findElement(By.xpath("//div[@class='fieldset']/input[@id='name_3_firstname']/../label"));
        WebElement firstNameLabelPath2 = driver.findElement(By.xpath("//div[input[@id='name_3_firstname']]/label"));
        System.out.println(firstNameLabel.getText());
        ////label[text()='First Name']/../input to find input

       // WebElement countryList = driver.findElement(By.id("dropdown_7"));
        WebElement countryList = driver.findElement(By.xpath("//div[@class='time_fields']/select"));
        Select selectCountry = new Select(countryList);
        String countryListDefault = selectCountry.getFirstSelectedOption().getText();
        System.out.println(countryListDefault);
        if (countryListDefault.equals("Afghanistan")) System.out.println("Test passed");
        else System.out.println("Test failed");

        String forName = "qazxswedcbvfrtgbnhyujmkiololpQAZXSWEDCVFRTGBNHYUJMKIOLP_";
        Random random = new Random();
        String userName = "";
        for (int i = 0; i < 10 ; i++) {
            int n = random.nextInt(forName.length());
            userName = userName + forName.charAt(n);
        }
        System.out.println(userName);

    }


}
