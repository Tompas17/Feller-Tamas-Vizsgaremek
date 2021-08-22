package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class McDonaldsPage {
    WebDriver driver;
    private By TABLE = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]");
    private By TABLE_HEADER = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[1]");

    public McDonaldsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> addShowList() {
        driver.findElement(TABLE);
        List<String> result = new ArrayList<>();
        List<WebElement> datas = new ArrayList<>();
        datas = driver.findElements(TABLE_HEADER);
        for (int i = 0; i < datas.size(); i ++){
            result.add(((datas.get(i)).getText()));
        }
        return result;
    }
}
