package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    private WebDriver driver;
    private final String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private By HOME_PAGE = By.xpath("//*[@id=\"p-logo\"]/a");
    private By LOG_IN_BUTTON = By.xpath("//*[@id=\"pt-login\"]/a");
    private By SHOW_LIST = By.xpath("//*[@id=\"p-navigation\"]/div/ul");
    private By USER_NAME_INPUT = By.id("wpName1");
    private By PASSWORD_INPUT = By.id("wpPassword1");
    private By LOG_IN = By.id("wpLoginAttempt");
    private By POP_UP = By.xpath("//*[@id=\"mw-gettingstarted-cta-other-page\"]/a[1]");
    private By ERROR = By.xpath("//*[@id=\"userloginForm\"]/form/div[1]");
    private By LOG_OUT = By.xpath("//*[@id=\"pt-logout\"]/a");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void goToLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

    public void typeUserName(String username) {
        driver.findElement(USER_NAME_INPUT).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLogIn () {
        driver.findElement(LOG_IN).click();
    }

    public boolean isLoggedIn() {
        WebElement logOut = driver.findElement(LOG_OUT);
        if (logOut.isDisplayed()) return true;
        else return false;
    }
    public boolean inValidLog() {
        WebElement error = driver.findElement(ERROR);
        if (error.isDisplayed()) return true;
        else return false;
    }
}
