package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperProfile extends HelperBase {
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By btnProfile = By.xpath("//span[@class='DweEFaF5owOe02 S7RWiPL9Qgl9P9 kFZ3hS99jGmKWk']");
    By btnManageAccount = By.xpath("//a[@data-testid='manage-account-link']");
    By btnProfilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");
    By btnChangeAvatar = By.xpath("//button[@data-testid='change-avatar']");
    By btnUploadPhoto = By.xpath("//input[@id='image-input']");
    By btnUploadSubmit= By.xpath("//button[@class='css-13t386j css-nyid0a']");

    public void changeAvatar(String fileName) {
        //PHOTOS_PATH
        clickBaseWait(btnProfile, 3);
        clickBaseWait(btnManageAccount, 3);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(btnProfilePhoto)).perform();
        clickBaseWait(btnProfilePhoto, 3);
        clickBaseWait(btnChangeAvatar,3);
        File file = new File(PHOTOS_PATH+fileName);
        String path = file.getAbsolutePath();
        driver.findElement(btnUploadPhoto).sendKeys(path);
        clickBaseWait(btnUploadSubmit,3);
    }
}
