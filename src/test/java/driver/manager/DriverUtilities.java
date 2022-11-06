package driver.manager;

public class DriverUtilities {
    public static void setInitialConfiguration() {
        WebDriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl) {
        WebDriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
