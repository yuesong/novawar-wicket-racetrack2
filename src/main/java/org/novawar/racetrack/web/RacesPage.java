package org.novawar.racetrack.web;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 *
 * @author ywang29
 */
public final class RacesPage extends BasePage {

    private static final long serialVersionUID = 1L;
    
    public RacesPage() {
        super ();
        add(new FeedbackPanel("feedback"));
        add(new RaceDataTable("dataTable"));
        add(new Link("newRace"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                setResponsePage(new CreateRacePage());
            }
        });
    }
}

