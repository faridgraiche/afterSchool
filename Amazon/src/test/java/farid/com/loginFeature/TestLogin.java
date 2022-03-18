package farid.com.loginFeature;

import farid.com.CommonAPI;
import farid.com.HomePage;
import farid.com.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertiesReader;

import java.util.Properties;

public class TestLogin extends CommonAPI {

    public Properties properties = PropertiesReader.readProperties("/Users/farid/eclipse-workspace/SecondAfterSchool/Amazon/src/test/resources/config.properties");
    public String signInTitle = properties.getProperty("signInTitle");
    public String userName = properties.getProperty("userName");
    public String passWord = properties.getProperty("passWord");
    public String errorMessage= properties.getProperty("errorMessage");

    @Test
    public void loginWithInvalidEmail(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.hoverOverHelloMenu();
        homePage.clickSignInButton();
        Assert.assertEquals(getTitle(),signInTitle);
        loginPage.enterEmail(userName);
        loginPage.clickOnContinue();
        loginPage.enterPassword(passWord);
        loginPage.clickOnSignInButton();

        Assert.assertEquals(loginPage.getErrorMessage(),errorMessage);
    }
}
