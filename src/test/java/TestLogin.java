import PageObject.*;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class TestLogin {

    private WebDriver driver;
    private String userName = "Monkey D. Luffy";
    private String userEmail = "mugiwara@op.com";
    private String userPassword = "kingofpirates";

    User user = new User(userEmail, userPassword, userName);


    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        user.createAUserViaAPI();
    }

    @Test
    public void checkIfLoginWorksFromMainPage() {

        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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
