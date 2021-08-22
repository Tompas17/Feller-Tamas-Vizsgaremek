package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPage {

    WebDriver driver;
    //private String URL = "https://en.wikipedia.org/wiki/Main_Page";
    private By LOG_OUT = By.xpath("//*[@id=\"pt-logout\"]/a");
    private By LOG_IN_TEXT = By.xpath("//*[@id=\"pt-login\"]/a");
    private By PRIVACY_POLICY = By.xpath("//*[@id='footer-places-privacy']/a");
    private By PRIVACY_POLICY_LOGO = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/div[3]/div/div[2]/a/img");


    public LoggedInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() {
        driver.findElement(LOG_OUT).click();
    }

    public String loggingOut() {

        String actual = driver.findElement(LOG_IN_TEXT).getText();
        return actual;
    }

    public void privacyPolicy() {
        driver.findElement(PRIVACY_POLICY).click();
    }

    public boolean isDisplayedPrivacyPolicy() {
        WebElement logo = driver.findElement(PRIVACY_POLICY_LOGO);
        if (logo.isDisplayed()) return true;
        else return false;
    }
}
