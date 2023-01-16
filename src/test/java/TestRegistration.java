import PageObject.LoginPage;
import PageObject.RegisterPage;
import PageObject.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRegistration {
    private WebDriver driver;
    private String token;
    private String userName = "Monkey D. Luffy";
    private String userEmail = "mugiwara@op.com";
    private String userPassword = "kingofpirates";
    private String userShortPassword = "123";

    User user = new User(userEmail, userPassword, userName);

    @Test
    public void checkIfValidRegistrationWorksOk() {
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

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
    public void checkIfTooShortPasswordIsNotAllowed(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        StartPage startPage = new StartPage(driver);
        startPage.clickOnPersonalAccount();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillShortPasswordAndRegister(userName, userEmail, userShortPassword);

        Assert.assertEquals("Некорректный пароль", registerPage.getErrorText());
    }

    @After
    public void closeBrowserAndDeleteUser() {
        driver.quit();

//        token = given()
//                .header("Content-type", "application/json")
//                .body(user)
//                .post("/api/auth/login")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .path("accessToken");
//
//        given()
//                .header("Authorization", token)
//                .delete("/api/auth/user")
//                .then()
//                .assertThat()
//                .statusCode(202);
    }

}
