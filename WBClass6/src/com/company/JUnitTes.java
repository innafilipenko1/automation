package com.company;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 1/28/15.
 */


@RunWith(JUnit4.class)
public class JUnitTes {

    private WebDriver driver;
    private boolean testPassed;

    @Rule
    public TestName name = new TestName();


    @Before
    public void Init(){
        System.setProperty("webdriver.chrome.driver",
                "D:/aut5/tools/chromedriver.exe");
        driver = new ChromeDriver();
        RegistrationFormCore.open(driver);
        testPassed = false;
    }

    @After
    public void CleanUp() throws IOException {

        //for screenshots capturing
        if(!testPassed){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\" + name.getMethodName() + ".png"));
        }
        driver.quit();
    }






}
