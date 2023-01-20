import PageObject.LoginPage;
import PageObject.PrivateCabPage;
import PageObject.StartPage;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class TestLogout {
    private WebDriver driver;
    public String token;
    private String userName = "Monkey D. Luffy";
    private String userEmail = "mugiwara@op.com";
    private String userPassword = "kingofpirates";

    User user = new User(userEmail, userPassword, userName);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        createAUser();

    }

    public void createAUser() {
        token = given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/register")
                .then()
                .extract()
                .path("accessToken");
    }
    @Test
    public void checkIfLogoutWorksCorrectly(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();
        //Login User
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail, userPassword);

        //Try going from start page to account page
        startPage.waitForPersonalAccountToLoad();

        startPage.clickOnPersonalAccount();

        //Clicking the logout button
        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitAndClickLogout();

        loginPage.waitForTextToBeVisible();

        Assert.assertEquals("Вход", loginPage.getHeaderText());

    }
    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();

        given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .delete("/api/auth/user");
    }
}
