package org.novawar.racetrack.web;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 *
 * @author ywang29
 */
public final class RegistrationsPage extends BasePage {

    private static final long serialVersionUID = 1L;

    public RegistrationsPage() {
        super ();
        add(new FeedbackPanel("feedback"));
        add(new RegistrationDataTable("dataTable"));
        add(new Link("newRegistration"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                setResponsePage(new CreateRegistrationPage());
            }
        });
    }
}

