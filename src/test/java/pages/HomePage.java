package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Web Elements

    private By userAvatarIcon = By.cssSelector("img[class='avatar']");
    private By playlistElement = By.cssSelector("li.playlist:nth-child(6)");
    private By playlistInputField =By.cssSelector("[name='name']");
    private By playNextSongBtn = By.cssSelector("i[data-testid='play-next-btn']");
    private By playBtn =By.cssSelector("span[class='play']");
    By soundBarVisualizer = By.cssSelector("img[alt='Sound bars']");

    By notification = By.cssSelector("div.success.show");


    //Helper methods

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public  void doubleClickPlaylist() {doubleClick(playlistElement); }

    public void enterNewPlaylistName(String newPlaylistName){
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(playlistInputField).sendKeys(newPlaylistName);
        findElement(playlistInputField).sendKeys(Keys.ENTER);}

    public String getRenamePlaylistSuccessMsg() {return findElement(notification).getText();}

    public void clickPlayNextSongBtn() {click(playNextSongBtn); }

    public void clickPlayBtn() {click(playBtn);}

    public WebElement isSongPlaying() {
        return findElement(soundBarVisualizer);
    }


    @FindBy(xpath = "//section[@id='playlists']/ul/li[4]/a")
    WebElement homework19Playlist;

    @FindBy(css = "button[class='del btn-delete-playlist']")
    WebElement deletePlaylistBtn;

    @FindBy(css="div[class ='success show']")
    WebElement notificationMsg;

    public HomePage clickHomework19Playlist(){
        homework19Playlist.click();
        return this;
    }
    public HomePage clickDeletePlaylistBtn(){
        deletePlaylistBtn.click();
        return this;
    }
    public  String getDeletedPlaylistSuccessMsg(){
        return notificationMsg.getText();
        }

}
