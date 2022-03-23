import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selektors {
    public static WebDriver driver;

    @Test
    public void lokalizowanieElementow_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");



        //Krok 1
        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        //Krok 2
        WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[contains(text(),'Chelsea')]"));
        koszulkaChelsea.click();
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[starts-with(text(),'Koszulka Chelsea')]"));
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//h2[ends-with(text(),'Chelsea London')]"));
        // WebElement koszulkaChelsea = driver.findElement(By.xpath("//*[starts-with(@class,'products')]/li[2]/a/h2"));

        //Krok 3
        WebElement quantityField = driver.findElement(By.xpath("//*[starts-with(@id,'quantity_')]"));
        quantityField.clear();
        quantityField.sendKeys("2");
        // WebElement quantityField = driver.findElement(By.xpath("//*[@class='quantity']/input"));
        // WebElement quantityField = driver.findElement(By.xpath(" //*[starts-with(@id,'quantity_')]"));
        // WebElement quantityField = driver.findElement(By.xpath("//input[@title='Szt.']"));

        //Krok 4
        WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        dodajDoKoszykaButton.click();
        // WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//button[@type='submit']"));
        // WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        // WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//*[@class='cart']/button"));
        //button[@type='submit']
        //button[@name='add-to-cart']


        //Krok 5
        WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczKoszykLink.click();
        // WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        // WebElement zobaczKoszykLink = driver.findElement(By.xpath("//a[text()='Zobacz koszyk']"));
        // WebElement zobaczKoszykLink = driver.findElement(By.xpath("//*[@class='woocommerce-message']/a"));

        //Krok 6
        WebElement kodKuponuInput = driver.findElement(By.id("coupon_code"));
        kodKuponuInput.clear();
        kodKuponuInput.sendKeys("Wiosna2020");
        // WebElement kodKuponuInput = driver.findElement(By.id("coupon_code"));
        // WebElement kodKuponuInput = driver.findElement(By.xpath("//input[@name='coupon_code']"));
        // WebElement kodKuponuInput = driver.findElement(By.xpath("//*[@class='coupon']/input"));

        //Krok 7
        WebElement zastosujKuponButton = driver.findElement(By.name("apply_coupon"));
        zastosujKuponButton.click();
        // WebElement zastosujKuponButton = driver.findElement(By.name("apply_coupon"));
        // WebElement zastosujKuponButton = driver.findElement(By.xpath("//button[@type='submit'][@name='apply_coupon']"));
        // WebElement zastosujKuponButton = driver.findElement(By.xpath("//button[contains(text(),'Zastosuj')]"));

        driver.close();
        driver.quit();
    }
}

