package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_total_label");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title")
    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Canceling checkout process")
    public void cancelFromCheckout() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Finishing checkout")
    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Getting total price")
    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    @Step("Getting product name")
    public String getProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }
}
