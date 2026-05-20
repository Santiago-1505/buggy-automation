package co.edu.udea.buggyrating.tasks;

import co.edu.udea.buggyrating.interactions.EnterThe;
import co.edu.udea.buggyrating.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LoginInto implements Task {

    private final User user;

    public LoginInto(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterThe.loginCredentials(user)
        );
    }

    public static LoginInto credentials(User user) {
        return Tasks.instrumented(LoginInto.class, user);
    }
}