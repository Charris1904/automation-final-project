package Tests;

import DataProvider.RegisterDataProvider;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import PageObjects.SuccessPage;
import Pojo.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterTests extends BaseTests {

    @Test(groups = {"register"},
            dataProvider = "getRegistersDataFromJson",
            dataProviderClass = RegisterDataProvider.class)
    public void testUserRegister(User user) {
        try {
            HomePage homePage = new HomePage(driver);
            RegisterPage registerPage = homePage.clickRegisterPage();
            registerPage.setValuesRegister(user);
            SuccessPage successPage = registerPage.clickContinueButton();
            assertTrue(successPage.getText().contains("Your Account Has Been Created!"));
            System.out.println("User " + user.getFirstName() + " has been registered : " + user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            recordFailure("testUserRegister");
            Assert.fail();
        }
    }
}
