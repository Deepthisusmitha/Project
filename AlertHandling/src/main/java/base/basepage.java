package base;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;
 
import java.time.Duration;
 
public class basepage {

    protected WebDriver driver;
 
    @BeforeMethod

    public void setup() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments(

            "--start-maximized",

            "--disable-notifications",

            "--disable-infobars",

            "--disable-popup-blocking"

        );

        driver = new ChromeDriver(options); 

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
 
    @AfterMethod(alwaysRun = true)

    public void tearDown() {

        if (driver != null) driver.quit();

    }

}
 