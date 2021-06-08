package TestAllure;




import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import jdk.jfr.Category;
import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners({AllureListener.class})
public class TestAmazonChrome {
   WebDriver driver; //if we use webdriver by download in resources and set up manually (we need this if we use webdriver manager)

    @BeforeClass
    public void setUp() {
        BaseClass bs = new BaseClass();
        driver = bs.initialize_driver();
        driver.get("https://www.amazon.com");
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
    }



    /* public void openBurgerMenu() {

        String url = "https://www.amazon.com";
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); //if we use webdriver by download in resources and set up manually (we dont need this if we use webdriver manager, also we don't resources with driver)
        //WebDriverManager.chromedriver().setup(); // if we want to use webdriver manager
        driver = new ChromeDriver(); //if we use webdriver by download in resources and set up manually (we need this if we use webdriver manager)
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
    } */

    @Test
    @Description("It's simple test")
    public void checkGiftCards() {
        //openBurgerMenu();
        setUp();
        int size = driver.findElements(By.xpath("//div[contains(text(),'Gift Card')]")).size();
        Assert.assertEquals(size, 1);
        driver.quit();
    }

    @Test
    @Description("It's simple test")
    public void checkAmazonLive() {
        //openBurgerMenu();
        setUp();
        int size = driver.findElements(By.xpath("//div[contains(text(),'Amazon Live')]")).size();
        Assert.assertEquals(size, 1);
        driver.quit();
    }

    /*
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

    */
}

