package angel;

import com.company.RegistrationFormCore;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * Created by user on 1/30/15.
 */

@RunWith(JUnit4.class)
public class Tests {

    WebDriver driver;
    String error;

    @Before
    public void Init(){
        System.setProperty("webdriver.chrome.driver",
                "D:/aut5/tools/chromedriver.exe");
        driver = new ChromeDriver();
        AngelPage.open(driver);
        error = "";
    }

    @Test
    public void emptyMaster_PasswordGenerates(){
        AngelPage.setMasterPassword(driver, "asd");
        AngelPage.setSiteName(driver, "angel.net");
        AngelPage.clickGenerate(driver);
        error = "Generated password is not empty!";
        Assert.assertNotEquals("", AngelPage.getMasterPassword(driver));
        error = "";
      }

    @After
    public void CleanUp(){
        if (!error.equals("")){
            System.out.println(error);
        }
        driver.quit();
    }
}
