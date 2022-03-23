import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumAPI {
    public static WebDriver driver;

    @BeforeTest
    public void startBrowser() {

        System.out.println("BeforeTest");

//Konfiguracja początkowa
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.selenium-shop.pl/");

    }

    @AfterTest
    public void closeBrowser() {

        System.out.println("AfterTest");
        driver.quit();
    }

    @Test(priority = 2)
    public void verifyMessageAfterDoubleClickButton() {

        WebElement ankietaMenu = driver.findElement(By.linkText("ANKIETA"));
        ankietaMenu.click();

        WebElement doubleClickButton_PokazKomunikat = driver.findElement(By.xpath("//*[@value='Dwuklik pokaż komunikat']"));
        Actions builder = new Actions(driver);
        builder.doubleClick(doubleClickButton_PokazKomunikat).perform();

        String expectedMessage ="Przycisk dwuklik został kliknięty";
        String actualMessage = driver.findElement(By.id("p-doubleClick")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(priority = 3)
    public void verifyMessageAfterRightClick() {

        WebElement rightClickButton_KliknijRight = driver.findElement(By.id("rightClick"));

        Actions builder = new Actions(driver);
        builder.contextClick(rightClickButton_KliknijRight).perform();

        String expectedMessage ="Przycisk RIGHT został kliknięty";
        String actualMessage = driver.findElement(By.id("rightClickInfo")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test(priority = 4)
    public void verifydMessageNazwiskoInput() {

        WebElement nazwiskoInput = driver.findElement(By.id("Nazwisk"));
        nazwiskoInput.clear();

        Actions builder = new Actions(driver);
        Action typeInCAPS = builder.keyDown(nazwiskoInput, Keys.SHIFT)
                .sendKeys(nazwiskoInput, "nowak")
                .keyUp(nazwiskoInput, Keys.SHIFT)
                .build();

        typeInCAPS.perform();

        String expectedMessage ="NOWAK";

        Assert.assertEquals(nazwiskoInput.getAttribute("value"), expectedMessage);

    }

}