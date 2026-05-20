package co.edu.udea.buggyrating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

import static co.edu.udea.buggyrating.userinterfaces.CarPage.*;
import static co.edu.udea.buggyrating.userinterfaces.LoginPage.*;
import static co.edu.udea.buggyrating.userinterfaces.RegisterPage.*;

public class ValidationFor implements Question<String> {

    private final Target element;

    private ValidationFor(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {

        return BrowseTheWeb.as(actor)
                .find(element)
                .getText();
    }

    public static ValidationFor successfulLogin() {
        return new ValidationFor(USER_LOGGED);
    }

    public static ValidationFor failedLogin() {
        return new ValidationFor(MESSAGE_ERROR_LOGIN);
    }

    public static ValidationFor successfulRegister() {
        return new ValidationFor(MESSAGE_SUCCESS);
    }
    public static ValidationFor failedRegister() {
        return new ValidationFor(MESSAGE_REGISTER_ERROR);
    }

    public static ValidationFor successfulComment() {
        return new ValidationFor(COMMENT_RESULT);
    }

    public static ValidationFor failedComment() {
        return new ValidationFor(MESSAGE_COMMENT_ERROR);
    }
}
