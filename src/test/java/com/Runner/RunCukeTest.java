package com.Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		format = {"pretty", "html:target/cucumber-html-report","json:target/cucumber-json-report.json", "junit:target/cucumber-json-report.xml"},
        features = "src/test/java/com/cucumber/features",
//        glue = "com.cucumber.StepDefinitions",
        glue = "com/StepDefinitions",
//        plugin = { 
//                    "pretty",
//                    "html:target/cucumber",
//                }
        		plugin = {"pretty", "html:target/cucumber-htmlreport","json:target/cucumber-report.json"}
        )

public class RunCukeTest{
}