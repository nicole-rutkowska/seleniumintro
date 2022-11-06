package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement firstUserPhoto = driver.findElement(By.xpath("//*[@id='content']/div/div[1]"));
        WebElement secondUserPhoto = driver.findElement(By.xpath("//*[@id='content']/div/div[2]"));
        WebElement thirdUserPhoto = driver.findElement(By.xpath("//*[@id='content']/div/div[3]"));

        Actions hover = new Actions(driver);
        hover.moveToElement(firstUserPhoto).perform();

        WebElement fistUserText = driver.findElement(By.xpath("//div[1]/div/h5"));
        WebElement secondUserText = driver.findElement(By.xpath("//div[2]/div/h5"));
        WebElement thirdUserText = driver.findElement(By.xpath("//div[3]/div/h5"));

        assertEquals(fistUserText.getText(), "name: user1");
        assertEquals(secondUserText.getText(), "");
        assertEquals(thirdUserText.getText(), "");

        hover.moveToElement(secondUserPhoto).perform();
        assertEquals(fistUserText.getText(), "");
        assertEquals(secondUserText.getText(), "name: user2");
        assertEquals(thirdUserText.getText(), "");

        hover.moveToElement(thirdUserPhoto).perform();
        assertEquals(fistUserText.getText(), "");
        assertEquals(secondUserText.getText(), "");
        assertEquals(thirdUserText.getText(), "name: user3");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
