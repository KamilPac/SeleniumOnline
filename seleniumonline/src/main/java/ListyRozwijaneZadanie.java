import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListyRozwijaneZadanie{

    public static WebDriver driver;

    @Test
    public void listaRozwijanaSport_Test() throws InterruptedException {

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("http://www.selenium-shop.pl/");

        driver.manage().window().maximize();

//Przejście do podstrony: Ankieta
        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

//Lokalizacja elementu lista 'Sport' i przeskrolowanie do tego elementu
        Select sportLista = new Select(driver.findElement(By.name("Sport")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportLista);

        Thread.sleep(1000);

//Wybór pozycji Siatkówka
        sportLista.selectByValue("siatkowka");

//Instrukcja oczekiwania 2s
        Thread.sleep(2000);

//Wypisanie zaznaczonej obecnie pozycji na liście
        System.out.println("Zaznaczona/wybrana domyślnie pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());

//Wybór pozycji Koszykówka       
        sportLista.selectByIndex(2);

        //Instrukcja oczekiwania 2s
        Thread.sleep(2000);

//Wypisanie zaznaczonej obecnie pozycji na liście
        System.out.println("Zaznaczona/wybrana domyślnie pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());

//Wypisanie do konsoli wszystkich pozycji z listy

        int liczbaPozycjiNaLiscie_sportLista = sportLista.getOptions().size();
        System.out.println("Pozycje na liście: ");

        for(int i = 0; i < liczbaPozycjiNaLiscie_sportLista; i++){
            System.out.println("Pozycja: " + sportLista.getOptions().get(i).getText());
        }

        Thread.sleep(1000);

//Zamknięcie przeglądarki
        driver.close();

    }
}