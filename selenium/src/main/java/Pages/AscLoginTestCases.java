package Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import Pages.AscLoginPage;
 
public class AscLoginTestCases {
	static WebDriver driver;
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();

		driver.get("C:\\Users\\mathumithaa.p\\Downloads\\asc 1.html");
		AscLoginPage ap = new AscLoginPage(driver);

		System.out.println("Username position match: " + ap.getUsernamePosition().toString().equals("(125, 11)"));
 
 
	}
 
}