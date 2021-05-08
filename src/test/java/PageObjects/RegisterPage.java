package PageObjects;

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

    public void setValuesRegister(String firstname, String lastname, String email, String telephone, String password, String confirmation,
                                  Boolean isSusbcribe, Boolean privacy) {
        driver.findElement(firstNameField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmation);
        if (isSusbcribe) {
            driver.findElement(subscribeCheckBoxYes).click();
        }else {
            driver.findElement(subscribeCheckBoxNo).click();
        }
        if (privacy) {
            driver.findElement(privacyPolicyCheckBox).click();
        }
    }

    public SuccessPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new SuccessPage(driver);
    }

}
