package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopupPage extends BasePage{
    public CartPopupPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(css = ".modal-content .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public void goToCheckout(){
        click(proceedToCheckoutBtn);
    }
}
