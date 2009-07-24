package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.component.DateLabel;
import org.novawar.racetrack.web.component.NumberLabel;
import org.novawar.racetrack.web.model.RaceModel;

/**
 *
 * @author ywang29
 */
public final class ShowRacePage extends BasePage {

    public ShowRacePage(Long raceId) {
        super(new RaceModel(raceId));

        // For displaying created/updated message
        add(new FeedbackPanel("feedback"));

        add(new Label("name"));
        add(new Label("city"));
        add(new Label("state"));
        add(new NumberLabel("cost", "$#0.00"));
        add(new NumberLabel("distance", "#0.00"));
        add(new NumberLabel("maxRunners", "#,###"));
        add(new DateLabel("startDateTime", "yyyy-MM-dd HH:mm"));

        add(new PropertyListView<Registration>("registrations"){
            @Override
            protected void populateItem(ListItem<Registration> listItem) {
                listItem.add(new Label("name"));
                listItem.add(new Label("email"));
            }
        });
    }



}

