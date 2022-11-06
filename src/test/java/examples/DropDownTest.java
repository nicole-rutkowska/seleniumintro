package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
    public void dropDownTest() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdown);

        String selectedOption = dropdownSelect.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Please select an option");

        dropdownSelect.selectByValue("1");
        selectedOption = dropdownSelect.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 1");

        dropdownSelect.selectByValue("2");
        selectedOption = dropdownSelect.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 2");
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
