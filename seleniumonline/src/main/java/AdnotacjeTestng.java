import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdnotacjeTestng{

    // Adnotacja @Test
    @Test
    public void testCase1() {
        System.out.println("Przypadek testowy 1");
    }

    // Adnotacja @Test
    @Test
    public void testCase2() {
        System.out.println("Przypadek testowy 2");
    }

    // Adnotacja @BeforeMethod
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Przed metodą");
    }

    // Adnotacja @AfterMethod
    @AfterMethod
    public void afterMethod() {
        System.out.println("Po metodzie");
    }

    // Adnotacja @BeforeClass
    @BeforeClass
    public void beforeClass() {
        System.out.println("Przed klasą");
    }

    // Adnotacja @AfterClass
    @AfterClass
    public void afterClass() {
        System.out.println("Po klasie");
    }

    // Adnotacja @BeforeTest
    @BeforeTest
    public void beforeTest() {
        System.out.println("Przed testem");
    }

    // Adnotacja @AfterTest
    @AfterTest
    public void afterTest() {
        System.out.println("Po teście");
    }

    // Adnotacja @BeforeSuite
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Przed zestawem testów");
    }

    // Adnotacja @AfterSuite
    @AfterSuite
    public void afterSuite() {
        System.out.println("Po zestawie testów");
    }

}