package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class DeliveryAddressDetailsPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage deliveryAddressDetailsPage;


    /********* konstruktor ***********/
    public DeliveryAddressDetailsPageTest() {
        super();
    }



    // Przed każdym testem uruchomienie przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();
        deliveryAddressDetailsPage = addressPage.goToAddDeliveryAddress();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    /*********  TESTY *********/
    @Test(priority = 0)
    public void addDeliveryAddress() {
        addressPage = deliveryAddressDetailsPage.fillForm("Jan","Testowy2","Polska",
                "Słoneczna","00-001","Warszawa");

        Assert.assertEquals(addressPage.getInfoDeliveryAddress(),
                "Jan Testowy2\n" +
                        "Słoneczna\n" +

                        "00-001 Warszawa");
    }

}