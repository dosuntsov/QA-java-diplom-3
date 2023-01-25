package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By personalAccount = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href = '/account']");
    private By mainPageLoginButton = By.xpath("//*[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']");
    private By bunsButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Булки']/..");
    private By sauceButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Соусы']/..");
    private By fillingsButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Начинки']/..");


    public void clickMainPageLoginButton() {
        driver.findElement(mainPageLoginButton).click();
    }

    public void clickOnPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    public void clickOnSauceButton() {
        driver.findElement(sauceButton).click();
    }

    public void clickOnFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    public String gettingTheCurrentURL() {
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public void waitForPersonalAccountToLoad() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(personalAccount).isDisplayed())));
    }

    public void waitForBunsButtonToLoad() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(bunsButton).isDisplayed())));
    }

    public void waitForBunsToLoad() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(bunsButton).isDisplayed())));
    }

    public void waitForSaucesToLoad() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(sauceButton).isDisplayed())));
    }

    public void waitForFillingsToLoad() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(fillingsButton).isDisplayed())));
    }

    public boolean checkIfBunIsVisible() {
        boolean resultBuns = driver.findElement(bunsButton).getAttribute("class").contains("current");
        return resultBuns;
    }

    public boolean checkIfSauceIsVisible() {
        boolean resultSauces = driver.findElement(sauceButton).getAttribute("class").contains("current");
        return resultSauces;
    }

    public boolean checkIfFillingIsVisible() {
        boolean resultFillings = driver.findElement(fillingsButton).getAttribute("class").contains("current");
        return resultFillings;
    }

    public boolean clickAndWaitAndCheckVisibilityBuns() {
        waitForBunsButtonToLoad();
        waitForBunsToLoad();
        return checkIfBunIsVisible();
    }

    public boolean clickAndWaitAndCheckVisibilitySauces() {
        clickOnSauceButton();
        waitForSaucesToLoad();
        return checkIfSauceIsVisible();
    }

    public boolean clickAndWaitAndCheckVisibilityFillings() {
        clickOnFillingsButton();
        waitForFillingsToLoad();
        return checkIfFillingIsVisible();
    }

}