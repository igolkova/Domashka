package lesson25Domashka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPageLogic {

    By buyFirst = By.xpath("//li[@appgridtilelayout][1]//app-buy-button");
    By title = By.xpath("//li[@appgridtilelayout][1]//span[@class= 'goods-tile__title']");


    private final WebDriver driver;
    private final WebDriverWait wait;


    public CategoryPageLogic (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CategoryPageLogic clickFirstItem () {
        wait.until(ExpectedConditions.elementToBeClickable(buyFirst));
        driver.findElement(buyFirst).click();
        return this;
    }

    public String getFirstItemTitle () {
        String titleFirst = driver.findElement(title).getText();
        return titleFirst;
    }
}
