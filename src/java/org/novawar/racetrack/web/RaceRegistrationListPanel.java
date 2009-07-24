package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.model.RaceModel;

/**
 *
 * @author ywang29
 */
public final class RaceRegistrationListPanel extends Panel {

    public RaceRegistrationListPanel(String id, Long raceId) {
        super (id, new RaceModel(raceId));
        add(new PropertyListView<Registration>("registrations"){
            @Override
            protected void populateItem(ListItem<Registration> item) {
                final Long registractionId = item.getModelObject().getId();
                Link link = new Link("show"){
                    @Override
                    public void onClick() {
                        setResponsePage(new ShowRegistrationPage(registractionId));
                    }
                };
                link.add(new Label("name"));
                link.add(new Label("email"));
                item.add(link);
            }
        });
    }
}
