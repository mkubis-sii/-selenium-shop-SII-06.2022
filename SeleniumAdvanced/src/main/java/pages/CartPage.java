package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-line-info a")
    private WebElement productName;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement productQuantity;

    @FindBy(css = ".current-price")
    private WebElement productPrice;

    @FindBy(css = ".price .product-price")
    private WebElement productTotalPrice;

    public String getProductName() {
        return productName.getText();
    }

    public String getProductQuantity() {
        return productQuantity.getAttribute("value");
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getProductTotalPrice() {
        return productTotalPrice.getText();
    }
}
