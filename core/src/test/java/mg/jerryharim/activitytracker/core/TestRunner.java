package mg.jerryharim.activitytracker.core;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "progress", 
    features = {"src/test/resources/features"}
)
public class TestRunner {}
