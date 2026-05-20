package co.edu.udea.buggyrating.stepdefinitions;

import co.edu.udea.buggyrating.models.User;
import co.edu.udea.buggyrating.questions.ValidationFor;
import co.edu.udea.buggyrating.tasks.OpenThe;
import co.edu.udea.buggyrating.tasks.SignUpInto;
import co.edu.udea.buggyrating.userinterfaces.RegisterPage;
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

public class SignUpStepDefinition {

    public final Actor user = Actor.named("Jenny");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    private final User newUser =
            User.withCredentials(
                    "newuser123",
                    "Jenny",
                    "Orozco",
                    "Test123!"
            );

    private final User existingUser =
            User.withCredentials(
                    "testuser",
                    "Jenny",
                    "Orozco",
                    "Test123!"
            );

    @Before
    public void config() {

        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Jenny");
    }

    @Given("I am on the Buggy Cars Rating registration page")
    public void iAmOnTheBuggyCarsRatingRegistrationPage() {

        user.attemptsTo(
                OpenThe.buggyPage(new RegisterPage())
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I enter valid information for a new account")
    public void iEnterValidInformationForANewAccount() {

        user.attemptsTo(
                SignUpInto.information(newUser)
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I enter a username that already exists")
    public void iEnterAUsernameThatAlreadyExists() {

        user.attemptsTo(
                SignUpInto.information(existingUser)
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @Then("I can see that my account was successfully created")
    public void iCanSeeThatMyAccountWasSuccessfullyCreated() {

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.successfulRegister(),
                        Matchers.containsString("Logout")
                )
        );
    }

    @Then("I can see an error message indicating that the username is already in use")
    public void iCanSeeAnErrorMessageIndicatingThatTheUsernameIsAlreadyInUse() {

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.failedRegister(),
                        Matchers.containsString("already")
                )
        );
    }
}