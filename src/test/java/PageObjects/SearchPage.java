package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    private WebDriver driver;
    private String productName;
    private By shoppingCartLink = By.linkText("Shopping Cart");
    private By addToCartLink = By.cssSelector(".button-group button:first-child");
    private By productCaption = By.xpath("//div[@class=\"caption\"]/h4");
    private By productLink = By.xpath("//div[@class=\"caption\"]/h4/a");

    public SearchPage(WebDriver driver, String productName) {
        this.driver = driver;
        this.productName = productName;
    }

    public void addProductToShoppingCart() {
        for (int i = 0; i <= 5; i++) {
            String caption = driver.findElement(productCaption).getText();
            if (caption.equals(productName)) {
                driver.findElement(addToCartLink).click();
                break;
            }
        }
    }

    public CartPage clickShoppingCartLink() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

    public ProductPage clickProduct() {
        ProductPage productPage = null;
        for (int i = 0; i <= 5; i++) {
            String caption = driver.findElement(productCaption).getText();
            if (caption.equals(productName)) {
                driver.findElement(productLink).click();
                productPage = new ProductPage(driver);
                break;
            }
        }
        return productPage;
    }

}
