package org.novawar.racetrack.web.component;

import org.novawar.racetrack.web.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 *
 * @author ywang29
 */
public class EditRaceLink extends Link<Long> {

    private static final long serialVersionUID = 1L;

    public EditRaceLink(String id, Long raceId) {
        super(id, new Model<Long>(raceId));
    }

    @Override
    public void onClick() {
        setResponsePage(new EditRacePage(getModelObject()));
    }
}
