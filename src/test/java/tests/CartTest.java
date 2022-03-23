package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCartAndRemovedOutOfCartFromProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        productsPage.removeFromCart("Sauce Labs Bike Light");
        navigationMenuPage.openShoppingCart();
        assertEquals(cartPage.getProductsCount(), 2, "Product count didn't match");
    }

    @Test
    public void productShouldBeAddedIntoCartAndRemovedOutOfCartFromProductInformationPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        productInformationPage.addToCart("Sauce Labs Backpack");
        productInformationPage.removeFromCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        assertEquals(cartPage.getProductsCount(), 0, "Product count didn't match");
    }

    @Test
    public void productShouldBeAddedIntoCartFromProductsPageAndRemovedOutOfCartFromCartPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.addToCart("Sauce Labs Backpack");
        navigationMenuPage.openShoppingCart();
        assertEquals(cartPage.getProductsCount(), 1, "Product count didn't match");
        cartPage.removeFromCart("Sauce Labs Backpack");
        assertEquals(cartPage.getProductsCount(), 0, "Product count didn't match");
    }

    @Test
    public void continueShoppingButtonShouldReturnToProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        navigationMenuPage.openShoppingCart();
        assertEquals(cartPage.getTitle(), "YOUR CART", "Cart page didn't open");
        cartPage.continueShopping();
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Products page didn't open");
    }
}
