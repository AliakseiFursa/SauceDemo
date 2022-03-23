package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void correctProductInformationShouldBeDisplayedAfterChoosingProduct() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        assertEquals(productInformationPage.getName(), "Sauce Labs Backpack", "Product didn't match");
        assertEquals(productInformationPage.getPrice(), "$29.99", "Price didn't match");
    }

    @Test
    public void backToProductsButtonShouldReturnToProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        productInformationPage.goBackToProducts();
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Return to products page failed");
    }

    @Test
    public void sortingProducts() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductName(0), "Sauce Labs Backpack");
        assertEquals(productsPage.getProductName(5), "Test.allTheThings() T-Shirt (Red)");
    }
}
