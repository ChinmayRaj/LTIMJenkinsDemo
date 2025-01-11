package com.example.runner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/home/coder/project/workspace/demo7/features/HotelApp.feature",
    glue = "com.example.StepDefinitions",
    plugin={"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)
public class TestRunner {
    
}
