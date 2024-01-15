package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    // драйвер
    private WebDriver driver;
    // кнопка заказать вверху
    private By upOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    // кнопка заказать внизу
    private By downOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    public void clickDownOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(downOrderButton));
        driver.findElement(downOrderButton).click();
    }
}
