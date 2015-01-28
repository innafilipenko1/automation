package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ifilipenko on 1/28/2015.
 */
public class LoginFormxPathPractice {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
      /*  WebDriver driver = new FirefoxDriver();*/
        driver.get("http://demoqa.com/registration/");
        driver.manage().window().maximize();

        /**
         * Test1 - CheckAllRequiredFields
         */
        WebElement buttonSubmit = driver.findElement(By.xpath("//div[@class='fieldset piereg_submit_button']/input"));
        Thread.sleep(2000);
        buttonSubmit.click();

        //positive - First Name and Last Name fields should be required if they are empty and reqLabel should be visible if Submit button is clicked.
        WebElement reqLabel1 = driver.findElement(By.xpath("//ul[@id='pie_register']/li[1]/div/div[@class='legend_txt']/span"));
        //WebElement reqLabel1 = driver.findElement(By.xpath("//div[@class='fieldset error']//span[@class='legend error']"));
        System.out.println(reqLabel1.getText());

        //negative -
        WebElement firstName = driver.findElement(By.xpath("//div[@class='fields pageFields_1 ']|//input[@id='name_3_firstname']"));
        firstName.sendKeys("hi inna");
        firstName.sendKeys(Keys.TAB);
        WebElement lastName = driver.findElement(By.xpath("//div[@class='fields pageFields_1 ']|//input[@id='name_3_lastname']"));
        lastName.sendKeys(Keys.TAB);
        try {
            WebElement reqLabel11 = driver.findElement(By.xpath("//ul[@id='pie_register']/li[1]/div/div[@class='legend_txt']/span"));
        } catch (NoSuchElementException e) {
            System.out.println("Test passed");
        }
        //


    }


}
