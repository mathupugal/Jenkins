package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class AlertExample {
    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
 
        // Navigate to the DemoQA Alerts page
        driver.get("https://demoqa.com/alerts");
 
        // 1. Handle Simple Alert
        System.out.println("Handling Simple Alert...");
        driver.findElement(By.id("alertButton")).click(); // Trigger the simple alert
        Alert simpleAlert = driver.switchTo().alert();    // Switch to the alert
        System.out.println("Simple Alert Text: " + simpleAlert.getText()); // Print the alert text
        simpleAlert.accept();                             // Accept the alert (OK)
 
        // 2. Handle Confirmation Alert
        System.out.println("Handling Confirmation Alert...");
        driver.findElement(By.id("confirmButton")).click(); // Trigger the confirmation alert
        Alert confirmAlert = driver.switchTo().alert();     // Switch to the alert
        System.out.println("Confirmation Alert Text: " + confirmAlert.getText()); // Print the alert text
        confirmAlert.dismiss();                             // Dismiss the alert (Cancel)
 
        // 3. Handle Prompt Alert
        System.out.println("Handling Prompt Alert...");
        driver.findElement(By.id("promtButton")).click(); // Trigger the prompt alert
        Alert promptAlert = driver.switchTo().alert();    // Switch to the alert
        System.out.println("Prompt Alert Text: " + promptAlert.getText()); // Print the alert text
        promptAlert.sendKeys("DemoQA Test");              // Enter text into the alert's input field
        promptAlert.accept();                             // Accept the alert (OK)
 
        // Close the browser
        driver.quit();
        System.out.println("Test Completed!");
    }
}
 
