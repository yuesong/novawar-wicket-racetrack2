package org.novawar.racetrack.web;
import org.apache.wicket.markup.html.form.SubmitLink;

/**
 * Page for creating a new Race.
 * 
 * @author ywang29
 */
public final class CreateRacePage extends BasePage {

    public CreateRacePage() {
        RaceFormPanel panel = new RaceFormPanel("raceFormPanel");
        add(panel);
        add(new SubmitLink("create", panel.getForm()));
    }
}

