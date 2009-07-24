package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.novawar.racetrack.web.component.DateLabel;
import org.novawar.racetrack.web.model.RegistrationModel;

/**
 *
 * @author ywang29
 */
public final class ShowRegistrationPage extends BasePage {

    public ShowRegistrationPage(Long registrationId) {
        super(new RegistrationModel(registrationId));

        // For displaying created/updated message
        add(new FeedbackPanel("feedback"));

        add(new Label("name"));
        add(new Label("email"));
        add(new Label("gender"));
        add(new DateLabel("dateOfBirth", "yyyy-MM-dd"));
        add(new Label("address"));
        add(new DateLabel("createdAt", "yyyy-MM-dd HH:mm"));

        add(new Label("race.name"));
        add(new Label("race.city"));
        add(new Label("race.state"));
    }

}

