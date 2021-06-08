package TestAllure;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;




public class TestAmazonFirefox {

    WebDriver driver; //if we use webdriver by donwload in resources and set up manually
    String url = "https://www.amazon.com";

    public void openBurgerMenu() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe"); //if we use webdriver by download in resources and set up manually (we dont need this if we use webdriver manager, also we don't need resources with driver)
        //WebDriverManager.firefoxdriver().setup(); // if we want to use webdriver manager
        driver = new FirefoxDriver(); //if we use webdriver by donwload in resources and set up manually
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
    }

    @Test
    public void checkGiftCards() {
        openBurgerMenu();
        int size = driver.findElements(By.xpath("//div[contains(text(),'Gift Cards')]")).size();
        Assert.assertEquals(size, 1);
        driver.quit();
    }

    @Test
    public void checkAmazonLive() {
        openBurgerMenu();
        int size = driver.findElements(By.xpath("//div[contains(text(),'Amazon Live')]")).size();
        Assert.assertEquals(size, 1);
        driver.quit();
    }



}

