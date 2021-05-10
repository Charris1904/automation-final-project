package Tests;

import DataProvider.ProductDataProvider;
import org.testng.annotations.Test;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import Pojo.Product;

import static org.testng.AssertJUnit.assertTrue;

public class ShoppingCartTests extends BaseTests {

    @Test(groups = {"search"},
            dataProvider = "getProductsDataFromJson",
            dataProviderClass = ProductDataProvider.class)
    public void testAddProductToShoppingCart(Product product){
        HomePage homePage = new HomePage(driver, product.getName());
        SearchPage searchPage = homePage.searchProduct();
        searchPage.addProductToShoppingCart();
        CartPage cart = searchPage.clickShoppingCartLink();
        assertTrue(cart.getProductName(product.getName()).equals(product.getName()));
        System.out.println("Product : " + product.getName() + " found in Shopping Cart");
    }
}
