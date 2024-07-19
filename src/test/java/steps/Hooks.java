package steps;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumberBDD.SetUpWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Hooks {
	
	@Before
	public void startUpDocker() throws IOException, InterruptedException {
		System.out.println("@@@@Before Hook@@@@");
		

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
		  SetUpWebDriver.driver.set( new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions));
	}
	

	@After
	public void tearDown() {
		System.out.println("@@@@After Hook@@@@");
		//driver.close();
		SetUpWebDriver.driver.get().quit();
		SetUpWebDriver.driver.remove();
	}

}
