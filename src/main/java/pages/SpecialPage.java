package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class SpecialPage {
    WebDriver driver;

    private final By FIVE_HUNDRED_BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[6]");
    private final By NEXT_BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[1]");
    private final By MORE_BUTTON = By.xpath("//*[@id='mw-content-text']/div[3]/p[2]/a[2]");
    private final By TITLE = By.xpath("//*[@id='mw-content-text']/div[3]/ul/li");
    private final By EVERYL_TITLE = By.xpath(".//a");
    private final By FIRSTCONTROL = By.xpath("//*[@id=\"mw-content-text\"]/div[3]/ul");



    public SpecialPage(WebDriver driver) {
        this.driver = driver;

    }



    public void clickOn500Button()
    {

        driver.findElement(FIVE_HUNDRED_BUTTON).click();
    }

    public void clickNextButton(){

        driver.findElement(NEXT_BUTTON).click();
    }

    public void morePagesLists() {


        List<WebElement> title;


        WebDriverWait wait = new WebDriverWait(driver, 5);


        int l = 0;
        while( driver.findElement(MORE_BUTTON).isDisplayed() && l <= 2 ) {
            l++;
            title = driver.findElements(TITLE);
            for (WebElement webElement : title) {
                WebElement link = webElement.findElement(EVERYL_TITLE);
                System.out.println(link.getText());
            }

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(MORE_BUTTON));
                driver.findElement(MORE_BUTTON).click();
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();

            }

        }
    }
    public boolean firstWord(){
        return driver.findElement(FIRSTCONTROL).getText().contains("vitamin");
    }

    public boolean secondWord() {
        return driver.findElement(FIRSTCONTROL).getText().contains("types");
    }


}