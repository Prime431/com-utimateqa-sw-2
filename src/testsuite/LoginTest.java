package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest { //calling the BaseTest class to LoginTest class
    String baseUrl = "https://courses.ultimateqa.com/"; //URL

    @Before
    public void setUp() { //Method for launching the browser
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() { //
        String expectedText = "Welcome Back!"; //Storing expected Text
        driver.findElement(By.linkText("Sign In")).click(); //clicking the sign in button
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText(); //Capturing the Welcome back display message
        Assert.assertEquals(expectedText, actualText); // comparing the actual message and expected message
    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click(); //clicking on the sign in button
        driver.findElement(By.id("user[email]")).sendKeys("hfdjh@gmail.com"); // entering the invalid email id in email id field
        driver.findElement(By.id("user[password]")).sendKeys("hjdfj"); // invalid password
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // click on submit button
        String expectedText = "‘Invalid email\n" +
                "or password."; // expected message
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText(); // actual message
        Assert.assertEquals(expectedText,actualText); // comparing the actual and expected message
    }

    @After
    public void tearDown() {
        closeBrowser();
    } // closing the browser
}