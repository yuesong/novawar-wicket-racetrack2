package org.novawar.racetrack.web.model;

import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.web.RaceTrackApplication;

/**
 *
 * @author ywang29
 */
public class RaceModel extends CompoundPropertyModel<Race> {

    public RaceModel(final Long id) {
        super(new LoadableDetachableModel<Race>() {
            @Override
            protected Race load() {
                if (id == null) {
                    Race race = new Race();
                    race.setCost(0.0);
                    race.setMaxRunners(10000);
                    return race;
                } else {
                    return RaceTrackApplication.get().getService().getRace(id);
                }
            }
        });
    }

}
