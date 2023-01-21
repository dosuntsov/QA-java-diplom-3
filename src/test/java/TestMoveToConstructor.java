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

public class TestMoveToConstructor {
    private WebDriver driver;
    public String token;
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
    public void movingFromPCtoConstructorByLogo(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        //Login user
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail, userPassword);

        //getting to personal cab
        startPage.waitForPersonalAccountToLoad();
        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        //moving from PC to main page using logo
        privateCabPage.clickOnLogo();

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", startPage.gettingTheCurrentURL());

    }
    @Test
    public void movingFromPCtoConstructorByButton(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        //Login user
        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(userEmail, userPassword);

        //getting to personal cab
        startPage.waitForPersonalAccountToLoad();
        startPage.clickOnPersonalAccount();

        PrivateCabPage privateCabPage = new PrivateCabPage(driver);
        privateCabPage.waitForProfileButtonToLoad();

        //moving from PC to main page using logo
        privateCabPage.clickOnConstructor();

        Assert.assertEquals("https://stellarburgers.nomoreparties.site/", startPage.gettingTheCurrentURL());

    }
    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();
        user.deleteUserViaAPI();
    }

}
