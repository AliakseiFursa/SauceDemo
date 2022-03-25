package pages;

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

    public void open() {
        driver.get(baseURL + "cart.html");
    }

    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void continueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public int getProductsCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }

}
