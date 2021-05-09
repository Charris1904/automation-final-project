package Tests;

import DataProvider.RegisterDataProvider;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import PageObjects.SuccessPage;
import Pojo.Usuario;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterTests extends BaseTests {

    @Test(groups = {"register"},
            dataProvider = "getRegistersDataFromJson",
            dataProviderClass = RegisterDataProvider.class)
    public void testUserRegister(Usuario usuario) {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegisterPage();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setValuesRegister(usuario);
        SuccessPage successPage = registerPage.clickContinueButton();
        assertTrue(successPage.getText().contains("Your Account Has Been Created!"));
    }
}