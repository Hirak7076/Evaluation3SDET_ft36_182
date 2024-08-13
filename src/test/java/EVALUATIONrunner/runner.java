package EVALUATIONrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "C:\\Users\\User\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\EVALUATION3SDET_HIRAK\\src\\test\\resources\\EVALUATION\\EVALUATION.feature",
		glue = "EVALUATIONsteps"
		
		)

public class runner extends AbstractTestNGCucumberTests {

}
