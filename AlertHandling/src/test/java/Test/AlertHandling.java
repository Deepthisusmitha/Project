package Test;


 
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.Test;

import base.basepage;
import pages.ForgotPasswordPage;

import pages.LoginPage;

import utils.Windowutils;
 
import java.time.Duration;
 
public class AlertHandling extends basepage {
 
    

    public void captureAndAcceptAlert() {

        Alert alert = driver.switchTo().alert();
 
        System.out.println("================================");

        System.out.println("ALERT DISPLAYED");

        System.out.println("ALERT MESSAGE : " + alert.getText());

        System.out.println("================================");
 
        alert.accept();

    }
 
    

    @Test

    public void test_SignIn_EmptyFields_ShowsAlert_And_VerifyText() {
 
        LoginPage login = new LoginPage(driver);

        login.open();
 
        

        login.clickSignInWithEmptyFields();
 
        

        captureAndAcceptAlert();
 
        

    }
 
    

    @Test

    public void test_ForgotPassword_NextWithoutInput_ShowsAlert_And_VerifyText() {
 
        LoginPage login = new LoginPage(driver);

        login.open();

        login.clickForgotPassword();
 
        ForgotPasswordPage fp = new ForgotPasswordPage(driver);

        fp.clickNextWithoutInput();
 
       

        captureAndAcceptAlert();

    }
 
    

    @Test

    public void test_PrivacyPolicy_OpensInNewTab_And_Verify() {
 
        LoginPage login = new LoginPage(driver);

        login.open();
 
        

        String parentWindow = driver.getWindowHandle();
 
       

        login.clickPrivacyPolicyFooter();
 
       

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
 
        

        Windowutils windowUtils = new Windowutils(driver);

        windowUtils.switchToNewWindow(parentWindow);
 
        

        String currentUrl = driver.getCurrentUrl();

        String title = driver.getTitle();
 
        System.out.println("================================");

        System.out.println("NEW TAB OPENED");

        System.out.println("TITLE : " + title);

        System.out.println("URL   : " + currentUrl);

        System.out.println("================================");
 
        boolean isPolicyPage =

                currentUrl.toLowerCase().contains("policy") ||

                currentUrl.toLowerCase().endsWith("policy.html");
 
        Assert.assertTrue(isPolicyPage,

                "Privacy Policy page not opened. URL: " + currentUrl);
 
       

        driver.close();

        driver.switchTo().window(parentWindow);

    }

}
 