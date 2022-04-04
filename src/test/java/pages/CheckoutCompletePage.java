package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By CONFIRMATION_MESSAGE = By.cssSelector(".complete-header");
    public static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title")
    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Canceling checkout process")
    public void goBackToProducts() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    @Step("Getting confirmation message")
    public String getConfirmationMessage() {
        return driver.findElement(CONFIRMATION_MESSAGE).getText();
    }
}
