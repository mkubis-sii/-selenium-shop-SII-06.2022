package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGridPage extends BasePage{
    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".product-title")
    List<WebElement> productName;
    public void openProductWithName(String name){
        for (WebElement productName : productName){
            if(productName.equals(name)){
                productName.click();
                return;
            }
        }
    }
}
