import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {

    String newPlaylistName = "QuickName Edited";


    @Test
    public void renamePlaylist()  {

      String updatedPlaylistSuccessMsg = "Updated playlist \"QuickName Edited.\"";

      provideEmail("kseniya.potsina@testpro.io");
      providePassword("testproA57*");
      clickLoginBtn();

      doubleClickPlaylist();
      enterNewPlaylistName();

      Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistSuccessMsg);

    }
    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playlist:nth-child(6)")));
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
}
