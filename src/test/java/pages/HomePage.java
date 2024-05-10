package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Web Elements

    By userAvatarIcon = By.cssSelector("img[class='avatar']");
    By playlistElement = By.cssSelector("li.playlist:nth-child(6)");
    By playlistInputField =By.cssSelector("[name='name']");

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










}
