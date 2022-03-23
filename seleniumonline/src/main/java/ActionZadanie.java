import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionZadanie {

    public static WebDriver driver;

    @Test
    public void actions_Test() {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,30);

        Actions builder = new Actions(driver);

//Krok 1
        driver.get("http://www.selenium-shop.pl/o-nas/");

//Krok 2
        WebElement dwuklikButton = driver.findElement(By.xpath("//input[@value='Dwuklik pokaż komunikat']"));
        builder.doubleClick(dwuklikButton).perform();

//Krok 3
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Przycisk dwuklik został kliknięty']")).isDisplayed());

//Krok 4

        WebElement rightClickButton = driver.findElement(By.id("rightClick"));
        builder.contextClick(rightClickButton).perform();

//Krok 5
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Przycisk RIGHT został kliknięty']")).isDisplayed());

//Krok 6
        WebElement imieInput = driver.findElement(By.id("Imię")) ;

        Action textCaps= builder.keyDown(imieInput, Keys.SHIFT)
                .sendKeys(imieInput, "tomasz")
                .keyUp(imieInput, Keys.SHIFT)
                .build();

        textCaps.perform();

//Krok 7
        Assert.assertEquals(imieInput.getAttribute("value"), "TOMASZ");

//Zamknięcie przeglądarki
        driver.quit();

    }
}
