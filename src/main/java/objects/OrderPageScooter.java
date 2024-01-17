package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {

    //драйвер
    private final WebDriver driver;
    // поле ввода имени
    private static final By nameField = By.xpath(".//input[@placeholder='* Имя']");

    // поле ввода фамилии
    private static final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле ввода адреса
    private static final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле выбора станции метро
    private static final By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");

    // поле станции Красносельская
    private static final By subwayStation = By.xpath(".//li[@class='select-search__row' and @data-value='5']");

    // поле ввода номера телефона
    private static final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка далее
    private static final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageScooter (WebDriver driver){
        this.driver = driver;
    }

    public void setOrderPageFields(String name, String surname, String address, String phone){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(subwayField).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(subwayStation));
        driver.findElement(subwayStation).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }
}


