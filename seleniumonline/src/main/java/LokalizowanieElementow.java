import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LokalizowanieElementow {

    public static WebDriver driver;

    @Test
    public void  weryfikacjaPrzyciskowNaStronieMojeKonto(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("MOJE KONTO")).click();

        List<WebElement> wszystkiePrzyciski = driver.findElements(By.xpath("//button"));

        int liczbaPrzyciskow = wszystkiePrzyciski.size();

        System.out.println("Liczba przyciskow na stronie = " + liczbaPrzyciskow);

        Assert.assertEquals(liczbaPrzyciskow, 2);

        for(int i = 0; i < liczbaPrzyciskow; i++){
            System.out.println(wszystkiePrzyciski.get(i).getAttribute("value"));
        }

        driver.quit();

    }

}