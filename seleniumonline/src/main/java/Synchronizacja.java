import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Synchronizacja {
    public static WebDriver driver;

    @Test
    public void synchronizacjaTestow() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        WebDriverWait wait = new WebDriverWait(driver,30);


        //Krok 1
        WebElement sklepMenu = driver.findElement(By.linkText("SKLEP"));
        sklepMenu.click();

        //Krok 2
        WebElement koszulkaLiverpool = driver.findElement(By.xpath("//h2[contains(text(),'Liverpool')]"));
        koszulkaLiverpool.click();

        //Krok 3
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[starts-with(@id,'quantity_')]")));
        WebElement quantityField = driver.findElement(By.xpath("//*[starts-with(@id,'quantity_')]"));
        quantityField.clear();
        quantityField.sendKeys("3");

        //Krok 4
        WebElement dodajDoKoszykaButton = driver.findElement(By.xpath("//button[@name='add-to-cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(dodajDoKoszykaButton));
        dodajDoKoszykaButton.click();

        //Krok 5
        WebElement zobaczKoszykLink = driver.findElement(By.linkText("Zobacz koszyk"));
        zobaczKoszykLink.click();

        //Krok 6
        WebElement kwota = driver.findElement(By.xpath("//td[@data-title='Kwota']/span"));
        Assert.assertEquals(kwota.getText(), "570,00 ZŁ");

        //Krok 7
        WebElement przejdzDoKasy = driver.findElement(By.xpath("//*[@class='wc-proceed-to-checkout']/a"));
        przejdzDoKasy.click();

        driver.close();
        driver.quit();

    }
}