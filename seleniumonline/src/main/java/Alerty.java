import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Alerty {

    public static WebDriver driver;

    @Test
    public void alerty_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        //Krok 1
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //Krok 2
        WebElement alertButton = driver.findElement(By.id("alertPrzycisk"));
        alertButton.click();

        Thread.sleep(2000);

        // Krok 3
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //Krok 4
        WebElement promptAlertButton = driver.findElement(By.id("promtAlertPrzycisk"));
        promptAlertButton.click();

        Thread.sleep(2000);

        //Krok 5
        driver.switchTo().alert().sendKeys("Warszawa");


        Thread.sleep(3000);


        //Krok 6
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        // Krok 7
        WebElement confimationAlertButton = driver.findElement(By.id("confimationAlertPrzycisk"));
        confimationAlertButton.click();

        Thread.sleep(2000);

        //Krok 8
        System.out.println("Komunikat z okna Alert: " + driver.switchTo().alert().getText());

        //Krok 9
        driver.switchTo().alert().dismiss();

        driver.quit();
    }
}
