package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomatedTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkWebsiteTest(){
        driver.navigate().to("https://duckduckgo.com/");

        driver.findElement(By.id("email1")).sendKeys("fake@email.com");
        driver.findElement(By.xpath("//button[@type='submit' and contains(text(), 'Submit']"));

        Assert.assertTrue(driver.findElement(By.xpath("//p[@style='color: rgb(32, 181, 31);']")).isDisplayed());
    }
}
