package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;

/**
 * Page for creating a new Registration.
 * 
 * @author ywang29
 */
public final class CreateRegistrationPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public CreateRegistrationPage() {
        RegistrationFormPanel panel = new RegistrationFormPanel("registrationFormPanel");
        add(panel);
        add(new SubmitLink("create", panel.getForm()));
    }
}

