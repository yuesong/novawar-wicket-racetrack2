package org.novawar.racetrack.web.component;

import org.novawar.racetrack.web.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.web.behavior.OnClickComfirm;

/**
 *
 * @author ywang29
 */
public class DeleteRaceLink extends Link<Race> {

    private static final long serialVersionUID = 1L;

    public DeleteRaceLink(String id, IModel<Race> model) {
        super(id, model);
        add(new OnClickComfirm());
    }
    @Override
    public void onClick() {
        RaceTrackApplication.get().getService().deleteRace(getModelObject());
        info(getString("deleted.message", getModel()));
        // new RacesPage() instead of RacesPage.class in order
        // for feedback message to display
        setResponsePage(new RacesPage());
    }
}
