package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import base.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductListPageTest extends TestBase {
    HomePage homePage;
    ProductListPage productListPage;

    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
            ("PIŁKA NOŻNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PIŁKA NOŻNA ADIDAS REPLIKA LIGA MISTRZÓW",
                    "PIŁKA NOŻNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
                    "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));



    /********* konstruktor ***********/
    public ProductListPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        productListPage = new ProductListPage();

        productListPage = homePage.goToProductPage();
    }


    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyProductNumber(){
        Assert.assertEquals(productListPage.getProductsNumber(),
                Integer.parseInt(testdata.getProperty("correctProductNumber")));
    }

    @Test(priority = 1)
    public void verifySortProducts(){
        Assert.assertEquals(productListPage.getProductsNameAfterOrderByPrice(), correctProductListSortByPriceFromLowest);
    }
}