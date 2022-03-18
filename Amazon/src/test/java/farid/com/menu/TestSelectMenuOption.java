package farid.com.menu;

import farid.com.CommonAPI;
import farid.com.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelectMenuOption extends CommonAPI {
    @Test
    public void clickOnBabyWithSelect() {
        HomePage homePage = new HomePage(driver);

        homePage.selectFromDropdownOption("books");

    }

    @Test
    public void getDropdownListWithOutSelect() {
        HomePage homePage = new HomePage(driver);
        List<WebElement> listOfElements = homePage.selectFromDropdownOptions();

        for (WebElement element:listOfElements) {
            if (element.getText().equals("Books")){
                element.click();
            }
        }
    }

}
