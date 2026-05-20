package co.edu.udea.buggyrating.stepdefinitions;

import co.edu.udea.buggyrating.models.User;
import co.edu.udea.buggyrating.questions.ValidationFor;
import co.edu.udea.buggyrating.tasks.LoginInto;
import co.edu.udea.buggyrating.tasks.OpenThe;
import co.edu.udea.buggyrating.userinterfaces.LoginPage;
import co.edu.udea.buggyrating.utils.WaitTime;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinition {

    public final Actor user = Actor.named("Jenny");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    private final User validUser =
            User.withCredentials("testuser", "Jenny", "Orozco", "Test123!");

    private final User invalidUser =
            User.withCredentials("wronguser", "Wrong", "User", "wrong123");

    @Before
    public void config() {

        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Jenny");
    }

    @Given("I am registered in Buggy Cars Rating")
    public void iAmRegisteredInBuggyCarsRating() {

        user.attemptsTo(
                OpenThe.buggyPage(new LoginPage())
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @Given("I am on the Buggy Cars Rating login page")
    public void iAmOnTheBuggyCarsRatingLoginPage() {

        user.attemptsTo(
                OpenThe.buggyPage(new LoginPage())
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I enter my valid credentials")
    public void iEnterMyValidCredentials() {

        user.attemptsTo(
                LoginInto.credentials(validUser)
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {

        user.attemptsTo(
                LoginInto.credentials(invalidUser)
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @Then("I can access the Buggy Cars Rating platform")
    public void iCanAccessTheBuggyCarsRatingPlatform() {

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.successfulLogin(),
                        Matchers.containsString("Hi")
                )
        );
    }

    @Then("I can see an authentication error message")
    public void iCanSeeAnAuthenticationErrorMessage() {

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.failedLogin(),
                        Matchers.containsString("Invalid")
                )
        );
    }
}