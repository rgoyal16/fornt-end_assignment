import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "/home/rupali/IdeaProjects/demo/src/test/java/steps/Login.feature",glue = "steps")

public class Runner extends AbstractTestNGCucumberTests {

}
