import org.apache.commons.lang3.RandomStringUtils;
import page_object.*;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class TestLogin {
    private static final String BASE_URI  = "https://stellarburgers.nomoreparties.site";
    private WebDriver driver;
    String userEmail = (RandomStringUtils.randomAlphabetic(10) + "@mail.ru").toLowerCase();
    String userPassword = RandomStringUtils.randomAlphabetic(10);
    String userName = RandomStringUtils.randomAlphabetic(10);

    User user = new User(userEmail, userPassword, userName);


    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        driver = new ChromeDriver();
        driver.get(BASE_URI);
        user.createAUserViaAPI();
    }

    @Test
    public void checkIfLoginWorksFromMainPage() {
        StartPage startPage = new StartPage(driver);
        startPage.clickMainPageLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail, userPassword);

        startPage.waitForPersonalAccountToLoad();

        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        Assert.assertEquals("Профиль", privateCabPage.getProfileText());

    }

    @Test
    public void checkIfLoginWorksFromPersonalAccountButton() {
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail, userPassword);

        startPage.waitForPersonalAccountToLoad();

        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        Assert.assertEquals("Профиль", privateCabPage.getProfileText());

    }

    @Test
    public void checkIfLoginWorksFromRegistrationForm() {
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginButtonInRegisterForm();

        loginPage.loginUser(userEmail, userPassword);

        startPage.waitForPersonalAccountToLoad();

        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        Assert.assertEquals("Профиль", privateCabPage.getProfileText());
    }

    @Test
    public void checkIfLoginWorksFromRestoringPasswordForm() {
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnForgottenPassword();

        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        forgottenPasswordPage.clickOnLoginButtonRestorePassword();

        loginPage.loginUser(userEmail, userPassword);

        startPage.waitForPersonalAccountToLoad();

        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        Assert.assertEquals("Профиль", privateCabPage.getProfileText());

    }

    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();
        user.deleteUserViaAPI();

    }

}
