package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
 
public class AscLoginPage
{
	static WebDriver driver;
	
	//Constructor
	public AscLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
 
	// WebElement Locators
	public By username = By.name("username");
 
	// Is Username field in expected position?
	public Point getUsernamePosition()
	{
		Point UsernamePos = driver.findElement(username).getLocation();
		return UsernamePos;
 
	}
 
 
}