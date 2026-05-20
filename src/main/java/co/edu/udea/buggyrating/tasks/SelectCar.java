package co.edu.udea.buggyrating.tasks;

import co.edu.udea.buggyrating.interactions.ClickOn;
import co.edu.udea.buggyrating.userinterfaces.CarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectCar implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickOn.the(CarPage.BRAND_LAMBORGHINI),
                ClickOn.the(CarPage.MODEL_LAMBORGHINI)
        );
    }

    public static SelectCar brand() {
        return Tasks.instrumented(SelectCar.class);
    }
}
