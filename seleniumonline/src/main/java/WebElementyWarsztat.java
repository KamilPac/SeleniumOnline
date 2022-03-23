import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementyWarsztat {

    public static WebDriver driver;

    @Test
    public void zamawianieProduktu(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("SKLEP")).click();

        Select listaProduktowFiltrowanie = new Select(driver.findElement(By.name("orderby")));
        listaProduktowFiltrowanie.selectByVisibleText("Sortuj od najnowszych");

        WebElement trzeciProduktNajnowszy = driver.findElement(By.xpath("//ul[contains(@class,'products')]/li[3]"));
        trzeciProduktNajnowszy.click();

        String nazwaProduktuNaStronieSzczegolowProduktu = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();

        String cenaProduktuNaStronieSzczegolowProduktu = driver.findElement(By.xpath("//*[@class='summary entry-summary']/p/span")).getText();

        System.out.println("Nazwa produktu na stoenie szczegolow produktu = " + nazwaProduktuNaStronieSzczegolowProduktu);
        System.out.println("Cena produktu na stoenie szczegolow produktu = " + cenaProduktuNaStronieSzczegolowProduktu);

        WebElement iloscInput = driver.findElement(By.xpath("//input[starts-with(@id,'quantity')]"));
        iloscInput.clear();
        iloscInput.sendKeys("2");

        WebElement dodajDoKoszykaButton = driver.findElement(By.name("add-to-cart"));
        dodajDoKoszykaButton.click();

        WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczKoszykLink.click();

        String nazwaProduktuWKoszyku = driver.findElement(By.xpath("//td[@class='product-name']/a")).getText();
        String cenaProduktuWKoszyku = driver.findElement(By.xpath("//td[@class='product-subtotal']/span")).getText();

        System.out.println("Nazwa produktu w koszyku = " + nazwaProduktuWKoszyku);
        System.out.println("Cena produktu w koszyku = " + cenaProduktuWKoszyku);

        String poprawnaCenaKoszyka = "240,00 ZŁ";

        Assert.assertEquals(nazwaProduktuNaStronieSzczegolowProduktu,nazwaProduktuWKoszyku);

        Assert.assertEquals(cenaProduktuWKoszyku,poprawnaCenaKoszyka);


        driver.quit();


    }


}