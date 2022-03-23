import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InneWebElementy1{

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

// Wpisanie do pola kalendarz daty urodzin
        WebElement kalendarzInput = driver.findElement(By.xpath("//*[@id='datepicker']/input"));
        kalendarzInput.clear();
        kalendarzInput.sendKeys("07-02-1990");

//Weryfikacja wartości (daty urodzin) jaka jest obecna w polu kalendarzInput
        Assert.assertEquals(kalendarzInput.getAttribute("value"),"07-02-1990");


//Zakmnięcie przeglądarki
        driver.quit();

    }
}