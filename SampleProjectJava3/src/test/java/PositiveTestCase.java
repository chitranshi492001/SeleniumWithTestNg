import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PositiveTestCase {
    WebDriver driver;
    PageClass obj=new PageClass();
    @BeforeClass
    @Parameters({"browser", "Url"})
    void setup(String browser, String app){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/cchoudhary/Downloads/chromedriver_mac64 (1)/chromedriver");
            driver =new ChromeDriver();
        }
        driver.get(app);
    }
    @Test(priority = 1)
    void maximizeWindow(){
        //To maximize the window
        driver.manage().window().maximize();
    }
    @Test(priority = 2, dataProvider = "LoginDataProvider1", dataProviderClass = PropertyFile.class)
    public void enterDetails(String email, String pwd) throws IOException {
        //To enter login credentials
        //For entering username
        driver.findElement(By.xpath(obj.username())).sendKeys(email);
        //for entering password
        driver.findElement(By.xpath(obj.password())).sendKeys(pwd);
        //For Click on submit
        driver.findElement(By.xpath(obj.loginbtn())).click();
        //Login page screenshot
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/loginpage1.jpeg");
        FileHandler.copy(src, trg);

    }
    @Test(priority = 3)
    void addToCart() throws IOException{
        //Add item to carts
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement item=wait.until(presenceOfElementLocated(By.xpath(obj.item1())));
        item.click();
        driver.findElement(By.xpath(obj.item2())).click();
        driver.findElement(By.xpath(obj.item3())).click();
        //Add to Cart Page screenshot
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/addtocartpg.jpeg");
        FileHandler.copy(src, trg);
    }
    @Test(priority = 4)
    public void scrollByCmd(){
        //To scroll the window
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }
    @Test(priority = 5)
    public void checkOutProcess() throws IOException{
        //To check out the process
        driver.findElement(By.xpath(obj.shopingCartLink())).click();
        // To click checkout button
        driver.findElement(By.xpath(obj.checkOut())).click();
        //checkout page screenshot
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/checkout.jpeg");
        FileHandler.copy(src, trg);

    }
    @Test(priority = 6)
    public void addInformation() throws IOException{
        // add information
        //To enter name
        driver.findElement(By.xpath(obj.firstName())).sendKeys("Chitranshi");
        //To enter lastname
        driver.findElement(By.xpath(obj.lastName())).sendKeys("Choudhary");
        //To enter postal-code
        driver.findElement(By.xpath(obj.postalCode())).sendKeys("456010");
        //To click continue
        driver.findElement(By.xpath(obj.continu())).click();
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/addinfo.jpeg");
        FileHandler.copy(src, trg);
        //To Print total of all the items
        WebElement total=driver.findElement(By.xpath(obj.summary()));
        File src1=ts.getScreenshotAs(OutputType.FILE);
        File trg1=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/summary.jpeg");
        FileHandler.copy(src1, trg1);
        System.out.println(total.getText());
        //Finish the checkout process
        driver.findElement(By.xpath(obj.finisg())).click();

        //redirect to product  page
        driver.findElement(By.xpath(obj.back())).click();

    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
