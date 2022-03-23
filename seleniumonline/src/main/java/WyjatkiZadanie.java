import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WyjatkiZadanie {

    public static WebDriver driver;

    @Test
    public void wyjatki_test() {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        Actions builder = new Actions(driver);


//Krok 1
        driver.get("http://www.selenium-shop.pl/moje-konto/");



//Krok 2
        WebElement zarejestrujSieButton;

        try{
            driver.findElement(By.name("register")).click();

        } catch (NoSuchElementException e1) {

            System.out.println("Przycisku ZAREJESTRUJ SIĘ nie ma na stronie!");
            driver.navigate().refresh();

        } catch (ElementNotVisibleException e2) {

            System.out.println("Przycisk ZAREJESTRUJ SIĘ nie jest widoczny na stronie");
            driver.navigate().refresh();

        } catch(ElementNotInteractableException e3) {

            System.out.println("Nie można wykonać akcji kliknięcia na elemencie ZAREJESTRUJ SIĘ");
            driver.navigate().refresh();

        }

//Zamknięcie przeglądarki
        driver.quit();

    }
}