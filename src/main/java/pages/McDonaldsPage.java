package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class McDonaldsPage {
    WebDriver driver;
    private final By TABLE = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]");
    private final By TABLE_HEADER = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[1]");
    private final By INCOME = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr/td[2]");


    public McDonaldsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> dataList() {
        driver.findElement(TABLE);
        List<String> result = new ArrayList<>();
        List<WebElement> datas;
        datas = driver.findElements(TABLE_HEADER);
        for (WebElement data : datas) {
            result.add((data.getText()));
        }
        return result;
    }

    public List<String> TableContent() {
        List<WebElement> nameElements = driver.findElements(INCOME);
        List<String> result = new ArrayList<>();
        for (WebElement nameElement : nameElements) {
            result.add(nameElement.getText());
            try {
                FileWriter myWriter = new FileWriter("net income.txt", true);
                myWriter.append(nameElement.getText());
                myWriter.append("\n");
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

