import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework23 extends BaseTest{

@Test
    public void deletePlaylist(){

        String expectedPlaylistDeletedMsg = "Deleted playlist \"Homework19.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickHomework19Playlist()
                .clickDeletePlaylistBtn();

        Assert.assertEquals(homePage.getDeletedPlaylistSuccessMsg(), expectedPlaylistDeletedMsg);

    }
}
