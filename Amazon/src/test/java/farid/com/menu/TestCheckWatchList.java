package farid.com.menu;

import farid.com.CommonAPI;
import farid.com.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCheckWatchList extends CommonAPI {

    @Test
    public void checkWatchList(){
        HomePage homePage = new HomePage(driver);

       homePage.hoverOverHelloMenu();
       homePage.clickOnWatchList();
        Assert.assertEquals(getTitle(),"Amazon Sign-In");
    }
}
