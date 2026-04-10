package pages;



import org.openqa.selenium.*;

import utils.Waitutils;
 
import java.time.Duration;
 
public class ForgotPasswordPage {

    private final WebDriver driver;

    private final Waitutils wait;
 
   

    private final By nextBtn = By.xpath(

        "//input[@type='submit' and (contains(@value,'Next') or contains(@value,'Continue'))] | " +

        "//button[(contains(.,'Next') or contains(.,'Continue'))]");
 
    public ForgotPasswordPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new Waitutils(driver, Duration.ofSeconds(10));

    }
 
    public void clickNextWithoutInput() {

        wait.waitClickable(nextBtn).click();

    }

}

 