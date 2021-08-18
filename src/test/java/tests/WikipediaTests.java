package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import util.DriverUtil;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class WikipediaTests {
private WebDriver webDriver;
private DriverUtil driverUtil;
private MainPage homePage;




    @BeforeEach
    public void setWebDriver() {
        driverUtil = new DriverUtil();
        webDriver = driverUtil.getWebDriver();
    }

    @Test
    public void goHomePageTest() {
        homePage = new MainPage(webDriver);
        assertTrue(homePage.goToHomePage());
    }

    @Test
    public void addShowListTest() {
        homePage = new MainPage(webDriver);
        homePage.goToHomePage();
        assertTrue( homePage.addShowList());

    }

    @AfterEach
    public void quitWebDriver() {
        webDriver.quit();
    }
}

