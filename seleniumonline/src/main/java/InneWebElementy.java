import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InneWebElementy{

    public static WebDriver driver;

    @Test
    public void webElementy_Test() {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

//Przejście do podstrony: Ankieta
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        WebElement kalendarzInput = driver.findElement(By.xpath("//*[@id='datepicker']/input"));
        kalendarzInput.clear();
        kalendarzInput.sendKeys("13-07-2020");

//Weryfikacja wartości tekstowej jaka jest obecna w polu kalendarzInput
        Assert.assertEquals(kalendarzInput.getAttribute("value"),"13-07-2020");

        WebElement komunikatInformacyjny = driver.findElement(By.id("fileInfo"));
        WebElement dodajPlik = driver.findElement(By.id("file"));
        dodajPlik.sendKeys("C:\\informacje.txt");

//Weryfikacja komunikatu potwierdzającego załączenie/załadowanie pliku 
        Assert.assertEquals(komunikatInformacyjny.getText(),"Plik informacje.txt został załadowany");

//Zakmnięcie przeglądarki
        driver.quit();



    }

}