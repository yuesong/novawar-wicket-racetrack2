package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;

/**
 * Page for editing an existing Registration.
 *
 * @author ywang29
 */
public final class EditRegistrationPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public EditRegistrationPage(Long registrationId) {
        RegistrationFormPanel panel = new RegistrationFormPanel("registrationFormPanel", registrationId);
        add(panel);
        add(new SubmitLink("update", panel.getForm()));
    }
}

