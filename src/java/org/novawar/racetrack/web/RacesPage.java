package org.novawar.racetrack.web;

/**
 *
 * @author ywang29
 */
public final class RacesPage extends BasePage {

    public RacesPage() {
        super ();
        add(new RaceDataTable("dataTable"));
    }
}

