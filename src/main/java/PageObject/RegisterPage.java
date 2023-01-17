package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private String userEmail;
    private String userPassword;
    private String userName;
    private String userShortPassword;
    private By name = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private By email = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private By password = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    private  By registerUserButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    private By inputError = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    private By loginButtonInRegisterForm = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

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

    public void writeTooShortPasswordInput(String userShortPassword){
        driver.findElement(password).sendKeys(userShortPassword);
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

    public void fillShortPasswordAndRegister(String userName, String userEmail, String userShortPassword){
        waitForInputsToBeVisible();
        clickNameInput();
        writeNameInput(userName);
        clickEmailInput();
        writeEmailInput(userEmail);
        clickPasswordInput();
        writeTooShortPasswordInput(userShortPassword);
        clickRegisterButton();
    }



}
