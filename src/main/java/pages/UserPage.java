package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
    private WebDriver driver;
    private final By TALK_BUTTON = By.xpath("//*[@id=\"ca-talk\"]/a");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToTalkPage() {
        driver.findElement(TALK_BUTTON).click();
    }
}
