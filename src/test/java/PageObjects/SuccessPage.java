package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {

    private WebDriver driver;
    private By successMessage = By.xpath("//*[@id=\"content\"]/h1");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getText(){
        return driver.findElement(successMessage).getText();
    }
}
