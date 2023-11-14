/**
 * 
 */
package com.ecommerce.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * @author Santosh Sharma
 *
 */


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"com.ecommerce.stepdefinitions", "com.ecommerce.hooks"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				//"html:target/test-output/test_report.html"
		}
		)

public class TestRunner {

}