package options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"stepdefs"},
		features = {"C:\\Users\\P10468821\\Downloads\\restassured-with-cucumber-demo-master\\src\\test\\java\\feature"})
public class CucumberTests {}
