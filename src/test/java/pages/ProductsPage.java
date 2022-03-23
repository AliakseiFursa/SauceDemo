package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {

    public static final By SORT_BUTTON = By.cssSelector(".product_sort_container");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By IMAGE_LINK = By.cssSelector("img[alt='Sauce Labs Backpack']");
    String productAddToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    String productOpen = "//div[text()='%s']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseURL + "inventory.html");
    }

    public void waitForLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public void openProduct(String product) {
        driver.findElement(By.xpath(String.format(productOpen, product))).click();
    }

    public void sort(String sorting) {
        new Select(driver.findElement(SORT_BUTTON)).selectByVisibleText(sorting);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public String getProductName(int index) {
        return driver.findElements(PRODUCT_NAME).get(index).getText();
    }

    public String getImgLink() {
        return driver.findElement(IMAGE_LINK).getAttribute("src");
    }
}
