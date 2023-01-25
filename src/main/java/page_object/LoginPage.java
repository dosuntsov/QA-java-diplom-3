package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginInput = By.xpath("//*[@class = 'input__container']/div/label[text() = 'Email']/following-sibling::input");
    private By loginButton = By.xpath("//*[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Войти']");
    private By registerButton = By.xpath(".//a[@class = 'Auth_link__1fOlj' and @href = '/register']");
    private By enterPicture = By.xpath("//h2[text() = 'Вход']");
    private By forgottenPassword = By.xpath("//*[@class = 'Auth_link__1fOlj' and @href = '/forgot-password']");


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
