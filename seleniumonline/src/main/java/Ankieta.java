import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ankieta{

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

        //Weryfikacja czy lista jest multilistą / jednokrotnego wyboru
        if(sportLista.isMultiple()){
            System.out.println("Lista 'Jaki sport uprawiasz' jest wielokrotnego wyboru");
        }else{
            System.out.println("Lista 'Jaki sport uprawiasz' jest jednokrotnego wyboru");
        }

        //Liczenie pozycji na liście
        int liczbaPozycjiNaLiscie_sportLista = sportLista.getOptions().size();

        System.out.println("Liczba pozycji w liście 'Jaki sport uprawiasz': " + liczbaPozycjiNaLiscie_sportLista);

        //Instrukcja oczekiwania 1s
        Thread.sleep(2000);

        //Wypisanie pierwszej, domyślnej pozycji listy
        System.out.println("Zaznaczona/wybrana domyślnie pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());

        //Wypisanie do konsoli wszystkich pozycji z listy
        for(int i = 0; i < liczbaPozycjiNaLiscie_sportLista; i++){
            System.out.println("Pozycja: " + sportLista.getOptions().get(i).getText());
        }

        //Wybór pozycji bieganie
        sportLista.selectByValue("bieganie");

        Thread.sleep(1000);

        //Wypisanie do konsoli aktualnie zaznaczonej pozycji z listy
        System.out.println("Aktualnie zaznaczona/wybrana pozycja na liście 'Jaki sport uprawiasz' : " + sportLista.getFirstSelectedOption().getText());

        //Zamknięcie przeglądarki
        driver.close();

    }
}