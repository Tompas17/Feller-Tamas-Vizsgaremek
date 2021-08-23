package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuPage {
    private final WebDriver driver;
    private final By ENGLISH_BUTTON = By.id("js-link-box-en");


    public MenuPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void goToWikiPedia() {
        String URL = "https://www.wikipedia.org/";
        driver.get(URL);
    }
    public MainPage ClickEnglishButton() {
        driver.findElement(ENGLISH_BUTTON).click();
        return new MainPage(driver);
    }

}

