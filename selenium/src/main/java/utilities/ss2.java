package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.io.FileHandler;

public class ss2 extends Helper {
    public static void main(String[] args) {
        // Create a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Open the URL
            driver.get("https://selenium.dev/");

            // Locate the first element and highlight it
            WebElement element = driver.findElement(By.id("Layer_1"));
            highlightElement(driver, element);

            // Capture a full screenshot and save as ss2a
            captureScreenShort(driver, "ss2a");

            // Locate the second element to highlight
            WebElement alertElement = driver.findElement(By.cssSelector(".alert.alert-selenium-blue.col-12.fade.show.mb-0.p-0.-bg-selenium-blue"));

            // Highlight the element in yellow
            highlightElement(driver, alertElement, "yellow");

            // Take a screenshot of just the highlighted element
            File srcFile = alertElement.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile, new File("ss2b.png"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to highlight an element with a specified color
    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        // Apply the highlight style
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
            element, "border: 2px solid " + color + "; background-color: yellow;");
        // Restore the original style after a short delay
        try {
            Thread.sleep(5000);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Overload of highlightElement to default to red
    public static void highlightElement(WebDriver driver, WebElement element) {
        highlightElement(driver, element, "red");
    }
}
