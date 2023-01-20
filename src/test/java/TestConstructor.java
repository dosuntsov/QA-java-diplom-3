import PageObject.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestConstructor {
    private WebDriver driver;

    @Test
    public void checkIfTransitionsWorkCorrectly(){
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");

        StartPage startPage = new StartPage(driver);

        //checking buns
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilityBuns());
        //checking sauces
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilitySauces());
        //checking fillings
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilityFillings());

    }
    @After
    public void teardown(){
        driver.quit();
    }
}
