package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TalkPage {

    private final WebDriver driver;
    private final By NEW_SECTION = By.id("ca-addsection");
    private final By HEADLINE = By.id("wpSummary");
    private final By TEXT_BOX = By.xpath("//*[@id=\"wpTextbox1\"]");
    private final By PUBLISH_PAGE_BUTTON = By.id("wpSave");
    private final By EDIT_SOURCE = By.id("ca-edit");

    public TalkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToNewSection() {
        driver.findElement(NEW_SECTION).click();
    }

    public void writeHeadLine(String firstText) {
        driver.findElement(HEADLINE).sendKeys(firstText);
    }
    public void writeTextBox(String secondText) {
        driver.findElement(TEXT_BOX).sendKeys(secondText);
    }
    public void publishPage() {
        driver.findElement(PUBLISH_PAGE_BUTTON).click();
    }
    public void EDIT_SOURCE() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EDIT_SOURCE));
        driver.findElement(EDIT_SOURCE).click();
    }
    public void EDIT_TEXTBOX(String thirdText) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_BOX));



        driver.findElement(TEXT_BOX).clear();
        driver.findElement(TEXT_BOX).sendKeys(thirdText);
    }
    public void DELETE_TEXTBOX() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_BOX));
        driver.findElement(TEXT_BOX).clear();
        Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }


    public boolean isTextBoxDeleted() {
        driver.findElement(HEADLINE).getText();
        return true;
    }

    public boolean isTextBoxEdited() {
        try {
            driver.findElement(NEW_SECTION).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public boolean isTextBoxCreated() {
        try {
            driver.findElement(EDIT_SOURCE).isDisplayed();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public String[] writeFromFile() throws FileNotFoundException {
        String[] result = new String[6];
        try {
            File myOuterFile = new File("newtext.txt");
            Scanner scanner = new Scanner(myOuterFile);
            int i = 0;
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                result[i] = data + "\n";
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return result;
    }




}
