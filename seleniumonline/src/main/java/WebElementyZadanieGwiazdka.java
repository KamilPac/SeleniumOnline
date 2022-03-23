import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementyZadanieGwiazdka {


    public static WebDriver driver;

    @Test
    public void zamawianieProduktu() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("SKLEP")).click();

        Select listaProduktowFiltrowanie = new Select(driver.findElement(By.name("orderby")));
        listaProduktowFiltrowanie.selectByVisibleText("Sortuj wg popularności");

        WebElement pierwszyProdukt = driver.findElement(By.xpath("//ul[contains(@class,'products')]/li[1]"));
        pierwszyProdukt.click();

        WebElement iloscInput = driver.findElement(By.xpath("//input[starts-with(@id,'quantity')]"));
        iloscInput.clear();
        iloscInput.sendKeys("1");

        String nazwaProduktuNaStronieSzczegolowProduktu = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

        String cenaProduktuNaStronieSzczegolowProduktu = driver.findElement(By.xpath("//*[@class='summary entry-summary']/p/span")).getText();



        WebElement dodajDoKoszykaButton = driver.findElement(By.name("add-to-cart"));
        dodajDoKoszykaButton.click();

        WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczKoszykLink.click();

        String nazwaProduktuWKoszyku = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        String iloscProduktuWKoszyku = driver.findElement(By.xpath("//input[starts-with(@id,'quantity')]")).getText();
        String poprawnaIloscKoszyka = "1";

        System.out.println("Nazwa produktu w koszyku = " + nazwaProduktuWKoszyku);

        Assert.assertEquals(nazwaProduktuNaStronieSzczegolowProduktu,nazwaProduktuWKoszyku);

        Assert.assertEquals(iloscProduktuWKoszyku,poprawnaIloscKoszyka);

        driver.quit();

    }
}
