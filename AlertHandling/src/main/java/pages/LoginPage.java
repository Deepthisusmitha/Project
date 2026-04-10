package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Waitutils;
 
public class LoginPage {

    private final WebDriver driver;

    private final Waitutils wait;
 
    

    private final By userId = By.id("login1");

    private final By password = By.id("password");

    private final By signInBtn = By.name("proceed");

    private final By forgotPwd = By.partialLinkText("Forgot");

    private final By privacyPolicyFooter = By.linkText("Privacy Policy");
 
   

    private final By signInBtnAlt = By.xpath("//input[@type='submit' and contains(@value,'Sign in')]");

    private final By privacyPolicyAlt = By.xpath("//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'privacy')]");
 
    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new Waitutils(driver, Duration.ofSeconds(10));

    }
 
    public void open() {

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

    }
 
    public void clickSignInWithEmptyFields() {

        try {

            wait.waitClickable(signInBtn).click();

        } catch (TimeoutException e) {

            driver.findElement(signInBtnAlt).click();

        }

    }
 
    public void clickForgotPassword() {

        wait.waitClickable(forgotPwd).click();

    }
 
    

    public void clickPrivacyPolicyFooter() {

        By targetLocator;

        WebElement link;

        try {

            link = wait.waitVisible(privacyPolicyFooter);

            targetLocator = privacyPolicyFooter;

        } catch (Exception e) {

            link = wait.waitVisible(privacyPolicyAlt);

            targetLocator = privacyPolicyAlt;

        }
 
       

        ((JavascriptExecutor) driver)

                .executeScript("arguments[0].scrollIntoView({block:'center'});", link);
 
        try {

            wait.waitClickable(targetLocator).click();

        } catch (ElementClickInterceptedException ex) {

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);

        }

    }

}
 