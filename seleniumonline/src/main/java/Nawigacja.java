import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Nawigacja {

    public static WebDriver driver;

    @Test
    public void nawigacja_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Nawigacja do wskazanej strony
        driver.navigate().to("http://www.selenium-shop.pl/");

        //Wypisanie informacji o tytule strony oraz adresie URL
        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        //Przejście do podstrony: MOJE KONTO
        WebElement ankietaMenu = driver.findElement(By.linkText("MOJE KONTO"));
        ankietaMenu.click();

        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        //Instrukcja oczekiwania
        Thread.sleep(2000);

        //Instrukcja powrotu do poprzedniej strony
        driver.navigate().back();

        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Instrukcja forward - strona do przodu
        driver.navigate().forward();

        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Odswieżenie strony (symulacja akcji przycisku F5)
        driver.navigate().refresh();

        System.out.println("Tytuł strony: " + driver.getTitle());
        System.out.println("Tytuł strony: " + driver.getCurrentUrl());

        Thread.sleep(2000);

        //Zakmnięcie przeglądarki
        driver.quit();
    }
}