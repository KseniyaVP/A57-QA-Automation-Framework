import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    public void navigateToPage(String url){

        driver.get(url);
    }

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
/*@BeforeMethod
    public void launchBrowser(){
       ChromeOptions  options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       navigateToPage();
    }*/
@BeforeMethod
@Parameters({"BaseURL"})
public void launchBrowser(String baseURL) {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    navigateToPage(baseURL);
}

@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void clickLoginBtn() {
        WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void provideEmail(String email) {
        WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /*public void navigateToPage() {
        driver.get(url);
    }*/



    }