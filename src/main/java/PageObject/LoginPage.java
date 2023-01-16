package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By registerButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and @href = '/register']");

    private By enterPicture = By.xpath("//*[@id=\"root\"]/div/main/div/h2");

    public void clickOnRegisterButton(){
        driver.findElement(registerButton).click();
    }

    public String getHeaderText(){
        String headerText = driver.findElement(enterPicture).getText();

        return headerText;
    }

    public void waitForTextToBeVisible(){
        new WebDriverWait(driver, 10).until(driver -> ((driver.findElement(enterPicture).getText().contains("Вход"))));
    }


}
