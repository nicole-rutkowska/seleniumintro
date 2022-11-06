package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.WebDriverManager;
import waits.WaitForElement;

public class FishPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="a[href*='Id=FI-SW-01']")
    private WebElement angelfishLink;

    private WebDriver driver;

    public FishPage() {
        PageFactory.initElements(WebDriverManager.getWebDriver(), this);
    }

    public AngelfishPage clickAngelfishLink() {
        WaitForElement.waitUntilElementIsClickable(angelfishLink);
        angelfishLink.click();
        logger.info("Clicked on Angelfish Link.");
        return new AngelfishPage();
    }
}
