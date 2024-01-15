import objects.HomePageScooter;
import objects.OrderPageScooter;
import objects.RentPageScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Praktikum {

    private WebDriver driver;

    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void checkSuccessOrderFirst(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickUpOrderButton();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);

        String name = "Иван";
        String surname = "Иванов";
        String address = "г. Москва, ул. Московская, д.1";
        String phone = "12345678901";

        objOrderPage.setOrderPageFields(name, surname, address, phone);

        RentPageScooter objRentPage = new RentPageScooter(driver);
        objRentPage.setRentPageFields();
        objRentPage.clickYesToOrder();
        objRentPage.checkTitleOrderIssued();
    }

    @Test
    public void checkSuccessOrderSecond(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickUpOrderButton();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);

        String name = "Андриана";
        String surname = "Шевченко";
        String address = "г. Москва, ул. Московская, д.1, кв.5";
        String phone = "88005553535";

        objOrderPage.setOrderPageFields(name, surname, address, phone);

        RentPageScooter objRentPage = new RentPageScooter(driver);
        objRentPage.setRentPageFields();
        objRentPage.clickYesToOrder();
        objRentPage.checkTitleOrderIssued();
    }

    @Test
    public void checkButtonOrder(){

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickDownOrderButton();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.checkOpenOrderPage();
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

}
