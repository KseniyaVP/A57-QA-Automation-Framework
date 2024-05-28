import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;

    public WebDriverWait wait;

     public Actions actions;


    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
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
public void launchBrowser (String baseURL) throws MalformedURLException {
    //ChromeOptions options = new ChromeOptions();
    //options.addArguments("--remote-allow-origins=*");
    //driver = new ChromeDriver(options);
    //driver = new FirefoxDriver();
    driver = pickBrowser(System.getProperty("browser"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    wait =new WebDriverWait(driver, Duration.ofSeconds(10));
    navigateToPage(baseURL);}

@AfterMethod
    public void closeBrowser(){
    driver.quit();
    }

    public static WebDriver pickBrowser ( String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.17:4444";
       switch (browser){
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
              return driver = new FirefoxDriver();
           case "MicrosoftEdge":
               WebDriverManager.edgedriver().setup();
               EdgeOptions edgeOptions = new EdgeOptions();
               edgeOptions.addArguments("--remote-allow-origins=*");
               return driver = new EdgeDriver();

           /////Grid cases////////
           case"grid-edge":
               caps.setCapability("browserName", "MicrosoftEdge");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
           case"grid-firefox":
               caps.setCapability("browserName", "firefox");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
           case"grid-chrome":
               caps.setCapability("browserName", "chrome");
               return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

           default:
               WebDriverManager.chromedriver().setup();
               ChromeOptions chromeOptions = new ChromeOptions();
               chromeOptions.addArguments("--remote-allow-origins=*");
               return driver = new ChromeDriver(chromeOptions);
       }
    }

    ////////////old methods//////////////////////////////////////////////////////////////////////////////////////

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
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void navigateToPage(String url) {
        driver.get(url);}

    }