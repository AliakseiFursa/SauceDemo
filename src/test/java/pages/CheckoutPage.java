package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By CANCEL_BUTTON = By.id("cancel");
    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void fillInCheckoutInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public void cancelFromCheckout() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
