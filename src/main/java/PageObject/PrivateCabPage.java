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

    public void waitForProfileButtonToLoad(){
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(profileButton).isDisplayed())));
    }

    public String getProfileText(){
        String profileText = driver.findElement(profileButton).getText();

        return profileText;
    }
}
