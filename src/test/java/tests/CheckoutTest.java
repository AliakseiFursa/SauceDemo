package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
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

    @Test
    public void checkoutTotalPrice() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "Fursa", "220117");
        assertEquals(checkoutOverviewPage.getTotalPrice(), "Total: $32.39", "Price doesn't match");
    }

    @Test
    public void firstNameShouldBeRequiredDuringCheckout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("", "Fursa", "220117");
        assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required", "Error didn't occurred");
    }

    @Test
    public void lastNameShouldBeRequiredDuringCheckout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "", "220117");
        assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required", "Error didn't occurred");
    }

    @Test
    public void postalCodeShouldBeRequiredDuringCheckout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "Fursa", "");
        assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required", "Error didn't occurred");
    }
}
