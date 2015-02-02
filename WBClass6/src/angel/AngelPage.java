package angel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by user on 1/30/15.
 */
public class AngelPage {

    private static WebDriver driver;
    private static String xPathMasterPassword = "//input[@name='master']";
    private static String xPathSiteName = "//input[@name='site']";
    private static String xPathGenerate = "//input[@type='submit']";
    private static String xPathGeneratePassword = "//input[@name='password']";



    public static void open(WebDriver drv) {
        driver = drv;
        driver.get("http://angel.net/~nic/passwd.current.html");
    }

    public static void setMasterPassword(WebDriver driver, String pw) {
        WebElement masterPassword = driver.findElement(By.xpath(xPathMasterPassword));
        masterPassword.sendKeys(pw);
    }

    public static void clearMasterPassword(WebDriver driver) throws AWTException{
        WebElement masterPassword = driver.findElement(By.xpath(xPathMasterPassword));
/*
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_DELETE);*/
    }

    public static void setSiteName(WebDriver driver, String name) {
        WebElement siteName = driver.findElement(By.xpath(xPathSiteName));
        siteName.sendKeys(name);
    }

    public static String getSiteName(WebDriver driver) {
        WebElement siteName = driver.findElement(By.xpath(xPathSiteName));
        return siteName.getAttribute("value");
    }

    public static String getMasterPassword(WebDriver driver) {
        WebElement masterPassword = driver.findElement(By.xpath(xPathMasterPassword));
        return masterPassword.getAttribute("value");
    }

    public static void clickGenerate(WebDriver driver) {
        WebElement generate = driver.findElement(By.xpath(xPathGenerate));
        generate.click();
    }

    public static String getGeneratedPassword(WebDriver driver) {
        WebElement generatePassword = driver.findElement(By.xpath(xPathGeneratePassword));
        return generatePassword.getAttribute("value");
    }


}
