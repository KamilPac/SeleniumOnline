package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumShopLogin {
    public static WebDriver driver;

    /**** repozytorium elementów ****/
    @FindBy(id = "username")
    WebElement loginInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    WebElement logInButton;

    /**** konstruktor ****/
    public SeleniumShopLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**** metody ****/
    public void setLoginInput(String login){
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void setPasswordInput(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        logInButton.click();
    }

}