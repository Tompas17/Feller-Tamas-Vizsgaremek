package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MainPage {
    private final WebDriver driver;
    private final By LOG_IN_BUTTON = By.xpath("//*[@id=\"pt-login\"]/a");
    private final By USER_NAME_INPUT = By.id("wpName1");
    private final By PASSWORD_INPUT = By.id("wpPassword1");
    private final By LOG_IN = By.id("wpLoginAttempt");
    private final By ERROR = By.xpath("//*[@id=\"userloginForm\"]/form/div[1]");
    private final By LOG_OUT = By.xpath("//*[@id=\"pt-logout\"]/a");
    private final By SEARCH_INPUT = By.xpath("//*[@id=\"searchInput\"]");
    private final By SEARCH_BUTTON = By.xpath("//*[@id=\"searchButton\"]");
    private final By USER_PAGE = By.xpath("//*[@id=\"pt-userpage\"]/a");


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

    public void clickLogIn() {
        driver.findElement(LOG_IN).click();
    }

    public boolean isLoggedIn() {
        WebElement logOut = driver.findElement(LOG_OUT);
        return logOut.isDisplayed();
    }

    public boolean inValidLog() {
        WebElement error = driver.findElement(ERROR);
        return error.isDisplayed();
    }

    public McDonaldsPage goToMcDonaldsPage(String page) {
        driver.findElement(SEARCH_INPUT).sendKeys("McDonalds");
        driver.findElement(SEARCH_BUTTON).click();
        return new McDonaldsPage(driver);
    }

    public void goToUserPage () {
        driver.findElement(USER_PAGE).click();
    }
}