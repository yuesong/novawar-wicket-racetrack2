package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.domain.Race;

/**
 * Page for creating a new Registration.
 * 
 * @author ywang29
 */
public final class CreateRegistrationPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public CreateRegistrationPage() {
        this(null);
    }

    CreateRegistrationPage(IModel<Race> raceModel) {
        RegistrationFormPanel panel = new RegistrationFormPanel("registrationFormPanel", raceModel);
        add(panel);
        add(new SubmitLink("create", panel.getForm()));
    }
}

