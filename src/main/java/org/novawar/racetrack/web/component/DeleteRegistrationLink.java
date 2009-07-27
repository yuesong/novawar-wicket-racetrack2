package org.novawar.racetrack.web.component;

import org.novawar.racetrack.web.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.behavior.OnClickComfirm;

/**
 *
 * @author ywang29
 */
public class DeleteRegistrationLink extends Link<Registration> {

    private static final long serialVersionUID = 1L;

    public DeleteRegistrationLink(String id, IModel<Registration> model) {
        super(id, model);
        add(new OnClickComfirm());
    }
    @Override
    public void onClick() {
        RaceTrackApplication.get().getService().deleteRegistration(getModelObject());
        info(getString("deleted.message", getModel()));
        // new RegistrationsPage() instead of RegistrationsPage.class in order
        // for feedback message to display
        setResponsePage(new RegistrationsPage());
    }
}
