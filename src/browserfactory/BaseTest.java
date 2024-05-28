package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void setBaseUrl(){

        String baseUrl = "https://courses.ultimateqa.com/";
        //launch the Chrome driver
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");//Disable browser Notification
        options.addArguments("--incognito"); // Open browser in private/incognito window
        options.addArguments("--disable-features=ExtensionsToolbarMenu");
        options.addArguments("--headless"); // Headless browser
        //Open the url in browser
        driver.get(baseUrl);
        //Maximise the Browser
        driver.manage().window().maximize();
        //we give Implicite wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
}
