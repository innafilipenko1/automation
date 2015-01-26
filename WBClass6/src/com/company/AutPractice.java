package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * Created by user on 1/23/15.
 */
public class AutPractice {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");


//        System.setProperty("webdriver.chrome.driver",
//                "D:/aut5/tools/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-us");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://www.toolsqa.com/automation-practice-form/");

//      find link "Partial Link Text"
        WebElement link1 = driver.findElement(By.id("content")).findElements(By.tagName("a")).get(0);
        System.out.println(link1.getText());

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Inna");

        WebElement sex = driver.findElement(By.id("sex-1"));
        if(!sex.isSelected())
        {
            sex.click();
        }


//      find "Continents" list and select "Africa" value
        WebElement selectList = driver.findElement(By.id("continents"));
        Select select = new Select(selectList);
        select.selectByVisibleText("Africa");
        System.out.println(select.getFirstSelectedOption().getText());

//      find "Selenium Commands" list and
        WebElement selectList2 = driver.findElement(By.id("selenium_commands"));
        Select select2 = new Select(selectList2);
//      select wanted 0 and 1 values using CTRL key
/*      select2.selectByIndex(0);
        selectList2.sendKeys(Keys.CONTROL);
        select2.selectByIndex(1);*/
//      select all values in "Selenium Commands" multiselect list
        Actions action = new Actions(driver).click(select2.getOptions().get(0)).keyDown(Keys.LEFT_SHIFT).click(select2.getOptions().get(4));
        action.perform();
//        sout all selected values
        for (int i = 0; i < select2.getAllSelectedOptions().size(); i++) {
            System.out.println(select2.getAllSelectedOptions().get(i).getText());
        }

//      attaching a file
        WebElement uploadPhoto = driver.findElement(By.id("photo"));
        uploadPhoto.click();;
        uploadPhoto.sendKeys("C:/Users/ifilipenko/Dropbox/Books/LoginError.png");

       // StringSelection ss = new StringSelection("C:/Users/ifilipenko/Dropbox/Books/LoginError.png");
        StringSelection ss = new StringSelection("LoginError.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//        imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }
}