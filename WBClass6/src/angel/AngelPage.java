package angel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public static void setSiteName(WebDriver driver, String name) {
        WebElement siteName = driver.findElement(By.xpath(xPathSiteName));
        siteName.sendKeys(name);
    }

    public static void clickGenerate(WebDriver driver) {
        WebElement generate = driver.findElement(By.xpath(xPathGenerate));
        generate.click();
    }

    public static String getMasterPassword(WebDriver driver) {
        WebElement generatePassword = driver.findElement(By.xpath(xPathGeneratePassword));
        return generatePassword.getAttribute("value");
    }


}
