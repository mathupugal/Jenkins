package utilities;
 
import java.io.File;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class ss1 extends Helper{
	public static void main(String[] args) {
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        // Open the URL
        driver.get("https://selenium.dev/");
        
       
        
        WebElement element = driver.findElement(By.id("Layer_1"));
        highlightElement(driver, element);
        // Call the helper method to capture the screenshot
        captureScreenShort(driver, "ss1");
 
      }
}