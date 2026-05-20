package co.edu.udea.buggyrating.interactions;

import co.edu.udea.buggyrating.models.User;
import co.edu.udea.buggyrating.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.buggyrating.userinterfaces.CarPage.*;
import static co.edu.udea.buggyrating.userinterfaces.LoginPage.*;
import static co.edu.udea.buggyrating.userinterfaces.RegisterPage.*;

public class EnterThe implements Interaction {

    private User user;
    private String comment;
    private String actionType;

    public EnterThe(User user, String actionType) {
        this.user = user;
        this.actionType = actionType;
    }

    public EnterThe(String comment, String actionType) {
        this.comment = comment;
        this.actionType = actionType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch (actionType) {

            case "login":

                actor.attemptsTo(
                        Enter.theValue(user.getUsername()).into(INPUT_USERNAME)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getPassword()).into(INPUT_PASSWORD)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Click.on(BUTTON_LOGIN)
                );

                break;

            case "register":

                actor.attemptsTo(
                        Click.on(BUTTON_REGISTER_MENU)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getUsername()).into(INPUT_LOGIN)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getFirstName()).into(INPUT_FIRSTNAME)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getLastName()).into(INPUT_LASTNAME)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getPassword()).into(INPUT_PASSWORD_REGISTER)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Enter.theValue(user.getPassword()).into(INPUT_CONFIRM_PASSWORD)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Click.on(BUTTON_REGISTER)
                );

                break;

            case "comment":

                actor.attemptsTo(
                        Enter.theValue(comment).into(INPUT_COMMENT)
                );

                WaitTime.putWaitTimeOf(2000);

                actor.attemptsTo(
                        Click.on(BUTTON_VOTE)
                );

                break;
        }
    }

    public static EnterThe loginCredentials(User user) {
        return Tasks.instrumented(EnterThe.class, user, "login");
    }

    public static EnterThe registrationInformation(User user) {
        return Tasks.instrumented(EnterThe.class, user, "register");
    }

    public static EnterThe comment(String comment) {
        return Tasks.instrumented(EnterThe.class, comment, "comment");
    }
}