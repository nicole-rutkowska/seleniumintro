package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.WebDriverManager;
import waits.WaitForElement;

public class ShoppingCartPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css="a.Button[href*='newOrderForm']")
    private WebElement checkoutButton;

    private WebDriver driver;

    public ShoppingCartPage() {
        PageFactory.initElements(WebDriverManager.getWebDriver(), this);
    }

    public void clickProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(checkoutButton);
        checkoutButton.click();
        logger.info("clicked on Proceed To Checkout Button");
    }
}
