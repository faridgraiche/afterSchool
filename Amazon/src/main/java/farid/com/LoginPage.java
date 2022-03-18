package farid.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonAPI{

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//*[@id=\"ap_email\"]")
    WebElement emailField;
    @FindBy(xpath = "//input[@id=\"continue\"]")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id=\"ap_password\"]")
    WebElement password;
    @FindBy(xpath = "//input[@id=\"signInSubmit\"]")
    WebElement signInButton;
    @FindBy(xpath = "//*[text()='There was a problem']")
    WebElement errorMessage;



    public void enterEmail(String email){type(emailField,email);}
    public void clickOnContinue(){click(continueButton);}
    public void enterPassword(String pass){type(password,pass);}
    public void clickOnSignInButton(){click(signInButton);}

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
