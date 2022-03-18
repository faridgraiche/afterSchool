package farid.com.search;

import farid.com.CommonAPI;
import farid.com.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.PropertiesReader;

import java.util.Properties;


public class TestSearchSingleItem extends CommonAPI {

    public Properties properties = PropertiesReader.readProperties("/Users/farid/eclipse-workspace/SecondAfterSchool/Amazon/src/test/resources/config.properties");
    public String homePageTitle = properties.getProperty("homePageTitle");
    public String seleniumTitle = properties.getProperty("seleniumTitle");
    public String javaTitle= properties.getProperty("javaTitle");
    public String computerTitle= properties.getProperty("computerTitle");



    @Test
    public void searchSeleniumBook() {
        HomePage homePage = new HomePage(driver);
        homePage.searchElement("selenium book");
        Assert.assertEquals(getTitle(),seleniumTitle);
    }

    @Test
    public void searchJavaBook() {
        HomePage homePage = new HomePage(driver);
        String expectedTitle = homePageTitle;
        homePage.searchElement("java book");
        Assert.assertEquals(getTitle(),javaTitle);


    }

    @Test
    public void searchComputer(){
        HomePage homePage = new HomePage(driver);
        homePage.searchInOneClick("computer");
        Assert.assertEquals(getTitle(),computerTitle);
    }

}
