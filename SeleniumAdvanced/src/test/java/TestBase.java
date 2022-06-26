import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // ponizsza opcja uruchamia testy w trybie chroma
        // bez UI
        // options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.get("http://146.59.32.4/index.php");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}