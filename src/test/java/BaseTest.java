import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public WebDriver driver;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public WebDriverWait wait;

    public Actions actions;


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
    public void launchBrowser(String baseURL) throws MalformedURLException {
    /*ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    wait =new WebDriverWait(driver, Duration.ofSeconds(10));*/
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        navigateToPage(baseURL);
    }

   /* @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }*/
    @AfterMethod
    public void tearDown(){
       threadDriver.get().close();
       threadDriver.remove();
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
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void navigateToPage(String url) {
        //driver.get(url);}
        getDriver().get(url);
    }

    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.0.17:4444.";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();

            //Grid Cases
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);

        }
    }
  public WebDriver lambdaTest() throws MalformedURLException {
        String hubUrl = "@hub.lambdatest.com/wd/hub";
        String userName = "kseniya.potsina";
        String accessKey ="V8twjq05BFwj0Q1KHgLr0H9UP1Kr5sPcsm3MYNiE1WrixOdYco";
        //Capabilities
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("browserName", "chrome");

      /*ChromeOptions browserOptions = new ChromeOptions();
      browserOptions.setPlatformName("Windows 11");
      browserOptions.setBrowserVersion("126.0");*/
      HashMap<String, Object> ltOptions= new HashMap<String, Object>();
      ltOptions.put("username","kseniya.potsina");
      ltOptions.put("accessKey", "V8twjq05BFwj0Q1KHgLr0H9UP1Kr5sPcsm3MYNiE1WrixOdYco");
      ltOptions.put("build", "TEST");
      ltOptions.put("project", "Koel cloud");
      ltOptions.put("w3c", true);
      ltOptions.put("plugin", "java-java");
      //browserOptions.setCapability("LT:Options", ltOptions);
      capabilities.setCapability("LT:Options", ltOptions);
      return driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + hubUrl), capabilities);
  }

}