package co.edu.udea.buggyrating.stepdefinitions;

import co.edu.udea.buggyrating.models.User;
import co.edu.udea.buggyrating.questions.ValidationFor;
import co.edu.udea.buggyrating.tasks.CommentInto;
import co.edu.udea.buggyrating.tasks.LoginInto;
import co.edu.udea.buggyrating.tasks.OpenThe;
import co.edu.udea.buggyrating.tasks.SelectCar;
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

public class CommentStepDefinition {

    public final Actor user = Actor.named("Jenny");

    @Managed(driver = "chrome", uniqueSession = false)
    public WebDriver theDriver;

    private final User validUser =
            User.withCredentials("testuser", "Jenny", "Orozco.12345678", "Test123!");

    @Before
    public void config() {

        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Jenny");
    }

    @Given("I am logged into Buggy Cars Rating")
    public void iAmLoggedIntoBuggyCarsRating() {

        user.attemptsTo(
                OpenThe.buggyPage(new LoginPage()),
                LoginInto.credentials(validUser)
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I select a vehicle")
    public void iSelectAVehicle() {

        user.attemptsTo(
                SelectCar.model("Diablo")
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I select another vehicle")
    public void iSelectAnotherVehicle() {

        user.attemptsTo(
                SelectCar.model("Reventon")
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I publish a comment about the vehicle")
    public void iPublishACommentAboutTheVehicle() {

        user.attemptsTo(
                CommentInto.write("Excellent car")
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @When("I try to publish an empty comment")
    public void iTryToPublishAnEmptyComment() {

        user.attemptsTo(
                CommentInto.write("")
        );

        WaitTime.putWaitTimeOf(2000);
    }

    @Then("I can see my comment published in the vehicle section")
    public void iCanSeeMyCommentPublishedInTheVehicleSection() {

        WaitTime.putWaitTimeOf(3000);

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.successfulComment(),
                        Matchers.containsString("Excellent car")
                )
        );
    }


    @Then("I can see the vote confirmation message")
    public void iCanSeeTheVoteConfirmationMessage() {

        WaitTime.putWaitTimeOf(3000);

        GivenWhenThen.then(user).should(
                GivenWhenThen.seeThat(
                        ValidationFor.successfulComment(),
                        Matchers.containsString("Votes:")
                )
        );
    }
}