package co.edu.udea.buggyrating.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/buggyRating.feature",
        glue = "co.edu.udea.buggyrating.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunnerBuggy {
}
