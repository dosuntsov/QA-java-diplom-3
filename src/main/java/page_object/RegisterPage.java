package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.xpath("//*[@class = 'input__container']/div/label[text() = 'Имя']/following-sibling::input");
    private By email = By.xpath("//*[@class = 'input__container']/div/label[text() = 'Email']/following-sibling::input");
    private By password = By.xpath("//*[@class = 'input__container']/div/label[text() = 'Пароль']/following-sibling::input");
    private  By registerUserButton = By.xpath("//*[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']");
    private By inputError = By.xpath("//*[@class = 'input__error text_type_main-default']");

    private By loginButtonInRegisterForm = By.xpath("//*[@class = 'Auth_link__1fOlj' and @href = '/login']");

    public void clickNameInput(){
        driver.findElement(name).click();
    }

    public void clickEmailInput(){
        driver.findElement(email).click();
    }

    public void clickPasswordInput(){
        driver.findElement(password).click();
    }

    public void clickRegisterButton(){
        driver.findElement(registerUserButton).click();
    }

    public void clickLoginButtonInRegisterForm(){
        driver.findElement(loginButtonInRegisterForm).click();
    }

    public void writeNameInput(String userName){
        driver.findElement(name).sendKeys(userName);
    }
    public void writeEmailInput(String userEmail){
        driver.findElement(email).sendKeys(userEmail);
    }
    public void writePasswordInput(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }

    public void waitForInputsToBeVisible(){
        new WebDriverWait(driver, 10).until (driver -> ((driver.findElement(name).isDisplayed())));
    }

    public String getErrorText(){
        String errorText =  driver.findElement(inputError).getText();
        return errorText;
    }

    public void fillAndClickRegister(String userName, String userEmail, String userPassword){
        waitForInputsToBeVisible();
        clickNameInput();
        writeNameInput(userName);
        clickEmailInput();
        writeEmailInput(userEmail);
        clickPasswordInput();
        writePasswordInput(userPassword);
        clickRegisterButton();
    }

}
