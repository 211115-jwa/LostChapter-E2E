package com.revature.features;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
   //path of feature file
   features = "src/test/resources/Login.feature",
   //path of step definition file
   glue = "stepDefination"
   )
public class TestRunner {
}
