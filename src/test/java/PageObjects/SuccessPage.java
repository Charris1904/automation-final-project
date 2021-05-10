package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessPage {

    private WebDriver driver;
    private By successMessage = By.xpath("//*[@id=\"content\"]/h1");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getText(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(successMessage))).getText();
    }
}
