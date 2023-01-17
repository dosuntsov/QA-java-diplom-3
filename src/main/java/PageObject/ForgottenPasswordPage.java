package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {
    private WebDriver driver;

    public ForgottenPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private By forgottenPasswordLogin = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    public void clickOnLoginButtonRestorePassword(){
        driver.findElement(forgottenPasswordLogin).click();
    }
}
