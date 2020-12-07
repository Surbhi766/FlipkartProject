package Runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = {"src/test/java/Features/Scenarios.feature"},
		tags = {"@GoogleSearch"},
		glue = {"StepDefinition"},		
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json"}
		)

public class Runner {

}
