package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
  //Web Elements

   By emailField = By.cssSelector("input[type='email']");
   By  passwordField = By.cssSelector("input[type='password']");

   By loginBtn = By.cssSelector("button[type='submit']");

    ////___PAGE Factory___////

    @FindBy(css="input[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css="input[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css="button[type='submit']")
    WebElement loginBtnLocator;


/////Helper Methods

    public void provideEmail(String email){
        findElement(emailField).sendKeys(email);
    }

   public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
   }

  public void clickSubmit(){
        findElement(loginBtn).click();
   }
   public void login(){
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickSubmit();
   }

   //Page Factory Methods
   public LoginPage provideEmailToLogin(String email){
       emailFieldLocator.clear();
       emailFieldLocator.sendKeys(email);
       return this;
   }
    public LoginPage providePasswordToLogin(String password){
        passwordFieldLocator.clear();
        passwordFieldLocator.sendKeys(password);
        return this;
   }
    public LoginPage clickSubmitBtn(){
        loginBtnLocator.click();
        return this;
    }

}
