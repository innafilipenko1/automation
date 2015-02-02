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
        masterPassword.clear();
        masterPassword.sendKeys(pw);
    }

    public static void setSiteName(WebDriver driver, String name) {
        WebElement siteName = driver.findElement(By.xpath(xPathSiteName));
        siteName.clear();
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
