import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZadanieTesty {

    public static WebDriver driver;



    @Test
    public void  weryfikacjaPodstronySklep(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("SKLEP")).click();

        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl,"http://www.selenium-shop.pl/sklep/");

        driver.quit();
    }

    @Test
    public void  weryfikacjaPodstronyAnkieta(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("ANKIETA")).click();

        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl,"http://www.selenium-shop.pl/o-nas/");

        driver.quit();
    }



    @Test
    public void weryfikacjaPodstronyKoszyk() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("KOSZYK")).click();

        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl, "http://www.selenium-shop.pl/koszyk/");

        driver.quit();
    }
        @Test
        public void  weryfikacjaPodstronySklepp(){
            System.setProperty("webdriver.opera.driver", "src/main/resources/operadriver.exe");
            driver = new OperaDriver();


            driver.get("http://www.selenium-shop.pl/");

            driver.findElement(By.linkText("SKLEP")).click();

            String adresUrl = driver.getCurrentUrl();
            System.out.println("Adres URL: " + adresUrl);

            Assert.assertEquals(adresUrl,"http://www.selenium-shop.pl/sklep/");

            driver.quit();

        }@Test
    public void  weryfikacjaPodstronySklep1(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");
        //może być potrzebne poczekanie chwilkę na element
        // oczekiwanie na elementy będzie dokładnie omówione w kolejnych modułach
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("SKLEP")).click();

        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl,"http://www.selenium-shop.pl/sklep/");

        driver.quit();
    }

    @Test
    public void  weryfikacjaPodstronyAnkieta1(){
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.selenium-shop.pl/");

        driver.findElement(By.linkText("ANKIETA")).click();

        String adresUrl = driver.getCurrentUrl();
        System.out.println("Adres URL: " + adresUrl);

        Assert.assertEquals(adresUrl,"http://www.selenium-shop.pl/o-nas/");

        driver.quit();
    }


}





