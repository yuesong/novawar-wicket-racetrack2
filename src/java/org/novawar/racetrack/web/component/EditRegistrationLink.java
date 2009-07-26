package org.novawar.racetrack.web.component;

import org.novawar.racetrack.web.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 *
 * @author ywang29
 */
public class EditRegistrationLink extends Link<Long> {

    private static final long serialVersionUID = 1L;

    public EditRegistrationLink(String id, Long registrationId) {
        super(id, new Model<Long>(registrationId));
    }

    @Override
    public void onClick() {
        setResponsePage(new EditRegistrationPage(getModelObject()));
    }
}
