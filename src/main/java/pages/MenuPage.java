package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuPage {
    private final WebDriver driver;
    private final String URL = "https://www.wikipedia.org/";
    private final By ENGLISH_BUTTON = By.id("js-link-box-en");
    private final By MAINPAGE_BUTTON = By.id("n-mainpage-description");
    private final By CONTENTS_BUTTON = By.id("n-contents");
    private final By CURRENT_EVENTS_BUTTON = By.id("n-currentevents");
    private final By RANDOM_PAGE_BUTTON = By.id("n-randompage");
    private final By ABOUT_SITE_BUTTON = By.id("n-aboutsite");
    private final By CONTACT_PAGE_BUTTON = By.id("n-contactpage");
    private final By SITE_SUPPORT_BUTTON = By.id("n-sitesupport");


    public MenuPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void goToWikiPedia() {
        driver.get(URL);
    }
    public MainPage ClickEnglishButton() {
        driver.findElement(ENGLISH_BUTTON).click();
        return new MainPage(driver);
    }

}

