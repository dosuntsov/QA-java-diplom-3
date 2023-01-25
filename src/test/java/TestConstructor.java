import org.junit.Before;
import page_object.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestConstructor {
    private static final String START_PAGE  = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;
    StartPage startPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(START_PAGE);
        startPage = new StartPage(driver);

    }
    @Test
    public void checkIfTransitionsWorkCorrectlyBuns(){
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilityBuns());
    }
    @Test
    public void checkIfTransitionsWorkCorrectlySauces(){
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilitySauces());
    }
    @Test
    public void checkIfTransitionsWorkCorrectlyFillings(){
        Assert.assertTrue(startPage.clickAndWaitAndCheckVisibilityFillings());
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
