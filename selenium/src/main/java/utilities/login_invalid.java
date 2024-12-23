package utilities;
 
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
 
public class login_invalid {
    public static void main(String[] args) {
       
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();
 
        try {
            // Open the Herokuapp login page URL
            driver.get("https://the-internet.herokuapp.com/login");
 
            // Maximize the browser window
            driver.manage().window().maximize();
 
            // Locate the username and password fields and login button
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.cssSelector("button.radius"));
 
            // Enter invalid credentials
            usernameField.sendKeys("invalidUsername");
            passwordField.sendKeys("invalidPassword");
 
            // Click the login button
            loginButton.click();
 
            // Wait for the error message to appear
            Thread.sleep(2000); // Can be replaced with WebDriverWait for better handling
 
            // Capture a screenshot of the page with the login failure message
            String filePath = "C:\\Users\\mathumithaa.p\\eclipse-workspace\\selenium\\screenshot\\login_failure.png";
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
 