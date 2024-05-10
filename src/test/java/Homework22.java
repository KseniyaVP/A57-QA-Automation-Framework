import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework22 extends BaseTest {


    @Test
    public void renamePlaylist() {
        String newPlaylistName = "QuickName Edited";
        String updatedPlaylistSuccessMsg = "Updated playlist \"QuickName Edited.\"";


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);

    }



}
