import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTest extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        //login to koel
        provideEmail("kseniya.potsina@testpro.io");
        providePassword("testproA57*");
        clickLoginBtn();
        //click on avatar icon to navigate to profile
        clickOnAvatarIcon();
        // generate random name
        String randomName = generateRandomName();
        System.out.println("Random name is: "+randomName);
        //current password
        provideCurrentPassword("testproA57*");
        //provide new generated name
        provideProfileName(randomName);
        //click on save button
        clickOnSaveBtn();
        Thread.sleep(2000);
        //assertions (actual vs expected)
        WebElement actualProfileName=driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(),randomName);



    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        avatarIcon.click();
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideCurrentPassword(String currentPassword){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("input[name='current_password']"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public void provideProfileName(String newProfileName){
        WebElement profileName= driver.findElement(By.cssSelector("input[id='inputProfileName']"));
        profileName.clear();
        profileName.sendKeys(newProfileName);
    }
    public void clickOnSaveBtn(){
        WebElement saveBtn =driver.findElement(By.cssSelector("button.btn-submit"));
        saveBtn.click();

    }
}
