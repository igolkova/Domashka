package lesson25Domashka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By catalog = By.xpath("//button[@class= 'menu-toggler']");
    By sideNotebook = By.xpath("//fat-menu//a[@href = 'https://rozetka.com.ua/computers-notebooks/c80253/']");
    By cart = By.xpath("//li[@class= 'header-actions__item header-actions__item_type_cart']");
    By counter = By.xpath("//span[@class = 'header-actions__button-counter']");
    By cartTitle = By.xpath("//a[@class = 'cart-product__title']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        String title = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        if (!title.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the mail page");
        }
    }

    public MainPageLogic openCatalog() {
        wait.until(ExpectedConditions.elementToBeClickable(catalog));
        driver.findElement(catalog).click();
        return this;
    }

    public MainPageLogic clickNotebookSidebar() {
        wait.until(ExpectedConditions.elementToBeClickable(sideNotebook));
        driver.findElement(sideNotebook).click();
        return this;
    }

    public String getCartCounter () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(counter));
        String cartCount = driver.findElement(counter).getText();
        return cartCount;
    }

    public MainPageLogic clickCartButton () {
        driver.findElement(cart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTitle));
        return this;
    }

    public String getTitleInCart () {
        String titleInCart = driver.findElement(cartTitle).getText();
        return titleInCart;
    }




}
