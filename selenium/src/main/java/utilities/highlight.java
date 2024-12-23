package utilities;
 
 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
 
public class highlight {
    public static void main(String[] args) {
        
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();
 
        try {
            // Open the Herokuapp login page URL
            driver.get("https://the-internet.herokuapp.com/login");
 
            // Maximize the browser window
            driver.manage().window().maximize();
 
            // Locate the username field
            WebElement usernameField = driver.findElement(By.id("username"));
 
            // Highlight the username field in yellow
            highlightElement(driver, usernameField);
 
            // Capture a screenshot of the page with the highlighted username field
            String filePath = "C:\\Users\\mathumithaa.p\\eclipse-workspace\\selenium\\screenshot\\highlight.png";
            captureScreenShort(driver, filePath);
 
            // Print confirmation message
            System.out.println("Screenshot saved at: " + filePath);
 
        } catch (Exception e) {
            System.out.println("Test encountered an error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
 
    // Method to highlight an element by adding a yellow background color
    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = 'yellow';", element);
    }
 
    // Method to capture a screenshot and save it to a specific location
    public static void captureScreenShort(WebDriver driver, String filePath) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Error taking screenshot!");
            e.printStackTrace();
        }
    }
}