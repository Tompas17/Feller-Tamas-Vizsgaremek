package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import util.DriverUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
protected String firstText = "This is the header";
protected String secondText = "This is the text";
protected String thirdText = "This is the new text";

public WebDriver getDriver() {
    return driver;
}




    @BeforeEach
    public void setWebDriver() {
        driverUtil = new DriverUtil();
        driver = driverUtil.GetWebDriver();

        //this.driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    @DisplayName("TC-1, Log in with valid datas.")
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
    @DisplayName("TC-2, Log in with invalid datas.")
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
    @DisplayName("TC-3, Log out.")
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
    @DisplayName("TC-4, Privacy and policy.")
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
    @DisplayName("TC-5, Listing data from a table.")
    public void dataListTest() {
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
        mcDonalds.dataList();

        String result = mcDonalds.dataList();
        String expected = "Year Revenue\n" +
                "in mil. USD$ Net income\n" +
                "in mil. USD$ Total assets\n" +
                "in mil. USD$ Price per share\n" +
                "in USD$ Locations[40] Employees Ref.";



        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-6, Data entry.")
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
        talkPage.writeHeadLine(firstText);
        talkPage.writeTextBox(secondText);
        talkPage.publishPage();
    }

    @Test
    @DisplayName("TC-7, Data edit.")
    public void editPage() {
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
        talkPage.EDIT_SOURCE();
        talkPage.EDIT_TEXTBOX(thirdText);
        talkPage.publishPage();

    }

    @Test
    @DisplayName("TC-8, Data delete.")
    public void deletePage() {
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
        talkPage.EDIT_SOURCE();
        talkPage.DELETE_TEXTBOX();
    }

    @Test
    @DisplayName("TC-9, Save data to file.")
    public void writeToFile() {
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
        mcDonalds.TableContent();

        List<String> result = mcDonalds.TableContent();
        List<String> expected = new ArrayList<>();
        //expected.add("19,117, 20,895, 22,787, 23,522, 22,745, 24,075, 27,006, 27,567, 28,106, 27,441, 25,413, 24,622, 22,820, 21,025, 21,077");
        expected.add("19,117");
        expected.add("20,895");
        expected.add("22,787");
        expected.add("23,522");
        expected.add("22,745");
        expected.add("24,075");
        expected.add("27,006");
        expected.add("27,567");
        expected.add("28,106");
        expected.add("27,441");
        expected.add("25,413");
        expected.add("24,622");
        expected.add("22,820");
        expected.add("21,025");
        expected.add("21,077");

        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-10, Write data from file.")
    public void writeFromFile() throws FileNotFoundException {
        loggedInPage = new LoggedInPage(getDriver());
        menuPage = new MenuPage(getDriver());
        userPage = new UserPage(getDriver());
        talkPage = new TalkPage(getDriver());
        String[] newText = talkPage.writeFromFile();
        menuPage.goToWikiPedia();
        mainPage = menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        mainPage.typeUserName(username);
        mainPage.typePassword(password);
        mainPage.clickLogIn();
        mainPage.goToUserPage();
        userPage.goToTalkPage();
        talkPage.goToNewSection();
        for (int i = 0; i < 6; i++) {
            talkPage.writeTextBox(newText[i]);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        talkPage.publishPage();

        List<String> result = Arrays.asList(talkPage.writeFromFile());
        List<String> expected = new ArrayList<>();
        expected.add("This\n" +
                ", is\n" +
                ", the\n" +
                ", best\n" +
                ", page\n" +
                ", ever.\n");
        Assertions.assertEquals(expected, result);
}




    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

