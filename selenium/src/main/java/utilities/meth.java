package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
 
public class meth {
 
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        // Test with valid credentials
        loginAndTakeScreenshot(driver, "tomsmith", "SuperSecretPassword!");
 
        // Test with invalid credentials
        loginAndTakeScreenshot(driver, "tomsmith", "WrongPassword");
    }
 
    public static void loginAndTakeScreenshot(WebDriver driver, String username, String password) {
        try {
            // Navigate to the login page
            driver.get("https://the-internet.herokuapp.com/login");
 
            // Enter username and password
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
 
            // Click the login button
            driver.findElement(By.tagName("button")).click();
 
            // Check if login is successful
            try {
                WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
                if (successMessage.isDisplayed()) {
                    // If login is successful, take a screenshot
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(screenshot, new File("C:\\Users\\mathumithaa.p\\eclipse-workspace\\selenium\\screenshot\\login_success_screenshot.png"));
                    System.out.println("Login successful. Screenshot taken.");
                }
            } catch (NoSuchElementException e) {
                // If no success message is found, assume login failed
                System.out.println("Login failed for user: " + username);
            }
 
        } catch (Exception e) {
            System.out.println("Error during login attempt for user " + username + ": " + e.getMessage());
        }
    }
}
 
