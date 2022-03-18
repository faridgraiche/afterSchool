package farid.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonAPI {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    WebElement searchField;
    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"searchDropdownBox\"]")
    WebElement menuDropdown;
    @FindBy(css = "#searchDropdownBox option")
    List<WebElement> menuDropdownOption;
    @FindBy(xpath = "//*[text()='Account & Lists']")
    WebElement floatingMenu;
    @FindBy (xpath = "//span[contains(text(),'Watchlist')]")
    WebElement watchList;
    @FindBy(xpath = "(//span[text()='Sign in'])[1]")
    WebElement signInButton;


    public void searchElement(String itemToSearch) {
        type(searchField, itemToSearch);
        click(searchButton);
    }

    public void searchInOneClick(String itemToSearch) {
        typeAndEnter(searchField, itemToSearch);
    }

    public void searchInOneClickAndClear(String itemToSearch) {
        typeAndEnter(searchField, itemToSearch);
        clear(searchField);
    }

    public void selectFromDropdownOption(String option) {
        selectFromDropdown(menuDropdown, option);
    }

    public List<WebElement> selectFromDropdownOptions() {
        return getDropdownOption(menuDropdown);
    }

    public void selectFromDropdownOptionsList(String choice) {
        List<WebElement> dropdownList = menuDropdownOption;
        for (WebElement element : dropdownList) {
            if (element.getText().equals(choice)) {
                element.click();
            }
        }
    }
    public void hoverOverHelloMenu(){
        hoverOver(floatingMenu,driver);
    }

    public void clickOnWatchList(){
        clear(watchList);
    }

    public void clickSignInButton(){click(signInButton);}

}
