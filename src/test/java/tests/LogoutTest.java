package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends BaseTest {

    @Test(description = "Проверка на возможность разлогиниться со страницы продуктов")
    public void logoutShouldBeDoneFromProductsPage() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        navigationMenuPage.openMenu();
        navigationMenuPage.logout();
        assertEquals(loginPage.getURL(), "https://www.saucedemo.com/", "Logout failed");
    }

    @Test(description = "Проверка на возможность разлогиниться со страницы корзины")
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
