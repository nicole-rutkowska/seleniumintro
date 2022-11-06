package tests;

import page.objects.LandingPage;
import page.objects.LoginPage;
import org.testng.annotations.Test;
import driver.manager.DriverUtilities;

import java.time.Duration;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class FailedLoginTest extends TestBase {

    @Test
    public void loginWithIncorrectLoginAndPassword() {

        DriverUtilities.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingLogin")
                .typeIntoPasswordField("NotProperPassword")
                .clickOnLoginButton();

        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}
