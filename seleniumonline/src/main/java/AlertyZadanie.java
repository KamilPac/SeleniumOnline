import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertyZadanie {

    public static WebDriver driver;

    @Test
    public void alertZadanie_Test() {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

//Krok 1
        driver.get("http://www.selenium-shop.pl/o-nas/");

//Krok 2
        WebElement promptAlert = driver.findElement(By.id("promtAlertPrzycisk"));
        promptAlert.click();

//Krok 3
        driver.switchTo().alert().sendKeys("Kraków");
        driver.switchTo().alert().accept();

//Krok 4
        WebElement confirmAlert = driver.findElement(By.id("confimationAlertPrzycisk"));
        confirmAlert.click();

//Krok 5
        System.out.println("Komunikat z okna Alert: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

//Zamknięcie przeglądarki
        driver.quit();

    }
}