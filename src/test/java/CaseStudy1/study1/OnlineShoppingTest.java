package CaseStudy1.study1;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Webpratik;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
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

import junit.framework.Assert;
import testmeapp.utility.Drivers;
//import testmeapp.utility.pratiks;



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
  logger = extent.createTest("TC_03", "Application Accessibility");
	 pratik.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();
	 pratik.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();
	 Thread.sleep(3000);;
	 pratik.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
	 pratik.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	 
	 pratik.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	 

  }
  @Test(priority=2)
    public void testLogin() {
 
    	logger = extent.createTest("TC_02", "Application Accessibility");
		// driver=Mydriver.getDriver("CR");
	 //driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 //driver.findElement(By.xpath("//a[@href='login.htm']")).click();
		 pratik.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("kakak1234671");
		 pratik.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gaitonde123");
		 pratik.findElement(By.xpath("//input[@value='Login']")).click();

	  
  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
  
//driver=Mydriver.getDriver("CR");
		//driver.get("http://10.232.237.143:443/TestMeApp/displayCart.htm");
		logger = extent.createTest("TC_04", "Application Accessibility");
		 pratik.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		 pratik.findElement(By.xpath("//*[@id=\"add1\"]")).sendKeys("gsadfashdfsaghdhadhagd");
		 Thread.sleep(3000);;
		 pratik.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	 
	//	 driver.get(" http://10.232.237.143:443/PaymentGateway/getOrderDetails.htm");
		Thread.sleep(3000);
		pratik.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		pratik.findElement(By.xpath("//*[@id=\"btn\"]")).click(); 
		pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
		pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
		pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
		pratik.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
		pratik.findElement(By.xpath("//input[@value='PayNow']")).click();
		pratik.findElement(By.xpath("/html/body/header/div/div/ul/b/a[2]")).click();
		 Thread.sleep(3000);
		 Assert.assertEquals("Home",pratik.getTitle());
//		 
//		 driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span")).click();
//		 driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
//		 
//		 driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
  }

  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
	  logger = extent.createTest("TC_01", "Application Accessibility");
	  
	  pratik=Drivers.getDriver("Chrome");
	  pratik.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  pratik.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	  WebElement  wb1= pratik.findElement(By.xpath("//*[@id=\"userName\"]"));
	  Actions act1=new Actions(pratik);
	act1.keyDown(wb1,Keys.ALT).sendKeys("kakak234671").keyUp(Keys.ALT).sendKeys(Keys.ENTER).build().perform();
	
	System.out.println("ffff");
	WebElement wb2=pratik.findElement(By.xpath("//*[@id='err']"));
	String s1=wb2.getText();
	System.out.println(s1);
	if (s1.equals("Available"))
	{
		Thread.sleep(3000);
		pratik.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Ganesha");
		pratik.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Gaitonde");
		pratik.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gaitonde123");
		pratik.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("Gaitonde123");
		pratik.findElement(By.xpath("//input[@value='Male']")).click();
		pratik.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("ganesh@gmail.com");
		pratik.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("7894561236");
		pratik.findElement(By.xpath("//img[@title='Ch']")).click();
		WebElement month=pratik.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
		Select sell=new Select(month);
		sell.selectByIndex(6);
		WebElement year=pratik.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
		Select sell1=new Select(year);
		sell1.selectByIndex(15);
		pratik.findElement(By.xpath("//a[text()='23']")).click();
		pratik.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("hgdsssdcvdsc");
		WebElement ele=pratik.findElement(By.xpath("//*[@id=\"securityQuestion\"]"));
		ele.click();

		act1.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		
		pratik.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("KITTU");
		pratik.findElement(By.xpath("//input[@name='Submit']")).click();
	
	}
	else
	{
		System.out.println("Already Exist");
	}
	
	System.out.println(s1);
	
 

	  
	  
  }
}
