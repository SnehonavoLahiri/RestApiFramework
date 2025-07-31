package cucmberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue= "stepDefinations",plugin = {                                // Prints steps in console
        "html:target/cucumber-reports/report.html",   // HTML report
        "json:target/jsonReports/report.json",   // JSON report
        "junit:target/cucumber-reports/report.xml"    // JUnit XML report
    },
    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
