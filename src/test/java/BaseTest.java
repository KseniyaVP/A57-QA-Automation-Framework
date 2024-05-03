import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {



    public WebDriver driver;

    public WebDriverWait wait;
   // public String url="https://qa.koel.app/";
    @DataProvider(name ="NegativeLoginTestData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail","invalid"},
                {"k.potsina@testpro.io","testproA57*"},
                {"kseniya.potsina@testpro.io","invalid"},
                {" ", " "}
        };
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
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    navigateToPage(baseURL);
}

@AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void clickLoginBtn() {
        //WebElement loginBtn= driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void provideEmail(String email) {
       //WebElement emailField= driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);

    }

    public void providePassword(String password) {
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    /*public void navigateToPage() {
        driver.get(url);
    }*/
    public void navigateToPage(String url) {
        driver.get(url);
    }
}