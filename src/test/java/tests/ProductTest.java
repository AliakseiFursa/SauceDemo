package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test(description = "Проверка перехода на страницу информации о продукте")
    public void correctProductInformationShouldBeDisplayedAfterChoosingProduct() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        assertEquals(productInformationPage.getName(), "Sauce Labs Backpack", "Product didn't match");
        assertEquals(productInformationPage.getPrice(), "$29.99", "Price didn't match");
    }

    @Test(description = "Проверка возврата на страницу продуктов нажатием кнопки 'back to products'")
    public void backToProductsButtonShouldReturnToProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.openProduct("Sauce Labs Backpack");
        productInformationPage.goBackToProducts();
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Return to products page failed");
    }

    @Test(description = "Проверка корректной работы сортировки")
    public void sortingProducts() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductName(0), "Sauce Labs Backpack");
        assertEquals(productsPage.getProductName(5), "Test.allTheThings() T-Shirt (Red)");
    }
}
