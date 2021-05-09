package PageObjects;

import Pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;
    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By telephoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By subscribeCheckBoxYes = By.xpath("//input[@name=\"newsletter\" and @value=\"1\"]");
    private By subscribeCheckBoxNo = By.xpath("//input[@name=\"newsletter\" and @value=\"0\"]");
    private By privacyPolicyCheckBox = By.xpath("//input[@name=\"agree\"]");
    private By continueButton = By.xpath("//input[@type=\"submit\"]");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void setValuesRegister(User user) {
        driver.findElement(firstNameField).sendKeys(user.getFirstName());
        driver.findElement(lastNameField).sendKeys(user.getLastName());
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(telephoneField).sendKeys(user.getTelephone());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(confirmPasswordField).sendKeys(user.getConfirmPassword());
        if (user.getSubscribe()) {
            driver.findElement(subscribeCheckBoxYes).click();
        }else {
            driver.findElement(subscribeCheckBoxNo).click();
        }
        if (user.getPrivacyPolicy()) {
            driver.findElement(privacyPolicyCheckBox).click();
        }
    }

    public SuccessPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new SuccessPage(driver);
    }

}
