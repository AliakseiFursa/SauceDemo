package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Incoming data for some negative login tests")
    public Object[][] loginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"}
        };
    }

    @Test(description = "Проверка необходимости ввода логина и пароля", dataProvider = "Incoming data for some negative login tests")
    public void userNameAndPasswordShouldBeRequired(String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), error, "Error message didn't occurred");
    }

    @Test(description = "Проверка невозможности залогиниться заблокированным пользователем")
    public void lockedUserLoginErrorMessage() {
        loginPage.open();
        loginPage.login("locked_out_user", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Error message didn't occurred");
    }

    @Test(description = "Проверка невозможности залогиниться с некорректным паролем")
    public void passwordDoNotMatchErrorMessage() {
        loginPage.open();
        loginPage.login(USER, "blabla");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message didn't occurred");
    }

    @Test(description = "Проверка невозможности залогиниться с некорректным логином")
    public void userNameDoNotMatchErrorMessage() {
        loginPage.open();
        loginPage.login("blabla", PASSWORD);
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service", "Error message didn't occurred");
    }

    @Test(description = "Корректный вход в систему с проверкой корректного отображения картинок")
    public void correctUserShouldBeLoggedInWithCorrectPictureOfProducts() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        assertEquals(productsPage.getImgLink(), "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", "Image link didn't match");
    }

    @Test(description = "Проверка входа в систему проблемным пользователем с проверкой некорректного отображения картинок")
    public void problemUserShouldBeLoggedInWithIncorrectPictureOfProducts() {
        loginPage.open();
        loginPage.login("problem_user", PASSWORD);
        assertEquals(productsPage.getTitle(), "blabla", "Login failed");
        assertNotEquals(productsPage.getImgLink(), "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg", "Image link matched");
    }
}
