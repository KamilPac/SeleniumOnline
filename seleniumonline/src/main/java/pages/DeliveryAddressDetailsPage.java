package pages;

import base.TestBase;
import helpers.GlobalMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class DeliveryAddressDetailsPage extends TestBase {
    GlobalMethods globalMethods;

    /**** repozytorium elementów ****/
    @FindBy(id = "shipping_first_name")
    private WebElement name;

    @FindBy(id = "shipping_last_name")
    private WebElement lastName;

    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    private WebElement arrowInputCountry;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private  WebElement inputCountry;

    @FindBy(id = "shipping_address_1")
    private  WebElement address;

    @FindBy(id = "shipping_postcode")
    private  WebElement postcode;

    @FindBy(id = "shipping_city")
    private  WebElement city;

    @FindBy(name = "save_address")
    private WebElement saveAddressButton;


    /**** konstruktor ****/
    public DeliveryAddressDetailsPage(){
        globalMethods = new GlobalMethods();
        PageFactory.initElements(driver, this);
    }

    public void setCountry(String country){
        wait.until(visibilityOf(arrowInputCountry));
        arrowInputCountry.click();
        inputCountry.sendKeys(country, Keys.ENTER);

    }

    /****  metody  ****/
    // Metoda wykonująca pełną akcję uzupełniania formularza adresy dostawy
    // zwracająca stronę AddressPage
    public AddressPage fillForm(String nameStr, String lastNameStr, String countryStr, String addressStr, String postcodeStr,
                                String cityStr) {
        globalMethods.setInput(name,nameStr);
        globalMethods.setInput(lastName, lastNameStr);
        setCountry(countryStr);
        globalMethods.setInput(postcode, postcodeStr);
        globalMethods.setInput(city, cityStr);
        globalMethods.clickButton(saveAddressButton);

        return new AddressPage();
    }

}