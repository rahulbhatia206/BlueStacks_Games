package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features = {
		 		"src/test/java/TestFeatures/VerifyGames.feature"
 			}, 
 glue= {"stepDefinations"},
// plugin = { "pretty", "html:CucumberReport" },
 monochrome = true
 )
public class TestRunner extends AbstractTestNGCucumberTests {

}
