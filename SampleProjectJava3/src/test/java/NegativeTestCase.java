import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class NegativeTestCase {
    WebDriver driver;
    PageClass obj1=new PageClass();
    @BeforeClass
    @Parameters({"browser", "Url"})
    void setup(String browser, String app){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","/Users/cchoudhary/Downloads/chromedriver_mac64 (1)/chromedriver");
            driver =new ChromeDriver();
        }
        driver.get(app);
    }

    @Test(priority = 1, dataProvider = "LoginDataProvider2", dataProviderClass = PropertyFile.class)
    void login(String email, String pwd) throws IOException {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/loginpg.jpeg");
        FileHandler.copy(src, trg);

    }
    @Test(priority = 2)
    void printErrorMsg() throws IOException{
        WebElement msg=driver.findElement(By.cssSelector(obj1.error()));
        System.out.println("Error message for negative testcase: ");
        System.out.println(msg.getText());
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File trg=new File("/Users/cchoudhary/Desktop/JavaLearn/SampleProjectJava3/src/test/resources/errormsg.jpeg");
        FileHandler.copy(src, trg);
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
