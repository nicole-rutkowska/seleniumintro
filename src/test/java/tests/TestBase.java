package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import driver.BrowserType;
import driver.manager.DriverUtilities;
import driver.manager.WebDriverManager;
import org.testng.annotations.*;

import java.util.Properties;

import static navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass(){
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        WebDriverManager.setWebDriver(browserType);
        WebDriverManager.getWebDriver();
        DriverUtilities.setInitialConfiguration();
        DriverUtilities.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        WebDriverManager.disposeDriver();
    }

}