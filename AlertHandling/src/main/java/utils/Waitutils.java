package utils;



import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.*;
 
import java.time.Duration;
 
public class Waitutils {

    private final WebDriver driver;

    private final WebDriverWait wait;
 
    public Waitutils(WebDriver driver, Duration timeout) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, timeout);

    }
 
    public Alert waitForAlert() {

        return wait.until(ExpectedConditions.alertIsPresent());

    }
 
    public WebElement waitClickable(By locator) {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
 
    public WebElement waitVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}

 