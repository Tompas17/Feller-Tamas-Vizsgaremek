package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.DriverUtil;

import static org.junit.Assert.assertTrue;


public class WikipediaTests {
private WebDriver driver;
private DriverUtil driverUtil;
MenuPage menuPage;
MainPage mainPage;
LoggedInPage loggedInPage;
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
        assertTrue(mainPage.isLoggedIn());

    }

    @Test
    public void logInInValid() {
        menuPage = new MenuPage(getDriver());
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName("123");
        mainPage.typePassword("123");
        mainPage.clickLogIn();
        assertTrue(mainPage.inValidLog());
}

    @Test
    public void logOut() {
    loggedInPage = new LoggedInPage(getDriver());
    menuPage = new MenuPage(getDriver());
    menuPage.goToWikiPedia();
    mainPage = menuPage.ClickEnglishButton();
    mainPage.goToLoginPage();
    mainPage.typeUserName(username);
    mainPage.typePassword(password);
    mainPage.clickLogIn();
    loggedInPage.logOut();



        String expected = "Log in";
        Assertions.assertEquals(expected, loggedInPage.loggingOut());
    }


    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

