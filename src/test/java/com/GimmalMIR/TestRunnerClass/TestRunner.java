
package com.GimmalMIR.TestRunnerClass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags={"@smoke"}, features = ("src/test/resources/Features"), glue = {
		"com.GimmalMIR.StepDefination" })

public class TestRunner {

}
