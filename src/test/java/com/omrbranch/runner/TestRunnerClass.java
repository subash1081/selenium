
package com.omrbranch.runner;


import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import org.junit.runner.RunWith;



import com.omrbranch.report.Reporting;

import com.omrbranch.utitity.BaseClass;



import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)



@CucumberOptions(

tags = "@Login",

snippets = SnippetType.CAMELCASE,

dryRun = false,

stepNotifications = false,

monochrome = true,

publish = true,



plugin = {

"pretty",

"html:target\\output.html",

"junit:target\\output.xml",

"json:target\\output.json"

},



name = { "" },



glue = { "com.omrbranch.stepdefinition", "com.omrbranch.hooks" },



features = "src\\test\\resources"

)



public class TestRunnerClass extends BaseClass {



// Create Logger object

private static final Logger log =

LogManager.getLogger(TestRunnerClass.class);



@BeforeClass

public static void beforeClass() {



log.info("========================================");

log.info("Automation Test Execution Started");

log.info("========================================");

}



@AfterClass

public static void afterClass() {



log.info("Test Execution Completed");



log.info("JVM Report generation started");



Reporting.generateJvmReport(

getProjectPath() + "\\target\\output.json"

);



log.info("JVM Report generation completed");



log.info("========================================");

log.info("Automation Test Execution Finished");

log.info("========================================");

}

}
