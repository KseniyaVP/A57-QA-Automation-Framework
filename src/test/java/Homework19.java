import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Homework19.\"";

        //navigate to Koel
        //login with credentials
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        Thread.sleep(2000);

        //select playlist to delete
        clickHomework19Playlist();
        //click red X playlist button
        clickXPlaylistBtn();
        Thread.sleep(2000);

        //Assertion
        Assert.assertEquals(getDeletedPlaylistMsg(),expectedPlaylistDeletedMsg);

    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement(By.cssSelector("div[class ='success show']"));
        return notificationMsg.getText();
    }

    public void clickXPlaylistBtn() {
        WebElement XPlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        XPlaylistBtn.click();
    }

    public void clickHomework19Playlist() {
        WebElement Homework19Playlist = driver.findElement(By.xpath("//section[@id='playlists']/ul/li[4]/a"));
        Homework19Playlist.click();
    }
}
