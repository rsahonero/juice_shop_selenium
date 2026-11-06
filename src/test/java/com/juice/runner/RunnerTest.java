package com.juice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue =  {"com.juice"},
        plugin = {"pretty","summary",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        monochrome = false,
        publish = true,
        dryRun = false,
        tags = "@login"
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}
