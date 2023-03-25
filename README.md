# Example of lab-11. Hardware and software testing. Ivano-Frankivsk National Technical University of Oil and Gas. Department of Computer Systems and Networks.

=========================================================================

## LAB-11. Writing automated test scripts using Cucumber


The framework incorporates design principle of BDD (Behaviour driven development) which promotes
writing acceptance tests by describing behaviour of application under test in simple english language from
the perspective of its stakeholders.
Having test written in Natural language helps the Project Team to understand and track the requirements


Get the latest Source Code
===========================
Open Terminal or command line
cd to the desired folder where the test automation source code needs to be checkout

Run commands
- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/labs
```
- Switch to the lab-11 branch:
```shell
git checkout lab-11
```

IDE Configuration
==================
Intellij plugins
----------------
Configure and Install Following Plugins  
File >> Setting >> Plugins >> Browser Repositories>

*Cucumber for Java

*Gherkin

Report
======

Standard HTML Report  
A report will be generated at /target/cucumber-report/report.html

Getting Started
===========================


Feature Files
-------------------------------------------------------------------
These files contains the acceptance criteria which are written in Gherkin Language and contains various scenarios.

File Extension:  *.feature    
Location: "src/test/resources/cucumber.features"

Step Definitions
--------------------------------------------------------------------
Every steps defined in Feature file needs to be implemented in Step Definitions Class

Location: src/main/java/edu/IFNTUNG/bpbonline/application/stepdefinitions/DefinitionSteps.java

Run Test Suite
--------------------------------------------------------------------
Test Suites are used to run a group of Tests which are tagged and represented in form of Feature files & Scenarios

Location: src/test/java/edu/IFNTUNG/bpbonline/tests/RunCucumberTest.java


    @CucumberOptions(features = "src/test/resources/cucumber.features", plugin = {
        "pretty", "html:target/cucumber-report/report.html",},
        glue = "edu/IFNTUNG/bpbonline/application/stepdefinitions")
        public class RunCucumberTest extends AbstractTestNGCucumberTests{
    }


Where: 
- features: represent the location of feature files from the compiled build   
- plugin: html report is created. if a TesSuite is renamed then change the reporting directory name for both reports
- glue: represent the location of steps' definitions



  

