package co.edu.udea.buggyrating.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarPage extends PageObject {

    public static final Target BRAND_LAMBORGHINI =
            Target.the("Lamborghini brand")
                    .locatedBy("//img[contains(@src,'lamborghini')]");

    public static final Target MODEL_LAMBORGHINI =
            Target.the("Lamborghini model")
                    .locatedBy("//a[contains(text(),'Lamborghini Diablo')]");

    public static final Target INPUT_COMMENT =
            Target.the("Comment input")
                    .locatedBy("//textarea");

    public static final Target BUTTON_VOTE =
            Target.the("Button vote")
                    .locatedBy("//button[contains(text(),'Vote!')]");

    public static final Target COMMENT_RESULT =
            Target.the("Published comment")
                    .locatedBy("//p[contains(text(),'Excelente auto')]");

    public static final Target MESSAGE_COMMENT_ERROR =
            Target.the("Comment error message")
                    .locatedBy("XPATH_DEL_ERROR");

}