package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import util.DriverUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class WikipediaTests {
private WebDriver driver;
private DriverUtil driverUtil;
MenuPage menuPage;
MainPage mainPage;
LoggedInPage loggedInPage;
McDonaldsPage mcDonalds;
TalkPage talkPage;
UserPage userPage;
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
    public void logInValidTest() {
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
    public void logInInValidTest() {
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
    public void logOutTest() {
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

    @Test
    public void PrivacyPolicyTest() {
        loggedInPage = new LoggedInPage(getDriver());
        menuPage = new MenuPage(getDriver());
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogIn();
        loggedInPage.privacyPolicy();
        assertTrue(loggedInPage.isDisplayedPrivacyPolicy());
    }

    @Test
    public void addShowListTest() {
        loggedInPage = new LoggedInPage(getDriver());
        menuPage = new MenuPage(getDriver());
        mcDonalds = new McDonaldsPage(getDriver());
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogIn();
        mainPage.goToMcDonaldsPage("McDonalds");
        mcDonalds.addShowList();

        List<String> result = mcDonalds.addShowList();
        List<String> expected = new ArrayList<>();
        expected.add("Year Revenue\n" +
                "in mil. USD$ Net income\n" +
                "in mil. USD$ Total assets\n" +
                "in mil. USD$ Price per share\n" +
                "in USD$ Locations[40] Employees Ref.");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void newPage() {
        loggedInPage = new LoggedInPage(getDriver());
        menuPage = new MenuPage(getDriver());
        userPage = new UserPage(getDriver());
        talkPage = new TalkPage(getDriver());
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogIn();
        mainPage.goToUserPage();
        userPage.goToTalkPage();
        talkPage.goToNewSection();
        talkPage.writeHeadLine();
        talkPage.writeTextBox();
        talkPage.publishPage();
    }


    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

