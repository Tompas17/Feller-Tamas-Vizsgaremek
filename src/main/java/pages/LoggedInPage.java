package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedInPage {

     WebDriver driver;
     //private String URL = "https://en.wikipedia.org/wiki/Main_Page";
     private By LOG_OUT = By.xpath("//*[@id=\"pt-logout\"]/a");
    private By LOG_IN_TEXT = By.xpath("//*[@id=\"pt-login\"]/a");


     public LoggedInPage(WebDriver driver) {
         this.driver = driver;
     }

    public void logOut() {
        driver.findElement(LOG_OUT).click();
    }
    public String loggingOut(){

        String actual = driver.findElement(LOG_IN_TEXT).getText();
        return actual;
    }
}
