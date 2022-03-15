import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkout() {
        String productLocator = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("user-name")).submit();
        driver.findElement(By.xpath(String.format(productLocator, "Sauce Labs Backpack"))).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Aliaksei");
        driver.findElement(By.id("last-name")).sendKeys("Fursa");
        driver.findElement(By.id("postal-code")).sendKeys("220117");
        driver.findElement(By.id("continue")).click();
        String totalPrice = driver.findElement(By.cssSelector(".summary_total_label")).getText();
        assertEquals(totalPrice, "Total: $32.39", "Price doesn't match");
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Backpack", "Product name doesn't match");
    }
}
