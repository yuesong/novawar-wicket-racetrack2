package org.novawar.racetrack.web;

import org.apache.wicket.markup.html.link.Link;

/**
 *
 * @author ywang29
 */
public final class RacesPage extends BasePage {

    public RacesPage() {
        super ();
        add(new RaceDataTable("dataTable"));
        add(new Link("newRace"){
            @Override
            public void onClick() {
                setResponsePage(new EditRacePage());
            }
        });
    }
}

