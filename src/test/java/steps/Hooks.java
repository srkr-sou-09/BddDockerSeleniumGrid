package steps;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumberBDD.SetUpWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {
	
	@BeforeMethod
	public void startUp() throws IOException, InterruptedException {
		System.out.println("@@@@Before Hook@@@@");
		
		
		  Process p = Runtime.getRuntime(). exec("docker network create grid");
		  Thread.sleep(5000);
		  
		  Runtime.getRuntime().
		  exec("docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:4.10.0-20230607"
		  ); Thread.sleep(10000);
		  
		  Runtime.getRuntime().
		  exec("docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size=\"2g\" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 -e SE_NODE_MAX_SESSIONS=5 selenium/node-chrome:4.10.0-20230607"
		  ); Thread.sleep(10000);
		 
		
		
			/*
			 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
			 * ChromeOptions();
			 * 
			 * //options.addArguments("--headless",
			 * "--disable-gpu","--window-size=1920,1200", "--ignore-certificate-errors");
			 * 
			 * options.addArguments("--remote-allow-origins=*");
			 * SetUpWebDriver.driver.set(new ChromeDriver(options));
			 * 
			 * SetUpWebDriver.driver.get().manage().window().maximize();
			 * SetUpWebDriver.driver.get().get("https://google.com");
			 * 
			 */

		
			
			  ChromeOptions chromeOptions = new ChromeOptions(); //
			  chromeOptions.setCapability("browserName", "chrome");
			  //chromeOptions.setCapability("platformName", "Windows 11"); 
			  // Showing a test 
			  SetUpWebDriver.driver.set( new RemoteWebDriver(new
			  URL("http://localhost:4444"), chromeOptions));
			 
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("@@@@After Hook@@@@");
		//driver.close();
		SetUpWebDriver.driver.get().quit();
		SetUpWebDriver.driver.remove();
	}

}
