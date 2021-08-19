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
LogInPage loginPage;
protected String username = "AutiTest";
protected String password = "Codecool123";




    @BeforeEach
    public void setWebDriver() {
        driver.get("https://www.wikipedia.org/");
        driverUtil = new DriverUtil();
        driver = driverUtil.GetWebDriver();
    }

    @Test
    public void logInValid() {
        menuPage.ClickEnglishButton();
        mainPage.goToLoginPage();
        loginPage.typeUserName(username);
        loginPage.typePassword(password);
        loginPage.clickLogIn();

    }


    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

