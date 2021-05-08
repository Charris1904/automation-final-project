package Tests;

import DataProvider.CurrencyDataProvider;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import Pojo.Product;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CurrencyTests extends BaseTests {

    @Test(groups = {"currency"},
            dataProvider = "getCurrencyDataFromJson",
            dataProviderClass = CurrencyDataProvider.class)
    public void testProductCurrency(Product product) {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.searchProduct(product.getName());
        ProductPage productPage = searchPage.clickProduct(product.getName());
        for (int i = 1; i <= 3; i++) {
            System.out.println("---------------- " + product.getName() + " ----------------");
            String currency = productPage.selectCurrency(i);
            assertTrue(productPage.getProductPrice().contains(currency));
        }
    }
}
