package farid.com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//public class RahaulTest extends CommonAPI{
//
//    @Test
//    public void radiobutton(){
//       List<WebElement> radioButtons = webElementList("//*[@name='radioButton']");
//        for (WebElement radioButton: radioButtons) {
//            radioButton.click();
//        }
//
//    }
//
//
//
//
//
//
//    @Test
//    public void suggestionDropdown(){
//
//        type("//*[@id='autocomplete']","can");
//        for (int i = 0; i < 4; i++) {
//            driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
//        }
//        driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys(Keys.ENTER);
//        waitFor(2);


//        type("//*[@id='autocomplete']","can");
//        List<WebElement> element = driver.findElements(By.xpath("//*[@class=\"ui-menu-item\"]"));
//        for (WebElement option:element) {
//            if (option.getText().equals("Central African Republic")){
//                option.click();
//            }
//            waitFor(1);
//
//        }

//    }
//
//    @Test
//    public void staticDropdown() {
//
//        selectFromDropdown("//*[@id='dropdown-class-example']","option2");
//
//    }
//
//    @Test
//    public void checkBox(){
//
//        List<WebElement> element = driver.findElements(By.xpath("//label//input[@type=\"checkbox\"]"));
//        for(WebElement option:element){
//            option.click();
//        }
//        for(int i = 0; i<element.size(); i++){
//            if (i==1){
//                Assert.assertTrue(element.get(i).isSelected());
//                element.get(i).click();
//                Assert.assertFalse(element.get(i).isSelected());
//
//            }
//
//        }
//
//    }
//
//
//    @Test
//    public void switchWindow() {
//        click("//*[@id='openwindow']");
//
//        String parentWindow = driver.getWindowHandle();
//
//        Set<String> listWindow = driver.getWindowHandles();
//        for(String window:listWindow){
//            if(!parentWindow.contentEquals(window)){
//                driver.switchTo().window(window);
//                break;
//            }
//
//        }
//        click("//*[text()='Login']");
//    }
//
//    @Test
//    public void handleTab(){
//        click("//*[@id=\"opentab\"]");
//
//
//        Set<String> windowHandle = driver.getWindowHandles();
//        Iterator<String> iterator = windowHandle.iterator();
//        while(iterator.hasNext()){
////            String parentTab = iterator.next();
//            String newTab =  iterator.next();
//            driver.switchTo().window(newTab);
//
//        }
//        click("//*[text()='Login']");
//        Assert.assertEquals(getTitle(),"Rahul Shetty Academy");
//        waitFor(2);
//
//
//    }
//    @Test
//    public void handleAlert(){
//        type("//*[@id=\"name\"]","farid");
//        click("//*[@id=\"confirmbtn\"]");
//        waitFor(2);
//        driver.switchTo().alert().dismiss();
//        waitFor(3);
//
//    }
//
//    @Test
//    public void webTable(){
//        System.out.println(driver.findElement(By.xpath("//*[@name='courses']//tr[7] //td[2]")).getText());
//
//    }
//
//    @Test
//    public void hideOrShow(){
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"displayed-text\"]")).isDisplayed());
//        click("//*[@id=\"hide-textbox\"]");
//        waitFor(2);
//        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"displayed-text\"]")).isDisplayed());
//        click("//*[@id=\"show-textbox\"]");
//        waitFor(2);
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"displayed-text\"]")).isDisplayed());
//    }
//
//    @Test
//    public void webTable2(){
//        scrollToView("//*[@class=\"tableFixHead\"]//tr[9]");
//        System.out.println(driver.findElement(By.xpath("//*[@class=\"tableFixHead\"]//tr[9]")).getText());
//        waitFor(3);
//
//    }
//
//    @Test
//    public void textManipulation(){
//        String text = driver.findElement(By.xpath("//*[@class=\"totalAmount\"]")).getText();
//        String newText = text.replaceAll("[^0-9]","");
//        System.out.println(newText);
//    }
//    @Test
//    public void mouseHover(){
//        JavascriptExecutor js = ((JavascriptExecutor)driver);
//        js.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//*[@id='mousehover']")));
//        hoverOver("//*[@id='mousehover']");
//        waitFor(1);
//        click("//*[text()='Top']");
//        waitFor(2);
//    }
//
//}
