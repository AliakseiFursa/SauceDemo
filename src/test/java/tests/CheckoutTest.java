package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(description = "Проверка полной покупки товара")
    public void checkoutFullBuy() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "Fursa", "220117");
        assertEquals(checkoutOverviewPage.getProductName(), "Sauce Labs Backpack", "Product didn't match");
        checkoutOverviewPage.finishCheckout();
        assertEquals(checkoutCompletePage.getConfirmationMessage(), "THANK YOU FOR YOUR ORDER", "Order wasn't confirmed");
    }

    @Test(description = "Проверка полной стоимости покупки")
    public void checkoutTotalPrice() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "Fursa", "220117");
        assertEquals(checkoutOverviewPage.getTotalPrice(), "Total: $32.39", "Price doesn't match");
    }

    @DataProvider(name = "Incoming data for checkout test")
    public Object[][] checkoutData() {
        return new Object[][]{
                {"", "Fursa", "220117", "Error: First Name is required"},
                {"Aliaksei", "", "220117", "Error: Last Name is required"},
                {"Aliaksei", "Fursa", "", "Error: Postal Code is required"}
        };
    }

    @Test(description = "Проверка необходимости ввода всех персональных данных во время чекаута", dataProvider = "Incoming data for checkout test")
    public void allDataShouldBeRequiredDuringCheckout(String firstName, String lastName, String postalCode, String error) {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo(firstName, lastName, postalCode);
        assertEquals(checkoutPage.getErrorMessage(), error, "Error didn't occurred");
    }
}
