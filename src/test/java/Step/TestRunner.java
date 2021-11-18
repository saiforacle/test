package Step;

import org.junit.runner.RunWith;
//import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/GLReconEngine",glue= {"Step"}
,tags= "@smoke")
public class TestRunner {
	
}
