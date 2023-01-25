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


public class TestLogout {
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
    public void checkIfLogoutWorksCorrectly(){
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
        user.deleteUserViaAPI();
    }
}
