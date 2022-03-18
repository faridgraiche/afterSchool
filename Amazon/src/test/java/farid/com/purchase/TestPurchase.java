package farid.com.purchase;

import farid.com.CommonAPI;
import farid.com.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestPurchase extends CommonAPI {

    @Test
    public void addToCartAndCheckItem(){
        HomePage homePage = new HomePage(driver);

        Assert.assertEquals(getTitle(),"");
        homePage.searchElement("java book");
        Assert.assertEquals("","");

    }
}
