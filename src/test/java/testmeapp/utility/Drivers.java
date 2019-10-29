package testmeapp.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {

	public static WebDriver getDriver(String browser) {
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
		else 
		{
			System.setProperty("webdriver.ie.driver","C:\\MyDrivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}

	}

}
