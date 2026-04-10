package utils;



import org.openqa.selenium.WebDriver;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
 
public class Windowutils {
    private final WebDriver driver;
 
    public Windowutils(WebDriver driver) { this.driver = driver; }
 
    public String switchToNewWindow(String parentHandle) {
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
            if (!h.equals(parentHandle)) {
                driver.switchTo().window(h);
                return h;
            }
        }
        throw new IllegalStateException("No new window found to switch!");
    }
 
    public List<String> getAllWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }
}
 