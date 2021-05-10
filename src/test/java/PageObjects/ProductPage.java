package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private By currencyDropdown = By.xpath("//button[@class=\"btn btn-link dropdown-toggle\"]/span");
    private By euroCurrency = By.xpath("//button[@name=\"EUR\"]");
    private By poundCurrency = By.xpath("//button[@name=\"GBP\"]");
    private By dollarCurrency = By.xpath("//button[@name=\"USD\"]");
    private By productPrice = By.xpath("//div[@class=\"col-sm-4\"]/ul[last()]/child::li/h2");
    private By currencySymbol = By.xpath("//button[@class=\"btn btn-link dropdown-toggle\"]/child::strong");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String selectCurrency(int count) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(currencyDropdown).click();
        switch (count) {
            case 1:
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(euroCurrency))).click();
                System.out.println("EUR");
                break;
            case 2:
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(poundCurrency))).click();
                System.out.println("GBP");
                break;
            case 3:
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(dollarCurrency))).click();
                System.out.println("USD");
                break;
        }
        return driver.findElement(currencySymbol).getText();
    }

    public String getProductPrice() {
        System.out.println("Product Price : " + driver.findElement(productPrice).getText());
        return driver.findElement(productPrice).getText();
    }
}
