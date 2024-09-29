package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

monochrome= true,
plugin= {"pretty"},
features = "src/test/java/features",
glue = "stepDefs",
tags = {"@U_1001"}

)
public class TestRunner {
	
}

