package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By myAccountLink = By.linkText("My Account");
    private By registerLink = By.linkText("Register");
    private By searchBar = By.xpath("//input[@type=\"text\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage clickRegisterPage(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.findElement(myAccountLink).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(registerLink))).click();
        return new RegisterPage(driver);
    }

    public SearchPage searchProduct(String productName){
        driver.findElement(searchBar).sendKeys(productName, Keys.ENTER);
        return new SearchPage(driver);
    }
}
