import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Homework20.\"";

        //navigate to Koel
        //login with credentials
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        //select playlist to delete
        clickHomework20Playlist();
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
        WebElement XPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        XPlaylistBtn.click();
    }

    public void clickHomework20Playlist() {
        WebElement Homework20Playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']/ul/li[5]/a")));
        Homework20Playlist.click();
    }
}

