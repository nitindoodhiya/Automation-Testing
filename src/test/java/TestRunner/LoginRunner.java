package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features/login.feature", glue = "Steps")

public class LoginRunner {
	public static void main(String[] args)
	{
		System.out.print("Hello");
	}
}
