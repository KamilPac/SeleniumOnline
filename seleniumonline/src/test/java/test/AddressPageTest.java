package test;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import base.*;

public class AddressPageTest extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;

    /********* konstruktor ***********/
    public AddressPageTest() {
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
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    /*********  TESTY *********/
    @Test(priority = 0)
    public void verifyNoDeliveryAddress() {
        Assert.assertTrue(addressPage.getInfoDeliveryAddress().equalsIgnoreCase
                (testdata.getProperty("correctInfoAboutDeliveryAddress")));

    }

}