package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage {
    private WebDriver driver;

    public ForgottenPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private By forgottenPasswordLogin = By.xpath("//*[@class = 'Auth_link__1fOlj' and @href = '/login']");

    public void clickOnLoginButtonRestorePassword(){
        driver.findElement(forgottenPasswordLogin).click();
    }
}
