package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By personalAccount = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href = '/account']");

    public void clickOnPersonalAccount(){
        driver.findElement(personalAccount).click();
    }


}