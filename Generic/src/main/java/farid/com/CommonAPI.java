package farid.com;


import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utility.PropertiesReader;
//import utility.GetProperties;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver;

    Properties prop = PropertiesReader.readProperties("/Users/farid/eclipse-workspace/SecondAfterSchool/Amazon/src/test/resources/config.properties");
    String browserstackUsername = prop.getProperty("browserstackUsername");
    String browserstackPassword = prop.getProperty("browserstackPassword");



    public static com.relevantcodes.extentreports.ExtentReports extent;

    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName());
        }
        driver.quit();
    }
    @AfterSuite
    public void generateReport() {
        extent.close();
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    @Parameters({"useCloudEnv","cloudEnvName","OS","os_version","browserName","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional String cloudEnvName,
                      @Optional("windows") String OS,@Optional("10") String os_version,
                      @Optional("chrome")  String browserName,@Optional("34")String browserVersion,
                      @Optional("https://google.com")  String url) throws MalformedURLException {
        if (useCloudEnv == true){
            if (cloudEnvName.equalsIgnoreCase("browserstack")){
                getCloudDriver(cloudEnvName,browserstackUsername,browserstackPassword,"","","","");
            }else if(cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,"","","","","","");
            }

        }else {
            getLocalDriver(OS,browserName);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);

    }

    public WebDriver getLocalDriver(String OS, String browserName){
    if(browserName.equalsIgnoreCase("chrome")){
        if(OS.equalsIgnoreCase("windows")){
            System.setProperty("webdriver.chrome.driver","/Users/farid/eclipse-workspace/SecondAfterSchool/Generic/src/drivers/chromedriver 2");
        }else if(OS.equalsIgnoreCase("mac")){
            System.setProperty("webdriver.chrome.driver","/Users/farid/eclipse-workspace/SecondAfterSchool/Generic/src/drivers/chromedriver 2");

        }
        driver = new ChromeDriver();


    }else if (browserName.equalsIgnoreCase("firefox")){
        if (OS.equalsIgnoreCase("windowa")){
            System.setProperty("webdriver.gecko.driver","/Users/farid/eclipse-workspace/SecondAfterSchool/Generic/src/drivers/chromedriver 2");
        }else if(OS.equalsIgnoreCase("mac")){
            System.setProperty("webdriver.gecko.driver","/Users/farid/eclipse-workspace/SecondAfterSchool/Generic/src/drivers/chromedriver 2");
        }
        driver = new FirefoxDriver();
    }
    return driver;
    }

    public WebDriver getCloudDriver(String envName, String envUsername,String envAccessKey, String os, String os_version, String browserName, String browserVersion ) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        cap.setCapability("OS", os);
        cap.setCapability("os_version", os_version);
        if (envName.equalsIgnoreCase("saucelabs")){
            driver = new RemoteWebDriver(new URL("http://"+envUsername + ":" + envAccessKey + "@ondemand.saucelabs.com:80/wd/hub"),cap);
        }else if(envName.equalsIgnoreCase("browserstack")){

            cap.setCapability("resolution","1024x768");
            driver = new RemoteWebDriver(new URL("http://"+envUsername + ":" + envAccessKey + "@hub-cloud.browserstack.com:80/wd/hub"),cap);

        }

        return driver;
    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clear(WebElement element){
          element.clear();
    }

    public void type(WebElement element, String text){
        element.sendKeys(text);
    }

    public void typeAndEnter(WebElement element,String text){
        element.sendKeys(text,Keys.ENTER);
    }

    public String getTitle(){

        return driver.getTitle();
    }

    public String  getText(WebElement element){
        String text;
        text =  element.getText();
        return text;
    }



    //for only if we have select.
    public void selectFromDropdown(WebElement element, String text){
            Select select = new Select(element);
            try {
                select.selectByVisibleText(text);
            }catch (Exception e){
                select.selectByValue(text);
            }

    }

    public void waitFor(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hoverOver(WebElement element, WebDriver driver){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }

    public List<WebElement> getDropdownOption(WebElement element){
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        return list;
    }



    public void pressEnter(WebElement element) {
            element.sendKeys(Keys.ENTER);
    }

    public void checkIfChecked(WebElement element) {
            Assert.assertTrue(element.isSelected());
    }

    public void checkIfNotChecked(WebElement element) {
            Assert.assertFalse(element.isSelected());

    }

    public void checkIfVisible(WebElement element) {
            Assert.assertTrue(element.isDisplayed());

    }

    public void checkIfNotVisible(WebElement element) {
            Assert.assertFalse(element.isDisplayed());
    }

    public void checkIfEnabled(WebElement element) {
            Assert.assertTrue(element.isEnabled());

    }
    public void checkIfNotEnabled(WebElement element) {
            Assert.assertFalse(element.isEnabled());

    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void scrollToView(WebElement element){
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true)", element);
        }



    public void switchToFrame(String id){
        try {
            driver.switchTo().frame(id);
        }catch (Exception e){
            driver.switchTo().frame(Integer.parseInt(id));
        }

    }

    public void captureScreenshot() {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("screenshots/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshot(String screenshotName){
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+File.pathSeparator+ "screenshots"+File.pathSeparator+screenshotName+" "+df.format(date)+".png"));

            System.out.println("Screenshot captured");
        } catch (Exception e) {
            String path = System.getProperty("user.dir")+ "/screenshots/"+screenshotName+" "+df.format(date)+".png";
            System.out.println(path);
            System.out.println("Exception while taking screenshot "+e.getMessage());;
        }
    }

}


