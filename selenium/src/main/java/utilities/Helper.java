package utilities;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Helper {
    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "path/to/IEDriverServer");
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
           // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("ff")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static String linkValidation(String hyperLinkUrl) {
        String result = "";
        try {
            URL url = new URL(hyperLinkUrl);
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            openConnection.setConnectTimeout(5000);
            openConnection.connect();

            if (HttpURLConnection.HTTP_OK == openConnection.getResponseCode()) {
                result = hyperLinkUrl + " : OK " + openConnection.getResponseCode();
            } else {
                result = hyperLinkUrl + " : " + openConnection.getResponseMessage();
            }
        } catch (Exception e) {
            result = "Exception caught: " + e.getMessage();
        }
        return result;
    }

    public static void captureScreenShort(WebDriver driver, String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            FileUtils.copyFile(src, new File("./screenshot/" + fileName + "_" + timestamp + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background-color: yellow; border: 2px solid red;')", element);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white;')", element);
    }
}
