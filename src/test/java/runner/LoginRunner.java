package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/"
        //, format = {"pretty", "html:target/site/serenity", "json:target/cucumber.json"}
        , glue = "stepdef")
public class LoginRunner {
}
