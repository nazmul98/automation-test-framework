package orange.ny.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {"pretty","json:target/cucumber.json" },		
		//plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
		//format ="",		
		features = {".//Fetatures/"}, 
        glue = {"orange.ny.stepdef","orange.ny.hooks"}, 
		//glue = {"orange.ny.stepdef"}, 
		dryRun = false, 
		monochrome = true, 
		strict = false,
		tags = {"@Smoke"})

public class MyRunner extends AbstractTestNGCucumberTests {

}
