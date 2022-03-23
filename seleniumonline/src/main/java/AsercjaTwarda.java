import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AsercjaTwarda{

    public static WebDriver driver;

    @Test
    public void webElementy_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

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
        imięInput.sendKeys("Kamil");

        //Krok 3
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Nowak");

        //Krok 4
        WebElement mezczyznaButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if (!mezczyznaButton.isSelected()){
            mezczyznaButton.click();
        }

        //Krok 5
        WebElement przedziałWieku20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        WebElement przedziałWieku15_19 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='15-19']"));
        if (!przedziałWieku20_29.isSelected()){
            przedziałWieku20_29.click();
        }

        //Krok 6
        WebElement szukanyProdukt_Torba_sportowa = driver.findElement(By.xpath("//input[@name='Produkt'][@value='Torba sportowa']"));
        if (!szukanyProdukt_Torba_sportowa.isSelected()){
            szukanyProdukt_Torba_sportowa.click();
        }

        //Weryfikacje wcześniej wprowadzonych danych
        //Krok 7
        Assert.assertEquals(imięInput.getAttribute("value"),"Kamil","W polu jest wprowadzona inna " +
                "wartość od oczekiwanej.  Oczekiwaliśmy wartości 'Adam' a jest " + imięInput.getAttribute("value")  );
        //Assert.assertEquals(imięInput.getText(),"Adam");


        //Krok 8
        Assert.assertNotEquals(nazwiskoInput.getAttribute("value"),"Kowalski");
        //Assert.assertNotEquals(nazwiskoInput.getText(),"Kowalski");

        //Krok 9
        Assert.assertTrue(!mezczyznaButton.isSelected(),"Oczekujemy, że pole 'Mężczyzna' będzie niezaznaczone, a aktualnie jest zaznaczone!");

        //Krok 10
        Assert.assertFalse(przedziałWieku15_19.isSelected());

        //Krok 11
        Assert.assertNull(szukanyProdukt_Torba_sportowa.getAttribute("disabled"));

        //Krok 12
        //WebElement wyslijPrzycisk = driver.findElement(By.id("Wyslij"));
        WebElement wyslijPrzycisk = driver.findElement(By.id("Wyslij"));
        wyslijPrzycisk.click();

        System.out.println("Przycisku 'Prześlij' nie ma na stronie!");

        //Krok 13

        WebElement wyslaneInformacje = driver.findElement(By.id("info"));
        System.out.println(wyslaneInformacje.getText());


        driver.quit();

    }
}