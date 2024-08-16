import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {
    String newPlaylistName = "QuickName Edited";


    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistSuccessMsg = "Updated playlist \"QuickName Edited.\"";

        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();

        doubleClickPlaylist();
        enterNewPlaylistName();

        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);

    }
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist:nth-child(4)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName( ) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    /*@Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Homework19.\"";

        //navigate to Koel
        //login with credentials
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();

        //select playlist to delete
        clickHomework19Playlist();
        //click red X playlist button
        clickXPlaylistBtn();

        //Assertion
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg);

    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class ='success show']")));
        return notificationMsg.getText();
    }

    public void clickXPlaylistBtn() {
        WebElement XPlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        XPlaylistBtn.click();
    }

    public void clickHomework19Playlist() {
        WebElement Homework19Playlist = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[4]/a"));
        Homework19Playlist.click();} */
    /*@Test
    public void deletePlaylist(){

        String expectedPlaylistDeletedMsg = "Deleted playlist \"Homework19.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickHomework19Playlist()
                .clickDeletePlaylistBtn();

        Assert.assertEquals(homePage.getDeletedPlaylistSuccessMsg(), expectedPlaylistDeletedMsg);}*/
}
