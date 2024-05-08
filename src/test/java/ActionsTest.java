import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsTest extends BaseTest {

   // Contextual Click
     @Test
    public void playSong() throws InterruptedException{

           //Background steps
       provideEmail("kseniya.potsina@testpro.io");
       providePassword("testproA57*");
       clickLoginBtn();
           //Choose All Songs
        chooseAllSongsList();
           //Contextual Click on first song
         contextClickFirstSong();
           //Click on Play from menu
         choosePlayOption();
         Assert.assertTrue(isPlaying());
     }

     public void  chooseAllSongsList(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
     }
     public void contextClickFirstSong() throws InterruptedException{
         WebElement firstSongElement = wait. until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
         actions.contextClick(firstSongElement).perform();
     }

     public void choosePlayOption(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
     }
     public boolean isPlaying(){
         WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
         return  soundBarVisualizer.isDisplayed();
     }
     /////////////////////////////////////////////////////
         // Mouse hover
    //@Test
    public void hoverOverPlayBtn(){
         provideEmail("kseniya.potsina@testpro.io");
         providePassword("testproA57*");
         clickLoginBtn();
          //hover and verify play
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay(){
         WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
         actions.moveToElement(play).perform();
         return  wait.until(ExpectedConditions.visibilityOf(play));
    }

    ////////////////////////////////////////////////////////////////
       ////WebElements

   /* @Test
    public void countSongsInPlaylist(){
      provideEmail("kseniya.potsina@testpro.io");
      providePassword("testproA57*");
      clickLoginBtn();
      choosePlaylistByName("Playlist Demo");
      displayAllSongs();
      Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
    }
  public void choosePlaylistByName( String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text().'" + playlistName + "')]"))).click();
  }

  public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));

        System.out.println("Number of Songs in the playlist: "+countSongs());
        for(WebElement e : songList){
            System.out.println(e.getText());
        }
  }
 public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
 }

 public String getPlaylistDetails() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
 } */

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /*    ///Double Click
    String newPlayListName = "Sample Edited Playlist";
    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \""+newPlayListName+".\"";
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();

        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);

    }

    public void doubleClickPlaylist(){
       WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(7)")));
       actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlayListName);
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    } */

}
