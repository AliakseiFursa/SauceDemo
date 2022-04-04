package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInformationPage extends BasePage {

    public static final By PRODUCT_DETAILED_PRICE = By.cssSelector(".inventory_details_price");
    public static final By PRODUCT_DETAILED_NAME = By.cssSelector(".inventory_details_name");
    public static final By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    String productAddToCart = "//div[text()='%s']/ancestor::div[@class='inventory_details']//button[text()='Add to cart']";
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='inventory_details']//button[text()='Remove']";

    public ProductInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting product name")
    public String getName() {
        return driver.findElement(PRODUCT_DETAILED_NAME).getText();
    }

    @Step("Getting product price")
    public String getPrice() {
        return driver.findElement(PRODUCT_DETAILED_PRICE).getText();
    }

    @Step("Adding product to the cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    @Step("Removing product from the cart")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    @Step("Returning to products page")
    public void goBackToProducts() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }
}
