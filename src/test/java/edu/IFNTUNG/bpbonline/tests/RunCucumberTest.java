package edu.IFNTUNG.bpbonline.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/cucumber.features", plugin = {
        "pretty", "html:target/cucumber-report/report.html",},
        glue = "edu/IFNTUNG/bpbonline/application/stepdefinitions",
        tags = "@checkItemPriceInCart or @CreateAccountTest",
        monochrome = true)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
