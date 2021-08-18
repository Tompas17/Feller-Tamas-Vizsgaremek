package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
    private WebDriver driver;

    private final By ENGLISH_BUTTON = By.id("js-link-box-en");

    public MenuPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public MainPage ClickEnglishButton() {
        WebElement englishButton = driver.findElement(ENGLISH_BUTTON);
        englishButton.click();

        MainPage page = new MainPage(driver);
        return page;
    }
}

