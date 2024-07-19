package testRunner;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
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
	 
	 @BeforeClass
	 public void setUpDocker() throws IOException, InterruptedException {
			
		  Process p = Runtime.getRuntime(). exec("docker network create grid");
		  Thread.sleep(5000);
		  
		  Runtime.getRuntime().
		  exec("docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:4.10.0-20230607"
		  ); Thread.sleep(10000);
		  
		  Runtime.getRuntime().
		  exec("docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size=\"2g\" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 -e SE_NODE_MAX_SESSIONS=5 selenium/node-chrome:4.10.0-20230607"
		  ); Thread.sleep(10000);
	 }

}
