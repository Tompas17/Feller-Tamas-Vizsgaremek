package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.DriverUtil;


public class WikipediaTests {
private WebDriver driver;
private DriverUtil driverUtil;
MenuPage menuPage;
MainPage mainPage;
protected String username = "AutiTest";
protected String password = "Codecool123";

public WebDriver getDriver() {
    return driver;
}




    @BeforeEach
    public void setWebDriver() {
        driverUtil = new DriverUtil();
        driver = driverUtil.GetWebDriver();
    }

    @Test
    public void logInValid() {
        menuPage = new MenuPage(getDriver());
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogIn();

    }


    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

