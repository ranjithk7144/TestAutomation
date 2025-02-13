package stepRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/features"},
		glue= {"stepDefinitions", "appHooks"},
		plugin={"pretty"},
		monochrome = true)
public class MyTestRunner {

}
