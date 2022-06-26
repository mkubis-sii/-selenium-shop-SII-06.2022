import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CartPopupPage;
import pages.ProductDetailsPage;
import pages.ProductsGridPage;

public class CartTest extends TestBase {

    @Test
    public void shouldAddProductToBasket() {
        new ProductsGridPage(driver).openProductWithName("HUMMINGBIRD T-SHIRT");

        new ProductDetailsPage(driver)
                .setQuantity(5)
                .addToCart();

        new CartPopupPage(driver).goToCheckout();

        CartPage cartPage = new CartPage(driver);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(cartPage.getProductName()).isEqualTo("HUMMINGBIRD T-SHIRT");
        softAssertions.assertThat(cartPage.getProductPrice()).isEqualTo("$19.12");
        softAssertions.assertThat(cartPage.getProductTotalPrice()).isEqualTo("$95.60");
        softAssertions.assertThat(cartPage.getProductQuantity()).isEqualTo("5");

        softAssertions.assertAll();
    }
}
