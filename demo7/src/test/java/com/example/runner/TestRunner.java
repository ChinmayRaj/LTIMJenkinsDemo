package com.example.runner;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features="/home/coder/project/workspace/demo7/features/HotelApp.feature",
    glue="com.exapmle1.StepDefinitions",
    plugin={"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"}
)
public class TestRunner {
    
}
