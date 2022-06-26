package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#quantity_wanted")
    private WebElement productQuantityInput;

    @FindBy(css=".add-to-cart")
    private WebElement addToCartBtn;

    public ProductDetailsPage setQuantity(int quantity){
        productQuantityInput.clear();
        sendKeys(productQuantityInput, String.valueOf(quantity));
        return this;
    }

    public void addToCart(){
        click(addToCartBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content .btn-primary")));
    }

}
