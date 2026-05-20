package co.edu.udea.buggyrating.tasks;

import co.edu.udea.buggyrating.interactions.EnterThe;
import co.edu.udea.buggyrating.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SignUpInto implements Task {

    private final User user;

    public SignUpInto(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterThe.registrationInformation(user)
        );
    }

    public static SignUpInto information(User user) {
        return Tasks.instrumented(SignUpInto.class, user);
    }
}
