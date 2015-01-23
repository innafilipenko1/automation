package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.awt.datatransfer.StringSelection;

/**
 * Created by user on 1/23/15.
 */
public class AutPractice {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver",
                "D:/aut5/tools/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.toolsqa.com/automation-practice-form/");

        WebElement link1 = driver.findElement(By.id("content")).findElements(By.tagName("a")).get(0);

        System.out.println(link1.getText());

        WebElement selectList = driver.findElement(By.id("continents"));
        Select select = new Select(selectList);

        select.selectByVisibleText("Africa");
        System.out.println(select.getFirstSelectedOption().getText());

        WebElement selectList2 = driver.findElement(By.id("selenium_commands"));
        Select select2 = new Select(selectList2);

        select2.selectByIndex(0);
        selectList2.sendKeys(Keys.CONTROL);
        select2.selectByIndex(1);

//        Actions action = new Actions(driver).clickAndHold(select2.getOptions().get(0)).keyDown(Keys.LEFT_SHIFT).click()
//        action.perform();

        for (int i = 0; i < select2.getAllSelectedOptions().size(); i++) {
            System.out.println(select2.getAllSelectedOptions().get(0).getText());
        }

        driver.findElement(By.id("photo")).click();

        StringSelection ss = new StringSelection("");
        //Toolkit.getDefaultToolkit().getSystemClipboard()



    }
}