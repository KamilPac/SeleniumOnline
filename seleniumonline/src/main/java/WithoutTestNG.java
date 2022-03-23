import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class WithoutTestNG {

    public static WebDriver driver;


    //Krok 1
    @Test
    public void webElementyTesty() {

        ///Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");


        //Krok 1
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();


        //Krok 2
        WebElement imięInput = driver.findElement(By.id("Imię"));
        imięInput.clear();
        imięInput.sendKeys("Adam");

        Assert.assertEquals(imięInput.getAttribute("value"), "Adam", "W polu jest wprowadzona inna " +
                "wartość od oczekiwanej.  Oczekiwaliśmy wartości 'Adam' a jest " + imięInput.getAttribute("value"));



        //Krok 3
        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();
        nazwiskoInput.sendKeys("Nowak");

        Assert.assertEquals(nazwiskoInput.getAttribute("value"), "Nowak");


        //Krok 4
        WebElement mezczyznaButton = driver.findElement(By.xpath("//input[@name='KobietaCzyMezczyzna'][@value='Mężczyzna']"));
        if (!mezczyznaButton.isSelected()) {
            mezczyznaButton.click();
        }
        Assert.assertTrue(mezczyznaButton.isSelected(), "Pole mężczyna jest niezaznaczone!");

        //Krok 5
        WebElement przedziałWieku20_29 = driver.findElement(By.xpath("//input[@name='przedzialWieku'][@value='20-29']"));
        if (!przedziałWieku20_29.isSelected()) {
            przedziałWieku20_29.click();
        }
        Assert.assertTrue(przedziałWieku20_29.isSelected());


        //Krok 6
        WebElement wyslaneInformacje = driver.findElement(By.id("info"));
        System.out.println(wyslaneInformacje.getText());


        driver.quit();
    }
}