package testRunner;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = "src\\test\\java\\feature"
		,glue = "steps"
		,snippets = SnippetType.CAMELCASE
		,plugin= {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
		}
		
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

}
