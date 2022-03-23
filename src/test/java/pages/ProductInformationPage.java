package pages;

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

    public String getName() {
        return driver.findElement(PRODUCT_DETAILED_NAME).getText();
    }

    public String getPrice() {
        return driver.findElement(PRODUCT_DETAILED_PRICE).getText();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public void goBackToProducts() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }
}
