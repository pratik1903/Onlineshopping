


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testmeapp.utility.Drivers;



public class OnlineShoppingTest {
	WebDriver pratik;
    ExtentHtmlReporter htmlReporter;  
    ExtentReports extent;
    ExtentTest logger;
    
	
  @AfterTest
  public void endReportAfterTest() {
	  extent.flush();	  
  }
  @AfterMethod
  public void getResultAfterMethod(ITestResult result) throws IOException {
	  
	  if(result.getStatus() == ITestResult.FAILURE) {
          logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
        
      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
      }
      else {
          logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
          logger.skip(result.getThrowable());
      }
	 
  }
  @BeforeTest
  public void startReportBeforeTest() {
//  logger = extent.createTest("Test Case 1", "PASSED test case"); 
//	  WebDriver pratik;
//	  pratik=Drivers.getDriver("Chrome");
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport23.html"); 
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
      htmlReporter.config().setDocumentTitle("Extent Report Demo");
      htmlReporter.config().setReportName("Test Report");
      htmlReporter.config().setTheme(Theme.DARK);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
  }
  @Test(priority=3)
  public void testCart() throws InterruptedException {
	  logger = extent.createTest("Test Case 1", "PASSED test case"); 
	 // WebDriver pratik;
	  testLogin();
	  //pratik=Drivers.getDriver("Chrome");
  WebElement trgt_1=pratik.findElement(By.xpath("//span[text()='Electronics]"));
  WebElement trgt_2=pratik.findElement(By.xpath("//span[text()='Head Phone']"));
  Actions act=new Actions(pratik);
  act.moveToElement(trgt_1).build().perform();
  Thread.sleep(3000);
  trgt_2.click();
  Thread.sleep(3000);
  pratik.findElement(By.xpath("//a[@class='btn btn-success btn-product']")).click();
  pratik.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
  pratik.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
  pratik.findElement(By.name("ShippingAdd")).sendKeys("gachibowli");
  pratik.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
  
  
  }
  @Test(priority=2)
    public void testLogin() {
 
     logger = extent.createTest("Test Case 1", "PASSED test case"); 
	 // WebDriver pratik;
	  pratik=Drivers.getDriver("Chrome");
	  pratik.get("http://10.232.237.143:443/TestMeApp/");
	  pratik.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	  pratik.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("lalitha");
	  pratik.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password123");
	  pratik.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	 
	 
  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	  testLogin();
	  testCart();
	  logger = extent.createTest("Test Case 1", "PASSED test case"); 
	  //WebDriver pratik;
	 // pratik=Drivers.getDriver("Chrome");
	  pratik.findElement(By.xpath("//*[@id=\"swit\"]/div[3]/div/label")).isSelected();
	  pratik.findElement(By.xpath("//*[@id=\"btn\"]")).click();
	  pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("Pratik007");
	  pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pratik123");
	  pratik.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  
  }
  @Test(priority=1)
  public void testRegistration() {
	  logger = extent.createTest("Test Case 1", "PASSED test case"); 
	  //WebDriver pratik;
	  pratik=Drivers.getDriver("Chrome");
	  pratik.get("http://10.232.237.143:443/TestMeApp/");
	  pratik.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  pratik.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("9813vs");
	  pratik.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("vaish");
	  pratik.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("singh");
	  pratik.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("vs9813");
	  pratik.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("vs9813");
	  pratik.findElement(By.xpath("/html/body/main/div/div/form/fieldset/div/div[6]/div/div/label/span[1]")).isSelected();
	  pratik.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("vaish.singh96@gmail.com");
	  pratik.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("7972855071");
	  pratik.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("19/03/1996");
	  pratik.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("gachibowli");	  
	  WebElement s_que =  pratik.findElement(By.xpath("//select[@name='securityQuestion']"));
	  Select e2=new Select(s_que);
	  e2.selectByValue("411011");
	  WebElement color = pratik.findElement(By.xpath("//*[@id=\"answer\"]"));
	  color.sendKeys("red");
	  pratik.findElement(By.xpath("//input[@name='Submit'] ")).click();	
	  pratik.close();	  
  }
}
