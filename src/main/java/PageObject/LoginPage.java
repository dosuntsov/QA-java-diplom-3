package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By registerButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and @href = '/register']");
    private By enterPicture = By.xpath("//*[@id=\"root\"]/div/main/div/h2");
    private By forgottenPassword = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");


    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickOnForgottenPassword() {
        driver.findElement(forgottenPassword).click();
    }

    public void clickOnLoginInput() {
        driver.findElement(loginInput).click();
    }

    public void clickOnLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void fillLoginInput(String userEmail, String userPassword) {
        driver.findElement(loginInput).sendKeys(userEmail, Keys.TAB, userPassword);
    }

    public String getHeaderText() {
        String headerText = driver.findElement(enterPicture).getText();

        return headerText;
    }

    public void waitForTextToBeVisible() {
        new WebDriverWait(driver, 10).until(driver -> ((driver.findElement(enterPicture).getText().contains("Вход"))));
    }

    public void waitForInputsToBeInteractable() {
        new WebDriverWait(driver, 10).until(driver1 -> ((driver.findElement(loginInput).isDisplayed())));
    }

    public void loginUser(String userEmail, String userPassword) {
        waitForTextToBeVisible();
        waitForInputsToBeInteractable();
        clickOnLoginInput();
        fillLoginInput(userEmail, userPassword);
        clickOnLoginButton();
    }

}
