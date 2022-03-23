import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PierwszyTest {

    public static WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");


        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver = new EdgeDriver();
        driver.get("http://www.selenium-shop.pl");
        driver.manage().window().maximize();
        System.out.println("Tytuł strony: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Selenium Shop Automatyzacja Testów");
    }

        @Test
        public void test2(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");


            //driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            driver = new EdgeDriver();
            driver.get("http://www.selenium-shop.pl");
            driver.manage().window().maximize();
            System.out.println("Tytuł strony: " + driver.getTitle());

            Assert.assertEquals(driver.getTitle(),"Selenium Shop Automatyzacja Testów");
    }

}