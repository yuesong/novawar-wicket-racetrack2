package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.component.DateLabel;
import org.novawar.racetrack.web.component.DeleteRegistrationLink;
import org.novawar.racetrack.web.component.EditRegistrationLink;
import org.novawar.racetrack.web.model.RegistrationModel;

/**
 *
 * @author ywang29
 */
public final class ShowRegistrationPage extends BasePage {

    private static final long serialVersionUID = 1L;

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

        Link link = new Link("show"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                final Registration reg = (Registration)getPage().getDefaultModelObject();
                setResponsePage(new ShowRacePage(reg.getRace().getId()));
            }
        };
        link.add(new Label("race.name"));
        link.add(new Label("race.city"));
        link.add(new Label("race.state"));
        add(link);

        add(new EditRegistrationLink("edit", registrationId));
        add(new DeleteRegistrationLink("delete",(IModel<Registration>) getDefaultModel()));
    }

}
