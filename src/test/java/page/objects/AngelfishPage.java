package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.WebDriverManager;
import waits.WaitForElement;

public class AngelfishPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href*='Id=EST-2']")
    private WebElement smallAngelfishCartButton;

    public AngelfishPage(){
        PageFactory.initElements(WebDriverManager.getWebDriver(), this);
    }

    public ShoppingCartPage addSmallAngelfishToCart() {
        WaitForElement.waitUntilElementIsClickable(smallAngelfishCartButton);
        smallAngelfishCartButton.click();
        logger.info("Added Small Angelfish to cart.");
        return new ShoppingCartPage();
    }
}
