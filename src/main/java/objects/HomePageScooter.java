package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    // драйвер
    private final WebDriver driver;
    // кнопка заказать вверху
    public static final By upOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    // кнопка заказать внизу
    public static final By downOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButton(By orderButton) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(orderButton));
        driver.findElement(orderButton).click();
    }
}
