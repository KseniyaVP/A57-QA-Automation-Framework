import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

 /*   @Test
    public void loginEmptyEmailPassword() {

        provideEmail(" ");
        providePassword(" ");
        clickLoginBtn();
        String url = "//https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
      //  driver.quit();
    }*/
@Test
    public void loginValidEmailPassword() throws InterruptedException {

        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();


        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());

    }
     ///login Valid email Test using the Page Object Model
@Test
    public void loginValidEmailValidPasswordTest(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.provideEmail("kseniya.potsina@testpro.io");
    loginPage.providePassword("testproA57*");
    loginPage.clickSubmit();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
}

 /*   @Test()
    public void loginInvalidEmailPassword() throws InterruptedException{
                    //Steps
        provideEmail("k.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        Thread.sleep(2000);//Open browser

        String url = "//https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),url);

    }*/
/*@Test

    public void loginValidEmailInvalidPassword() throws InterruptedException{

    provideEmail("kseniya.potsina@testpro.io");
    providePassword("testproA");
    clickLoginBtn();
    Thread.sleep(2000);//Open browser
    String url = "//https://qa.koel.app/";

       Assert.assertEquals(driver.getCurrentUrl(),url);

   }*/
    //NegativeLoginTestData

    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();


        String url = "//https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), url);
        System.out.println("Just Testing console");

    }


}
