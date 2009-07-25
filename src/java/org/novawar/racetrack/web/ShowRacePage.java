package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.novawar.racetrack.web.behavior.OnClickComfirm;
import org.novawar.racetrack.web.component.DateLabel;
import org.novawar.racetrack.web.component.NumberLabel;
import org.novawar.racetrack.web.model.RaceModel;

/**
 *
 * @author ywang29
 */
public final class ShowRacePage extends BasePage {

    private static final long serialVersionUID = 1L;

    private RaceModel raceModel;

    public ShowRacePage(final Long raceId) {
        super();
        setDefaultModel(raceModel = new RaceModel(raceId));

        // For displaying created/updated message
        add(new FeedbackPanel("feedback"));

        add(new Label("name"));
        add(new Label("city"));
        add(new Label("state"));
        add(new NumberLabel("cost", "$#0.00"));
        add(new NumberLabel("distance", "#0.00"));
        add(new NumberLabel("maxRunners", "#,###"));
        add(new DateLabel("startDateTime", "yyyy-MM-dd HH:mm"));

        add(new Link("edit"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                setResponsePage(new EditRacePage(raceId));
            }
        });
        Link link = new Link("delete"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                getService().deleteRace(raceModel.getObject());
                info(getString("deleted.message", raceModel));
                // new RacesPage() instead of RacesPage.class in order for
                // feedback message to display
                setResponsePage(new RacesPage());
            }
        };
        link.add(new OnClickComfirm());
        add(link);

        add(new RaceRegistrationListPanel("regPanel", raceId));
    }

}

