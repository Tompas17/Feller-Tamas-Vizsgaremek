package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage {

    private WebDriver driver;
    private By USER_NAME_INPUT = By.id("wpName1");
    private By PASSWORD_INPUT = By.id("wpPassword1");
    private By LOG_IN = By.id("wpLoginAttempt");
    private By POP_UP = By.xpath("//*[@id=\"mw-gettingstarted-cta-other-page\"]/a[1]");

    public void typeUserName(String username) {
        driver.findElement(USER_NAME_INPUT).click();
        driver.findElement(USER_NAME_INPUT).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(USER_NAME_INPUT).sendKeys(password);
    }

    public void clickLogIn () {
        driver.findElement(LOG_IN).click();
    }



    public LogInPage(WebDriver driver) {
    this.driver = driver;
    }
}