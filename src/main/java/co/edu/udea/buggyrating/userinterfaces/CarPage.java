package co.edu.udea.buggyrating.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarPage extends PageObject {

    public static final Target BRAND_LAMBORGHINI =
            Target.the("Lamborghini brand")
                    .locatedBy("//img[@title='Lamborghini']");

    public static final Target MODEL_LAMBORGHINI =
            Target.the("Lamborghini model")
                    .locatedBy("//a[@href[contains(.,'/model/')]][text()='Diablo']");

    public static final Target MODEL_REVENTON =
            Target.the("Lamborghini Reventon")
                    .locatedBy("//a[contains(@href,'/model/') and text()='Reventón']");

    public static final Target INPUT_COMMENT =
            Target.the("Comment input")
                    .locatedBy("//textarea[@id='comment']");

    public static final Target BUTTON_VOTE =
            Target.the("Button vote")
                    .locatedBy("//button[contains(.,'Vote')]");

    public static final Target COMMENT_RESULT =
            Target.the("Published comment")
                    .locatedBy("//body");

    public static final Target MESSAGE_COMMENT_ERROR =
            Target.the("Comment error message")
                    .locatedBy("//*[contains(text(),'Comment')]");

}