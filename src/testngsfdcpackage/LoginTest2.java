package testngsfdcpackage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 

public class LoginTest2 extends TestBase{
 
    WebDriver driver;
 
    private WebDriver getDriver () {
        return driver = TLDriverFactory.getDriver();
    }
 
    @Test
    public void GOOGLE1() throws Exception {
        WebDriver driver = TLDriverFactory.getDriver();
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        //System.out.println("GOOGLE1-TEST - TLDriverFactory.getDriver(): " + driver);
        System.out.println("GOOGLE1-TEST - driver: " + driver);
        //System.out.println("Map Driver Google: " + driverMap.get(Long.valueOf(Thread.currentThread().getId())));
        System.out.println("Google1 Test's Page title is: " +  driver.getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals( driver.getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }
 
    @Test
    public void SFDC() throws Exception {
        WebDriver driver = TLDriverFactory.getDriver();
        
		System.out.println("Connected to Grid Successfully");
		driver.navigate().to("http://na3.salesforce.com");
		System.out.println("Navigated to SalesForce ");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("parantap.samajdar.iq@cognizant.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Cognizant@05");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        System.out.println("Logged Successfully into SalesForce");

    }
}