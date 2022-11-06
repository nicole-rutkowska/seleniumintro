package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTest extends TestBase {
    @Test public void addFishToCart() {

        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage.clickOnFishLink().clickAngelfishLink().addSmallAngelfishToCart().clickProceedToCheckoutButton();

        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage,
                "You must sign on before attempting to check out. Please sign on and try " +
                        "checking out again.");
    }
}
