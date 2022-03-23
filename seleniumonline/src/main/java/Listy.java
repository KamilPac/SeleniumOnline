import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Listy{

    public static WebDriver driver;

    @Test
    public void lista_Test() throws InterruptedException {

        //Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();


        //Krok 1
        driver.get("http://www.selenium-shop.pl/");
        Assert.assertEquals(driver.getCurrentUrl(),"http://www.selenium-shop.pl/");

        //Krok 2
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        //Krok 3
        Select sportLista = new Select(driver.findElement(By.name("Sport")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportLista);
        Thread.sleep(1000);

        if(sportLista.isMultiple()){
            System.out.println("Lista 'Jaki sport uprawiasz' jest wielokrotnego wyboru");
        }else{
            System.out.println("Lista 'Jaki sport uprawiasz' jest jednokrotnego wyboru");
        }

        //Krok 4
        int liczbaPozycjiNaLiscie_sportLista = sportLista.getOptions().size();
        System.out.println("Liczba pozycji w liście 'Jaki sport uprawiasz': " + liczbaPozycjiNaLiscie_sportLista);

        //Krok 5
        System.out.println("Zaznaczona/wybrana domyślnie pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());

        //Krok 6
        for(int i = 0; i < liczbaPozycjiNaLiscie_sportLista; i++){
            System.out.println("Pozycja: " + sportLista.getOptions().get(i).getText());
        }

        //Krok 7
        sportLista.selectByValue("bieganie");
        Thread.sleep(1000);
        Assert.assertEquals(sportLista.getFirstSelectedOption().getText(),"Bieganie");
        System.out.println("Aktualnie zaznaczona/wybrana pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());


        Thread.sleep(1000);
        driver.close();

    }
}