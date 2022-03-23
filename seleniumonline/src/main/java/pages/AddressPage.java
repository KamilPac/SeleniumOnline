package pages;

import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class AddressPage extends TestBase {
    GlobalMethods globalMethods;

    /**** repozytorium elementów ****/
    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*//parent::*/address")
    private WebElement infoDeliveryAddress;

    @FindBy(xpath = "//h3[contains(text(),'wysyłki')]//parent::*/a")
    private WebElement addDeliveryAddress;



    /**** konstruktor ****/
    public AddressPage(){
        globalMethods = new GlobalMethods();
        PageFactory.initElements(driver, this);
    }


    /****  metody  ****/
    // Przejście do strony z dodaniem/edytowaniem adresy dostowy
    public DeliveryAddressDetailsPage goToAddDeliveryAddress(){
        wait.until(visibilityOf(addDeliveryAddress));
        addDeliveryAddress.click();
        return new DeliveryAddressDetailsPage();
    }

    // Pobranie i zwrócenie komunikatu dotyczącego istnienia adresy dostawy
    public String getInfoDeliveryAddress(){
        return globalMethods.getTextFromElement(infoDeliveryAddress);
    }


}