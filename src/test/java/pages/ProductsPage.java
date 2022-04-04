package pages;

import io.qameta.allure.Step;
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

    @Step("Opening products page")
    public void open() {
        driver.get(baseURL + "inventory.html");
    }

    @Step("Waiting for page being loaded")
    public void waitForLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Getting page title")
    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Adding product to the cart")
    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    @Step("Removing product from the cart")
    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    @Step("Opening product detailed information")
    public void openProduct(String product) {
        driver.findElement(By.xpath(String.format(productOpen, product))).click();
    }

    @Step("Sorting products")
    public void sort(String sorting) {
        new Select(driver.findElement(SORT_BUTTON)).selectByVisibleText(sorting);
    }

    @Step("Getting current URL")
    public String getURL() {
        return driver.getCurrentUrl();
    }

    @Step("Getting product name")
    public String getProductName(int index) {
        return driver.findElements(PRODUCT_NAME).get(index).getText();
    }

    @Step("Getting IMG link")
    public String getImgLink() {
        return driver.findElement(IMAGE_LINK).getAttribute("src");
    }
}
