package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;

/**
 * Page for editing an existing Race.
 *
 * @author ywang29
 */
public final class EditRacePage extends BasePage {

    public EditRacePage(Long raceId) {
        RaceFormPanel panel = new RaceFormPanel("raceFormPanel", raceId);
        add(panel);
        add(new SubmitLink("update", panel.getForm()));
    }
}

