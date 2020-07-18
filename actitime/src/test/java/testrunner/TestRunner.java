package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/multirun.feature",
		glue = {"stepdefinition"},
		dryRun = false,
		monochrome = true
		)
public class TestRunner {

}