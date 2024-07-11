package steps;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cucumberBDD.SetUpWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class GoogleSearch {
	

	@Given("I am on the Google search page")
	public void I_visit_google() throws MalformedURLException { 
		SetUpWebDriver.driver.get().get("http://www.google.com");
		System.out.println(SetUpWebDriver.driver.get().getTitle());
		// driver.quit();

	}

	@When("I search for {string}")
	public void search_for(String keyword) {
		SetUpWebDriver.driver.get().findElement(By.name("q")).sendKeys(keyword, Keys.ENTER);
	}

	@Then("the page title should start with {string}")
	public void checkTitle(String titleStartsWith) {
		System.out.println(SetUpWebDriver.driver.get().getTitle().toLowerCase());


	}

	@Then("I validate that the page title should start with {string}")
	public void i_validate_that_the_page_title_should_start_with(String keyword) {
		System.out.println(SetUpWebDriver.driver.get().getTitle().toLowerCase());
		Assert.assertEquals(SetUpWebDriver.driver.get().getTitle().contains(keyword), true);

	}

	@Then("I search for below keywords")
	public void i_search_for_below_keywords(io.cucumber.datatable.DataTable dataTable) {
		// List type
		/*
		 * List<List<String>> listData = dataTable .asLists(String.class);
		 * System.out.println(listData.get(0).get(0));
		 * System.out.println(listData.get(1).get(0));
		 */
		// Maps
		List<Map<String, String>> mapData = dataTable.asMaps(String.class, String.class);
		System.out.println(mapData.get(0).get("keyword1"));

		SetUpWebDriver.driver.get().findElement(By.name("q")).sendKeys(mapData.get(1).get("keyword1") + " " + mapData.get(1).get("keyword2"),
				Keys.ENTER);

	}

}
