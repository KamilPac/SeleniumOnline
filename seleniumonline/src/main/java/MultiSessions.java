import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MultiSessions {


    @Test
    public void clickAnkieta_Test_SessionOne(){

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 1. Wątek id: " + id);
        System.out.println("Test 1. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyValueImieInput_SessionTwo(){
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        WebElement imięInput = driver.findElement(By.id("Imię"));
        imięInput.clear();
        imięInput.sendKeys("Adam");

        Assert.assertEquals(imięInput.getAttribute("value"), "Adam", "W polu jest wprowadzona inna " +
                "wartość od oczekiwanej.  Oczekiwaliśmy wartości 'Adam' a jest " + imięInput.getAttribute("value"));


        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 2. Wątek id: " + id);
        System.out.println("Test 2. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyIsSelectedPrzedzialWieku20_29_SessionThree(){
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();


        WebElement przedziałWieku20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!przedziałWieku20_29.isSelected()) {
            przedziałWieku20_29.click();
        }
        Assert.assertTrue(przedziałWieku20_29.isSelected());


        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 3. Wątek id: " + id);
        System.out.println("Test 3. Session id: " + sessionid);
        driver.quit();
    }
}