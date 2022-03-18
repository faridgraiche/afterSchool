package farid.com.search;

import farid.com.CommonAPI;
import farid.com.HomePage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSearchMultipleItems extends CommonAPI {


    public static List<String> getItemValues(){
        List<String> itemList = new ArrayList<>();
        itemList.add("java books");
        itemList.add("selenium books");
        itemList.add("laptop");
        itemList.add("flowers");
        itemList.add("ps5");
        itemList.add("iphone");
        itemList.add("soccer ball");

        return itemList;
    }
    @Test
    public void searchItems(){
        HomePage homePage = new HomePage(driver);

        List<String> items = getItemValues();
        for (String item:items) {
            homePage.searchInOneClickAndClear(item);

        }

    }
}
