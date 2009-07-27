package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.novawar.racetrack.web.component.DeleteRaceLink;

/**
 * Page for editing an existing Race.
 *
 * @author ywang29
 */
public final class EditRacePage extends BasePage {

    private static final long serialVersionUID = 1L;

    public EditRacePage(Long raceId) {
        final RaceFormPanel panel = new RaceFormPanel("raceFormPanel", raceId);
        add(panel);
        add(new SubmitLink("update", panel.getForm()));
        add(new DeleteRaceLink("delete", panel.getForm().getModel()));

        add(new Link("add"){
            private static final long serialVersionUID = 1L;
            @Override
            public void onClick() {
                setResponsePage(new CreateRegistrationPage(panel.getForm().getModel()));
            }
        });
        add(new RaceRegistrationListPanel("regPanel", raceId));
    }
}

