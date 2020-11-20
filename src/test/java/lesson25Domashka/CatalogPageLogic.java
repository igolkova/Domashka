package lesson25Domashka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPageLogic {

    By secLaptop = By.xpath("//rz-widget-list//a[@href='https://rozetka.com.ua/notebooks/c80004/'][@class = 'tile-cats__heading tile-cats__heading_type_center']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CatalogPageLogic (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public CatalogPageLogic clickCatSectionNotebook() {
        wait.until(ExpectedConditions.elementToBeClickable(secLaptop));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(secLaptop).click();
        return this;
    }
}
