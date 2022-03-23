package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutShouldBeDoneFromProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        navigationMenuPage.openMenu();
        navigationMenuPage.logout();
        assertEquals(loginPage.getURL(), "https://www.saucedemo.com/", "Logout failed");
    }

    @Test
    public void logoutShouldBeDoneFromCartPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        navigationMenuPage.openShoppingCart();
        navigationMenuPage.openMenu();
        navigationMenuPage.logout();
        assertEquals(loginPage.getURL(), "https://www.saucedemo.com/", "Logout failed");
    }
}
