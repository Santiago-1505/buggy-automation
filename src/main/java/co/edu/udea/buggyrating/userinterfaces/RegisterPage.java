package co.edu.udea.buggyrating.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage extends PageObject {

    public static final Target BUTTON_REGISTER_MENU =
            Target.the("Register menu button")
                    .locatedBy("//a[contains(text(),'Register')]");

    public static final Target INPUT_LOGIN =
            Target.the("Register username")
                    .locatedBy("//input[@id='username']");

    public static final Target INPUT_FIRSTNAME =
            Target.the("First name")
                    .locatedBy("//input[@id='firstName']");

    public static final Target INPUT_LASTNAME =
            Target.the("Last name")
                    .locatedBy("//input[@id='lastName']");

    public static final Target INPUT_PASSWORD_REGISTER =
            Target.the("Password")
                    .locatedBy("//input[@id='password']");

    public static final Target INPUT_CONFIRM_PASSWORD =
            Target.the("Confirm password")
                    .locatedBy("//input[@id='confirmPassword']");

    public static final Target BUTTON_REGISTER =
            Target.the("Button register")
                    .locatedBy("//button[contains(text(),'Register')]");

    public static final Target MESSAGE_SUCCESS =
            Target.the("Successful registration message")
                    .locatedBy("//div[contains(text(),'Registration is successful')]");

    public static final Target MESSAGE_REGISTER_ERROR =
            Target.the("Register error message")
                    .locatedBy("//div[contains(text(),'already exists')]");

}
