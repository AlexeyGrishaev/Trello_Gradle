package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver driver;
    EventFiringWebDriver driver;
    ChromeOptions options;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    private HelperUser helperUser;
    private HelperBoard helperBoard;
    private HelperProfile helperProfile;
    static String browser;


    public ApplicationManager(){
        browser=System.getProperty("browser",BrowserType.CHROME);
    }



    public void init() {
        if(browser.equals(BrowserType.FIREFOX)){
            FirefoxOptions options1 = new FirefoxOptions(   );
            options1.addArguments("intl._lenguages","en");
            driver = new EventFiringWebDriver(new FirefoxDriver(options1));
            logger.info("testing on FIREFOX");
        }else{
            options = new ChromeOptions();
            options.addArguments("--lang=en");
            driver = new EventFiringWebDriver(new ChromeDriver(options));
        }





        driver.manage().window().maximize();
        driver.navigate().to("https://trello.com/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        logger.info("start");
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
        helperProfile = new HelperProfile(driver);
        driver.register(new WDListener());
    }

    public HelperBoard getHelperBoard() {
        return helperBoard;
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperProfile getHelperProfile() {
        return helperProfile;
    }

    public void stop() {
//        if(driver!=null){
//            driver.quit();
//        }
    }
}
