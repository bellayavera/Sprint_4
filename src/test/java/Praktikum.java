import objects.HomePageScooter;
import objects.OrderPageScooter;
import objects.RentPageScooter;
import org.junit.Assert;
import org.junit.Test;

public class Praktikum extends SeleniumConfig {

    @Test
    public void checkSuccessOrderByTopButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOrderButton(HomePageScooter.upOrderButton);

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);

        String name = "Иван";
        String surname = "Иванов";
        String address = "г. Москва, ул. Московская, д.1";
        String phone = "12345678901";

        objOrderPage.setOrderPageFields(name, surname, address, phone);

        RentPageScooter objRentPage = new RentPageScooter(driver);
        objRentPage.setRentPageFields();
        objRentPage.clickYesToOrder();

        Assert.assertTrue("Не появилось сообщение об успешном создании заказа!", objRentPage.isDisplayedTitleOrderIssued());
    }

    @Test
    public void checkSuccessOrderByBottomButton() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickOrderButton(HomePageScooter.downOrderButton);

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);

        String name = "Андриана";
        String surname = "Шевченко";
        String address = "г. Москва, ул. Московская, д.1, кв.5";
        String phone = "88005553535";

        objOrderPage.setOrderPageFields(name, surname, address, phone);

        RentPageScooter objRentPage = new RentPageScooter(driver);
        objRentPage.setRentPageFields();
        objRentPage.clickYesToOrder();

        Assert.assertTrue("Не появилось сообщение об успешном создании заказа!", objRentPage.isDisplayedTitleOrderIssued());
    }
}
