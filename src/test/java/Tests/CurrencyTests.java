package Tests;

import DataProvider.ProductDataProvider;
import PageObjects.HomePage;
import PageObjects.ProductPage;
import PageObjects.SearchPage;
import Pojo.Product;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CurrencyTests extends BaseTests {

    @Test(groups = {"currency"},
            dataProvider = "getProductsDataFromJson",
            dataProviderClass = ProductDataProvider.class)
    public void testProductCurrency(Product product) {
        HomePage homePage = new HomePage(driver, product.getName());
        SearchPage searchPage = homePage.searchProduct();
        ProductPage productPage = searchPage.clickProduct();
        System.out.println("---------------- " + product.getName() + " ----------------");
        for (int i = 1; i <= 3; i++) {
            String currency = productPage.selectCurrency(i);
            System.out.println("Currency Symbol : " + currency);
            assertTrue(productPage.getProductPrice().contains(currency));
        }
    }
}
