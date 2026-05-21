package co.edu.udea.buggyrating.tasks;

import co.edu.udea.buggyrating.interactions.ClickOn;
import co.edu.udea.buggyrating.userinterfaces.CarPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SelectCar implements Task {

    private final String model;

    public SelectCar(String model) {
        this.model = model;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(CarPage.BRAND_LAMBORGHINI, isClickable())
                        .forNoMoreThan(15).seconds(),

                ClickOn.the(CarPage.BRAND_LAMBORGHINI)
        );

        if(model.equals("Diablo")) {

            actor.attemptsTo(

                    WaitUntil.the(CarPage.MODEL_LAMBORGHINI, isClickable())
                            .forNoMoreThan(15).seconds(),

                    ClickOn.the(CarPage.MODEL_LAMBORGHINI)
            );
        }

        if(model.equals("Reventon")) {

            actor.attemptsTo(

                    WaitUntil.the(CarPage.MODEL_REVENTON, isClickable())
                            .forNoMoreThan(15).seconds(),

                    ClickOn.the(CarPage.MODEL_REVENTON)
            );
        }
    }

    public static SelectCar model(String model) {
        return Tasks.instrumented(SelectCar.class, model);
    }
}