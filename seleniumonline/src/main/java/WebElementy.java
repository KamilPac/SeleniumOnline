import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebElementy {

    public static WebDriver driver;

    @Test
    public void webElementy_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        Thread.sleep(5000);

        //Krok 1
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //Krok 2
        WebElement imięInput = driver.findElement(By.id("Imię"));
        imięInput.clear();
        imięInput.sendKeys("Adam");

        //Krok 3
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Nowak");

        //Krok 4
        WebElement mezczyznaButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if (!mezczyznaButton.isSelected()) {
            mezczyznaButton.click();
        }

        //Krok 5
        WebElement przedziałWieku = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));

        if (!przedziałWieku.isSelected()) {
            przedziałWieku.click();
        }

        //Krok 6
        WebElement szukanyProdukt = driver.findElement(By.xpath("//input[@name='Produkt'][@value='Torba sportowa']"));
        if (!szukanyProdukt.isSelected()) {
            szukanyProdukt.click();
        }


        //Krok 7
        Select sportLista = new Select(driver.findElement(By.name("Sport")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportLista);
        sportLista.selectByVisibleText("Siatkówka");


        //Krok 8
        Select markiLista = new Select(driver.findElement(By.id("Marki")));
        markiLista.selectByVisibleText("Kappa");

        //Krok 9
        WebElement wyslijPrzycisk = driver.findElement(By.id("Wyslij"));
        wyslijPrzycisk.click();

        //Krok 10
        WebElement wysłaneDane_Komunikat = driver.findElement(By.xpath("//*[contains(text(),'Wysłane dane')]"));
        Assert.assertTrue(wysłaneDane_Komunikat.isDisplayed());

        //Krok 11
        WebElement wysłaneInformacje = driver.findElement((By.id("info")));
        System.out.println(wysłaneInformacje.getText());


        driver.quit();


    }
}