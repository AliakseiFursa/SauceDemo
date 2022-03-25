package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenuPage extends BasePage {

    public static final By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By ALL_ITEMS_BUTTON = By.id("inventory_sidebar_link");
    public static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");

    public NavigationMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    public void openMenu() {
        driver.findElement(MENU_BUTTON).click();
    }

    public void openInventory() {
        driver.findElement(ALL_ITEMS_BUTTON).click();
    }

    public void logout() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
