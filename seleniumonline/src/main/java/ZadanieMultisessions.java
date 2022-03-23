import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ZadanieMultisessions {


    @Test
    public void verifyadres_Test_SessionOne() {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");
        String poprawnyTytulStronyGlownej = "Koszulka West Ham United – Selenium Shop Automatyzacja Testów";

        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        WebElement koszulkaWestHumUnited = driver.findElement(By.xpath("//h2[contains(text(),'West')]"));
        koszulkaWestHumUnited.click();

        Assert.assertEquals(driver.getTitle(), poprawnyTytulStronyGlownej, "Tytuł strony jest niepoprawny");

        SessionId sessionid = ((RemoteWebDriver) driver).getSessionId();
        long id = Thread.currentThread().getId();
        System.out.println("Test 1. Wątek id: " + id);
        System.out.println("Test 1. Session id: " + sessionid);

        driver.quit();

    }

    @Test
    public void verifyProductName_SessionTwo() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        WebElement koszulkaWestHumUnited = driver.findElement(By.xpath("//h2[contains(text(),'West')]"));
        koszulkaWestHumUnited.click();

        String poprawnaNazwaProduktu = "KOSZULKA WEST HAM UNITED";

        WebElement nazwaKoszulki = ((ChromeDriver) driver).findElementByXPath("//*[contains(@class,'product_title')]");



        Assert.assertEquals(nazwaKoszulki.getText(), poprawnaNazwaProduktu);





        driver.quit();
    }

    @Test
    public void verifyProductPrice_SessionThree() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        WebElement koszulkaWestHumUnited = driver.findElement(By.xpath("//h2[contains(text(),'West')]"));
        koszulkaWestHumUnited.click();

        String poprawnaCenaKoszulki = "90,00 ZŁ";

        WebElement cenaKoszulki = ((ChromeDriver) driver).findElementByXPath("//*[@class='price']/span");

        Assert.assertEquals(cenaKoszulki.getText(), poprawnaCenaKoszulki);

        driver.quit();


    }

    @Test
    public void verifyProductQuantity_SessionFour() {
        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        WebElement koszulkaWestHumUnited = driver.findElement(By.xpath("//h2[contains(text(),'West')]"));
        koszulkaWestHumUnited.click();

        String poprawnaIloscKoszulek = "1";

        WebElement iloscInput = driver.findElement(By.xpath("//input[starts-with(@id,'quantity')]"));

        Assert.assertEquals(iloscInput.getAttribute("value"),poprawnaIloscKoszulek);

        System.out.println(iloscInput);

        driver.quit();

    }

}