package providers;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver getBrowser(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromedriver();
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            case IE:
                return getIeDriver();
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }

    public static WebDriver getChromedriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        if(Configuration.isHeadless()){
            options.addArguments("--headless");
        }

        return new ChromeDriver(options);
    }

    public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver getIeDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
