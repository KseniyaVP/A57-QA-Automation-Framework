import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

 @Test
 public void playSong() throws InterruptedException {
     //navigate to page and log in with credentials
     provideEmail("kseniya.potsina@testpro.io");
     providePassword("testproA57*");
     clickLoginBtn();
     Thread.sleep(2000);
     //click play next song
     clickPlayNextSongBtn();
     //click play button
     clickPlayBtn();
     Thread.sleep(2000);
     //validate that a song is playing
     WebElement soundBar = driver.findElement(By.cssSelector("img[alt='Sound bars']"));
     Assert.assertTrue(soundBar.isDisplayed());

     driver.quit();
 }

 public void clickPlayNextSongBtn(){
     WebElement playNextSongBtn=driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
     playNextSongBtn.click();
 }

 public void clickPlayBtn(){
     WebElement playBtn = driver.findElement(By.cssSelector("span[class='play']"));
     playBtn.click();
 }
}
