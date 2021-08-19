package pages;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    private By HOME_PAGE = By.xpath("//*[@id=\"p-logo\"]/a");
    private By LOG_IN_BUTTON = By.xpath("//*[@id=\"pt-login\"]/a");
    private By SHOW_LIST = By.xpath("//*[@id=\"p-navigation\"]/div/ul");

    public boolean isLoginButtonVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOG_IN_BUTTON));
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void goToLoginPage() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

   /* public boolean addShowList() {
        WebElement showList = driver.findElement(SHOW_LIST);
        List<WebElement> elements = new ArrayList<>();
        elements = showList.findElements(By.xpath("./li"));
        if (elements.size()!= 0) return true;
        else return false;
    } */
    public MainPage(WebDriver webDriver) {
        this.driver = driver;
    }

}
