package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions= new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;

    public void sendKeys(WebElement element, String text){
        System.out.println("Typing: " + text);
        element.sendKeys(text);
    }

    public void click(WebElement element){
        System.out.println("Clicking on: " + element.getText());
        element.click();
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }
}
