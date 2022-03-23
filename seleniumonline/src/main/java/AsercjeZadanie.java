import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsercjeZadanie {

    public static WebDriver driver;

    @Test
    public void listaRozwijanaSport_Test() throws InterruptedException {

        String poprawnyTytulStronyGlownej = "Selenium Shop Automatyzacja Testów";
        String poprawnyTytulPodstronyMojeKonto = "Moje konto – Selenium Shop Automatyzacja Testów";

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

//Krok 1
        driver.get("http://www.selenium-shop.pl/");

//Krok 2
        Assert.assertEquals(driver.getTitle(),poprawnyTytulStronyGlownej,"Tytuł strony jest niepoprawny");

//Krok 3
        WebElement mojeKontoMenu = driver.findElement(By.linkText("MOJE KONTO"));
        mojeKontoMenu.click();

//Krok 4
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase(poprawnyTytulPodstronyMojeKonto), "Tytuł strony jest niepoprawny");

//Krok 5
        WebElement loginInput = driver.findElement(By.id("username"));
        Assert.assertTrue(loginInput.isDisplayed(), "Pole login nie jest wyświetlone na stronie");

//Krok 6
        WebElement zapamietajMnieCheckbox = driver.findElement(By.id("rememberme"));
        Assert.assertFalse(zapamietajMnieCheckbox.isSelected(), "Checkbox Zapamiętaj mnie jest zaznaczony");

//Zamknięcie przeglądarki
        driver.close();

    }
}