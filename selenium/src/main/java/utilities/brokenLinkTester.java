package utilities;
 
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import utilities.Helper;
 
public class brokenLinkTester extends Helper {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		driver = launchBrowser("chrome");
		driver.get("http://www.google.com");
		
		List<WebElement> links =driver.findElements(By.tagName("a"));
		
		
		for (WebElement link : links)
		{
			
			System.out.println(Helper.linkValidation(link.getAttribute("href")));
		
		}
		
		System.out.println("Google page has " + links.size() + " links");
	}
 
}
 
 