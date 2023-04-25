package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/Users/loyoladsouza/Desktop/QA/SeleniumWorkspace/CucumberCrashCourse/src/test/java/features/loginpage.feature", glue = {
		"/org/opencart/stepdefs" }, dryRun = false, plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json", }, monochrome = true, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
