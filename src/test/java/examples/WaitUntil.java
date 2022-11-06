package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUntil {
    private WebDriverWait webDriverWait;

    public void setWebDriverWait(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitUntilElementIsInvisible(WebElement checkbox){
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));
    }

    public void waitUntilElementIsVisible(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
