package co.edu.udea.buggyrating.tasks;

import co.edu.udea.buggyrating.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CommentInto implements Task {

    private final String comment;

    public CommentInto(String comment) {
        this.comment = comment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EnterThe.comment(comment)
        );
    }

    public static CommentInto vehicle(String comment) {
        return Tasks.instrumented(CommentInto.class, comment);
    }

    public static CommentInto write(String comment) {
        return Tasks.instrumented(CommentInto.class, comment);
    }
}
