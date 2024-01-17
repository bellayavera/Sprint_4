package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPageScooter {

    // драйвер
    private final WebDriver driver;

    // поле ввода даты, когда привезти самокат
    private static final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // кнопка выбора даты в календаре
    private static final By chooseDateField = By.xpath(".//div[@aria-label='Choose среда, 17-е января 2024 г.']");

    //поле выбора времени аренды
    private static final By timeRentField = By.xpath(".//div[@class='Dropdown-placeholder']");

    //поле выбора количества суток аренды
    private static final By dayRentField = By.xpath(".//div[text()='сутки']");

    //поле выбора цвета
    private static final By colorBlackField = By.xpath(".//label[@for='black']");

    //поле для комментариев
    private static final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка заказа
    private static final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка подтверждения
    private static final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //заголовок об оформлении заказа
    private static final By titleOrderIssued = By.xpath(".//div[text()='Заказ оформлен']");

    public RentPageScooter (WebDriver driver){
        this.driver = driver;
    }

    public void setRentPageFields() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(dateField));
        driver.findElement(dateField).click();
        driver.findElement(chooseDateField).click();
        driver.findElement(timeRentField).click();
        driver.findElement(dayRentField).click();
        driver.findElement(colorBlackField).click();
        driver.findElement(commentField).sendKeys("comment");
        driver.findElement(orderButton).click();
    }

    public void clickYesToOrder() {
        driver.findElement(yesButton).click();
    }

    public boolean isDisplayedTitleOrderIssued() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(titleOrderIssued));
        return driver.findElement(titleOrderIssued).isDisplayed();
    }

}
