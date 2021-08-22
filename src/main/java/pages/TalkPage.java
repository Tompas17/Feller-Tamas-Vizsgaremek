package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TalkPage {

    private WebDriver driver;
    private final By NEW_SECTION = By.id("ca-addsection");
    private final By HEADLINE = By.id("wpSummary");
    private final By TEXT_BOX = By.id("wpTextbox");
    private final By PUBLISH_PAGE_BUTTON = By.id("wpSave");
    private final By EDIT_SOURCE = By.id("ca-edit");

    public TalkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToNewSection() {
        driver.findElement(NEW_SECTION).click();
    }

    public void writeHeadLine() {
        driver.findElement(HEADLINE).sendKeys("Hi,this is my new page!");
    }
    public void writeTextBox() {
        driver.findElement(TEXT_BOX).sendKeys("Is it good?");
    }
    public void publishPage() {
        driver.findElement(PUBLISH_PAGE_BUTTON).click();
    }
    public void EDIT_SOURCE() {
        driver.findElement(EDIT_SOURCE).click();
    }
    public void EDIT_TEXTBOX() {
        driver.findElement(TEXT_BOX).clear();
        driver.findElement(TEXT_BOX).sendKeys("Is it cool Bro?");
    }



}
