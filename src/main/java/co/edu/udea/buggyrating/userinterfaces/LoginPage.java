package co.edu.udea.buggyrating.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target INPUT_USERNAME =
            Target.the("Input username")
                    .locatedBy("//input[@name='login']");

    public static final Target INPUT_PASSWORD =
            Target.the("Input password")
                    .locatedBy("//input[@name='password']");

    public static final Target BUTTON_LOGIN =
            Target.the("Button login")
                    .locatedBy("//button[contains(text(),'Login')]");

    public static final Target MESSAGE_ERROR_LOGIN =
            Target.the("Login error message")
                    .locatedBy("//span[contains(text(),'Invalid')]");

    public static final Target USER_LOGGED =
            Target.the("Logged username")
                    .locatedBy("//a[contains(@class,'navbar-brand')]");

}