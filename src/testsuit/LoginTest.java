package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest extends BaseTest {

    @Before
    public void setUp(){

        setBaseUrl();
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //click on the ‘Sign In’ link

        driver.findElement(By.linkText("Sign In")).click();
        // Verify the text Welcome Back
        WebElement pageHead = driver.findElement(By.xpath("//h2[@class ='page__heading']"));
        String headerText = pageHead.getText();
        Assert.assertEquals("The page is not as expected","Welcome Back!",headerText);

    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=ExtensionsToolbarMenu");
        options.addArguments("--incognito");

        driver.findElement(By.linkText("Sign In")).click();
        //Enter invalid username
        // Enter invalid password
        // Click on Login button
        driver.findElement(By.id("user[email]")).sendKeys("chetan123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("Chetan123");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the error message “Your username is invalid!"
        //Verify error message on sing in page
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = driver.findElement(By.cssSelector(".form-error__list-item")).getText();
        Assert.assertEquals("Error message not match", expectedErrorMessage, actualErrorMessage);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
