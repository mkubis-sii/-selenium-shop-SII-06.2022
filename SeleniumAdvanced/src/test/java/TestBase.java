import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import providers.Configuration;
import providers.DriverFactory;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getBrowser(Configuration.getBrowser());
        driver.get(Configuration.getAppUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}