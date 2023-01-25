import org.apache.commons.lang3.RandomStringUtils;
import page_object.LoginPage;
import page_object.PrivateCabPage;
import page_object.StartPage;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class TestMoveToConstructor {
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
    public void movingFromPCtoConstructorByLogo(){
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

        Assert.assertEquals(BASE_URI + "/", startPage.gettingTheCurrentURL());

    }
    @Test
    public void movingFromPCtoConstructorByButton(){
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

        Assert.assertEquals(BASE_URI + "/", startPage.gettingTheCurrentURL());

    }
    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();
        user.deleteUserViaAPI();
    }

}
