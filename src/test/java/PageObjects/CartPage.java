package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(String productName){
        return driver.findElement(By.linkText(productName)).getText();
    }
}
