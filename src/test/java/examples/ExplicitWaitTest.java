package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExplicitWaitTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForDisappearingElement(){
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        assertFalse(checkbox.isSelected());
        assertTrue(checkbox.isDisplayed());

        WebElement removeOrAddButton = driver.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil();
        waitUntil.setWebDriverWait(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement removeOrAddMessage = driver.findElement(By.id("message"));
        assertEquals(removeOrAddMessage.getText(), "It's gone!");

        removeOrAddButton.click();
        waitUntil.waitUntilElementIsVisible(By.xpath("//input[@type='checkbox']"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
