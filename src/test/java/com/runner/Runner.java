package com.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
		"com.stepDefinition" }, monochrome = true, plugin = { "html:Reports/cucumber/report.html",
				"json:Reports/cucumber/cucumber.json", "junit:Reports/cucumber/cucumber.xml" })

public class Runner {

}
