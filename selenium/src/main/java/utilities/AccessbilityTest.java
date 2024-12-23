package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class AccessbilityTest {
    public static void main(String[] args) {
 
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
 
        // Open the website (replace this with the URL you want to test)
        driver.get("https://the-internet.herokuapp.com/login");
 
        // Locate the username and password fields by their IDs (or any other suitable locators)
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
 
        // Check the title attribute for the username field
        String usernameTitle = usernameField.getAttribute("title");
        if (usernameTitle == null || usernameTitle.isEmpty()) {
            System.out.println("Username field does NOT have a 'title' attribute.");
        } else {
            System.out.println("Username field has a 'title' attribute: " + usernameTitle);
        }
 
        // Check the title attribute for the password field
        String passwordTitle = passwordField.getAttribute("title");
        if (passwordTitle == null || passwordTitle.isEmpty()) {
            System.out.println("Password field does NOT have a 'title' attribute.");
        } else {
            System.out.println("Password field has a 'title' attribute: " + passwordTitle);
        }
 
        // Quit the driver
        driver.quit();
    }
}
 
 