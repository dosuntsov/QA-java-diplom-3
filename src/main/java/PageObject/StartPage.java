package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage {
    private WebDriver driver;
    public StartPage(WebDriver driver) {
        this.driver = driver;
    }
    private By personalAccount = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href = '/account']");
    private By mainPageLoginButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    private By bunsButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Булки']");
    private By sauceButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Соусы']");
    private By fillingsButton = By.xpath("//*[@class='text text_type_main-default' and text() = 'Начинки']");
    private By expectedBun = By.xpath("//*[@class='BurgerIngredient_ingredient__text__yp3dH' and text() = 'Краторная булка N-200i']");
    private By expectedSauce = By.xpath("//*[@class='BurgerIngredient_ingredient__text__yp3dH' and text() = 'Соус с шипами Антарианского плоскоходца']");
    private By expectedFilling = By.xpath("//*[@class='BurgerIngredient_ingredient__text__yp3dH' and text() = 'Говяжий метеорит (отбивная)']");
    public void clickMainPageLoginButton(){
        driver.findElement(mainPageLoginButton).click();
    }
    public void clickOnPersonalAccount(){
        driver.findElement(personalAccount).click();
    }
    public void clickOnBunsButton(){
        driver.findElement(bunsButton).click();
    }
    public void clickOnSauceButton(){
        driver.findElement(sauceButton).click();
    }
    public void clickOnFillingsButton(){
        driver.findElement(fillingsButton).click();
    }
    public String gettingTheCurrentURL(){
        String currentURL = driver.getCurrentUrl();
        return currentURL;
    }

    public void waitForPersonalAccountToLoad(){
       new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(personalAccount).isDisplayed())));
    }
    public void waitForBunsButtonToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(bunsButton).isDisplayed())));
    }
    public void waitForBunsToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(expectedBun).isDisplayed())));
    }
    public void waitForSaucesToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(expectedSauce).isDisplayed())));
    }
    public void waitForFillingsToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(expectedFilling).isDisplayed())));
    }

    public boolean checkIfBunIsVisible(){
        boolean resultBuns = driver.findElement(expectedBun).isDisplayed();
        return resultBuns;
    }
    public boolean checkIfSauceIsVisible(){
        boolean resultSauces = driver.findElement(expectedSauce).isDisplayed();
        return resultSauces;
    }
    public boolean checkIfFillingIsVisible(){
        boolean resultFillings = driver.findElement(expectedFilling).isDisplayed();
        return resultFillings;
    }

    public boolean clickAndWaitAndCheckVisibilityBuns(){
        waitForBunsButtonToLoad();
        //clickOnBunsButton();
        waitForBunsToLoad();
        return checkIfBunIsVisible();
    }
    public boolean clickAndWaitAndCheckVisibilitySauces(){
        clickOnSauceButton();
        waitForSaucesToLoad();
        return checkIfSauceIsVisible();
    }
    public boolean clickAndWaitAndCheckVisibilityFillings(){
        clickOnFillingsButton();
        waitForFillingsToLoad();
        return checkIfFillingIsVisible();
    }




}