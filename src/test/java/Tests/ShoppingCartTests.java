package Tests;

import DataProvider.ShoppingCartDataProvider;
import org.testng.annotations.Test;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import Pojo.Product;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTests extends BaseTests {

    @Test(groups = {"search"},
            dataProvider = "getSearchProductsDataFromJson",
            dataProviderClass = ShoppingCartDataProvider.class)
    public void testAddProductToShoppingCart(Product product){
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = homePage.searchProduct(product.getName());
        searchPage.addProductToShoppingCart(product.getName());
        CartPage cart = searchPage.clickShoppingCartLink();
        assertTrue(cart.getProductName(product.getName()).equals(product.getName()));
    }
}
