package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    public static final By PRODUCT_IN_CART = By.cssSelector(".cart_item");
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening cart page")
    public void open() {
        driver.get(baseURL + "cart.html");
    }

    @Step("Proceed to checkout")
    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Getting page title")
    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Returning to products page")
    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Removing product from the cart")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    @Step("Getting products count in cart")
    public int getProductsCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }

}
