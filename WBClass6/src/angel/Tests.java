package angel;

import com.company.RegistrationFormCore;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;

/**
 * Created by user on 1/30/15.
 */

/*
1. При пустом мастер пароле и заполненном сайте пароль генерится.
2. При мастер пароле: asdasd и сайте: angel.net сгенеренный пароль: B9ya7yayeK/Zn@1a
3. При мастер пароле: не asdasd и сайте: angel.net сгенеренный пароль: НЕ B9ya7yayeK/Zn@1a
4. При заполнении мастер пароля и сайта всевозможными символами, они все оказываются введенными в поля.
5. При заполнении мастер пароля 32 символами, и сайт 128 символами, они все оказываются введенными в поля.
        */

@RunWith(JUnit4.class)
public class Tests {

    WebDriver driver;
    String error;

    @Before
    public void Init() {
/*        System.setProperty("webdriver.chrome.driver",
                "D:/aut5/tools/chromedriver.exe");*/
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/ifilipenko/Dropbox/_IdeaProjects/drivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        AngelPage.open(driver);
        error = "";
    }

    @Test //При заполнении мастер пароля 32 символами, и сайт 128 символами, они все оказываются введенными в поля.
    public void checkPWAndSiteNameMaxLenght() {
        int pwMaxLenght = 32;
        int siteNameMaxLenght = 128;
        String n = "1";
        int count = 0;

        for (int i = 0; i < pwMaxLenght; i++) {
            AngelPage.setMasterPassword(driver, n);
            count++;
        }
       //System.out.println(AngelPage.getMasterPassword(driver));

        for (int i = 0; i < siteNameMaxLenght; i++) {
            AngelPage.setSiteName(driver, n);
        }
        //System.out.println(AngelPage.getSiteName(driver));



    }

    @Ignore
    @Test //4. При заполнении мастер пароля и сайта всевозможными символами, они все оказываются введенными в поля.
    public void checkPWAndSiteLenght() {
        String random = "1234567890!@#$%^&*()qwertyuiopйцукенгшщ";
        AngelPage.setMasterPassword(driver, random);
        AngelPage.setMasterPassword(driver, random);
        Assert.assertEquals(random, AngelPage.getMasterPassword(driver));
        Assert.assertEquals(random, AngelPage.getSiteName(driver));
    }


    @Ignore
    @Test //1. При пустом мастер пароле и заполненном сайте  - пароль генерится.
    public void emptyMaster_PasswordGenerates() {
        AngelPage.setMasterPassword(driver, "");
        AngelPage.setSiteName(driver, "angel.net");
        AngelPage.clickGenerate(driver);
        error = "Generated password is not empty!";
        Assert.assertNotEquals("", AngelPage.getGeneratedPassword(driver));
        error = "";
    }

    @Ignore
    @Test //При мастер пароле: asdasd и сайте: angel.net сгенеренный пароль: B9ya7yayeK/Zn@1a
    /*
    * Как очистить поля после ввода?
    * */
    public void sameGenPassword_samePWAndSite() throws AWTException {
        AngelPage.setMasterPassword(driver, "asdasd");
        AngelPage.setSiteName(driver, "angel.net");
        AngelPage.clickGenerate(driver);
        String lastPW = AngelPage.getGeneratedPassword(driver);
        AngelPage.clearMasterPassword(driver);
/*        AngelPage.setMasterPassword(driver, "asdasd");
        AngelPage.setSiteName(driver, "angel.net");
        AngelPage.clickGenerate(driver);
        Assert.assertEquals(lastPW,AngelPage.getGeneratedPassword(driver));*/
    }


    @After
    public void CleanUp() {
        if (!error.equals("")) {
            System.out.println(error);
        }
        //driver.quit();
    }
}
