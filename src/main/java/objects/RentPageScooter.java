package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPageScooter {

    // драйвер
    private WebDriver driver;

    // поле ввода даты, когда привезти самокат
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // кнопка выбора даты в календаре
    private By chooseDateField = By.xpath(".//div[@aria-label='Choose среда, 17-е января 2024 г.']");

    //поле выбора времени аренды
    private By timeRentField = By.xpath(".//div[@class='Dropdown-placeholder']");

    //поле выбора количества суток аренды
    private By dayRentField = By.xpath(".//div[text()='сутки']");

    //поле выбора цвета
    private By colorBlackField = By.xpath(".//label[@for='black']");

    //поле для комментариев
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //кнопка заказа
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка подтверждения
    private By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //заголовок об оформлении заказа
    private By titleOrderIssued = By.xpath(".//div[text()='Заказ оформлен']");

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

    public void checkTitleOrderIssued() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(titleOrderIssued));
        driver.findElement(titleOrderIssued);
    }

}
