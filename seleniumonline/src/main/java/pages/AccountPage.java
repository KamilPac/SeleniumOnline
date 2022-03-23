package pages;

import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class AccountPage extends TestBase {
    GlobalMethods globalMethods;

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']/p/strong")
    private WebElement nameAccountLabel;

    @FindBy(xpath = "//a[contains(text(),'Zamówienia')]")
    private WebElement zamowieniaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(),'Adresy')]")
    private WebElement adresyMenuBoczne;


    /**** konstruktor ****/
    public AccountPage (){
        globalMethods = new GlobalMethods();
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/
    // Pobranie i zwrócenie nazwy konta (imie i nazwisko)
    public String getNameAccount() {
        return  globalMethods.getTextFromElement(nameAccountLabel);
    }

    // Przejście na zakładkę Zamówienia (dotyczny zamówień potwierdzonych)
    public OrderConfirmedPage goToOrders(){
        wait.until(visibilityOf(zamowieniaMenuBoczne));
        zamowieniaMenuBoczne.click();
        return new OrderConfirmedPage();
    }

    // Przejście na zakładkę Adresy
    public AddressPage goToAddresses(){
        wait.until(visibilityOf(adresyMenuBoczne));
        adresyMenuBoczne.click();
        return new AddressPage();
    }


}