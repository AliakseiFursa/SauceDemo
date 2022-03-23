package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LoginTest extends BaseTest {

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("test", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required", "Error message didn't occurred");
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "test");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required", "Error message didn't occurred");
    }

    @Test
    public void lockedUserLoginErrorMessage() {
        loginPage.open();
        loginPage.login("locked_out_user", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Error message didn't occurred");
    }

    @Test
    public void passwordDoNotMatchErrorMessage() {
        loginPage.open();
        loginPage.login(USER, "blabla");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message didn't occurred");
    }

    @Test
    public void userNameDoNotMatchErrorMessage() {
        loginPage.open();
        loginPage.login("blabla", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message didn't occurred");
    }

    @Test
    public void correctUserShouldBeLoggedInWithCorrectPictureOfProducts() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        assertEquals(productsPage.getImgLink(), "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", "Image link didn't match");
    }

    @Test
    public void problemUserShouldBeLoggedInWithIncorrectPictureOfProducts() {
        loginPage.open();
        loginPage.login("problem_user", PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        assertNotEquals(productsPage.getImgLink(), "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", "Image link matched");
    }
}
