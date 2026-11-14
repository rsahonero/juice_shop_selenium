package com.juice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue =  {"com.juice"},
        plugin = {"pretty","summary",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
        },
        monochrome = false,
        publish = true,
        dryRun = false,
        tags = "@register"
        //tags = "@login and @register"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
