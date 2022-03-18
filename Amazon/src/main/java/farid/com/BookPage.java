package farid.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookPage extends CommonAPI{

    public BookPage(WebDriver driver){
        this. driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "")
    WebElement addCartButton;

    public void clickOnAddCartButton(){click(addCartButton);}
}
