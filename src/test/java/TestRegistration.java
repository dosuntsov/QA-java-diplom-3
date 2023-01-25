import org.apache.commons.lang3.RandomStringUtils;
import page_object.LoginPage;
import page_object.RegisterPage;
import page_object.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;

public class TestRegistration {
    private static final String BASE_URI  = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    String userEmail = (RandomStringUtils.randomAlphabetic(10) + "@mail.ru").toLowerCase();
    String userPassword = RandomStringUtils.randomAlphabetic(10);
    String userName = RandomStringUtils.randomAlphabetic(10);
    String userShortPassword = RandomStringUtils.randomAlphabetic(3);

    User user = new User(userEmail, userPassword, userName);
    User userTooShortPassword = new User(userEmail, userShortPassword, userName);
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        driver = new ChromeDriver();
        driver.get(BASE_URI);
    }

    @Test
    public void checkIfValidRegistrationWorksOk() {
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillAndClickRegister(userName, userEmail, userPassword);

        loginPage.waitForTextToBeVisible();

        Assert.assertEquals("Вход", loginPage.getHeaderText());

    }

    @Test
    public void checkIfTooShortPasswordIsNotAllowed() {
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillAndClickRegister(userName, userEmail, userShortPassword);

        Assert.assertEquals("Некорректный пароль", registerPage.getErrorText());
    }

    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();
        user.loginUserViaAPI();
        user.deleteUserViaAPI();
        userTooShortPassword.loginUserViaAPI();
        userTooShortPassword.deleteUserViaAPI();

    }

}
