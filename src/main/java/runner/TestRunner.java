package runner;

 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/java/org/assignment/assignment1/ClearTripAmazon.feature"
 ,tags = "@Smoke",glue={"assignment2"}
 )
 
public class TestRunner {
 
}