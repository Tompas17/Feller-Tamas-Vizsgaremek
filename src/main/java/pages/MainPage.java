package pages;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver webDriver;
    private String url = "https://en.wikipedia.org/wiki/Main_Page";
    private By HOME_PAGE = By.xpath("//*[@id=\"p-logo\"]/a");
    private By SHOW_LIST = By.xpath("//*[@id=\"p-navigation\"]/div/ul");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean goToHomePage() {
        webDriver.get(url);
        WebElement homePage = webDriver.findElement(HOME_PAGE);
        if (homePage.isDisplayed()) return true;
        else return false;
    }

    public boolean addShowList() {
        WebElement showList = webDriver.findElement(SHOW_LIST);
        List<WebElement> elements = new ArrayList<>();
        elements = showList.findElements(By.xpath("./li"));
        if (elements.size()!= 0) return true;
        else return false;
    }


}
