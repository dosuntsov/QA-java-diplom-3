package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivateCabPage {
    private WebDriver driver;

    public  PrivateCabPage(WebDriver driver){
        this.driver = driver;
    }

    private By profileButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[1]/a");
    private By logoButton = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");
    private By constructorButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");
    private By logoutButton = By.xpath("//*[@type='button' and text() = 'Выход']");

    public void clickOnLogo(){
        driver.findElement(logoButton).click();
    }

    public void clickOnConstructor(){
        driver.findElement(constructorButton).click();
    }
    public void clickOnLogoutButton(){
        driver.findElement(logoutButton).click();
    }
    public void waitForProfileButtonToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(profileButton).isDisplayed())));
    }
    public void waitForLogoutButtonToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(logoutButton).isDisplayed())));
    }

    public String getProfileText(){
        String profileText = driver.findElement(profileButton).getText();

        return profileText;
    }

    public void waitAndClickLogout(){
        waitForLogoutButtonToLoad();
        clickOnLogoutButton();
    }
}
