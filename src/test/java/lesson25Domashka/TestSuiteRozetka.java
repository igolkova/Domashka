package lesson25Domashka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class TestSuiteRozetka {
    WebDriver driver;
    WebDriverWait ExplicitWait;
    Assertion assertion = new Assertion();

    @BeforeMethod
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\IdeaProjects\\testprojectmaven\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExplicitWait = new WebDriverWait(driver, 60);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void test() {
        MainPageLogic mainPageLogic = new MainPageLogic(driver, ExplicitWait);
        CategoryPageLogic categoryPageLogic = new CategoryPageLogic(driver, ExplicitWait);

        mainPageLogic.openCatalog().clickNotebookSidebar();

        new CatalogPageLogic(driver, ExplicitWait).clickCatSectionNotebook();

        String firstTitle = categoryPageLogic.getFirstItemTitle();
        categoryPageLogic.clickFirstItem();

        String cartCounter = mainPageLogic.getCartCounter();
        assertion.assertEquals(cartCounter, "1", "Некорректное значение в count");

        mainPageLogic.clickCartButton();

        String cartTitle = mainPageLogic.getTitleInCart();
        assertion.assertEquals(cartTitle, firstTitle, "В корзине другой товар");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
