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

    public void clickMainPageLoginButton(){
        driver.findElement(mainPageLoginButton).click();
    }
    public void clickOnPersonalAccount(){
        driver.findElement(personalAccount).click();
    }

    public void waitForPersonalAccountToLoad(){
       new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(personalAccount).isDisplayed())));
    }


}