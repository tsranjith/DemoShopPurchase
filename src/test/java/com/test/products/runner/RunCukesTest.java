package com.test.products.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        features = "src/test/java/com/test/resources/features",
        glue = "com.test.products.stepdef")

public class RunCukesTest {

}
