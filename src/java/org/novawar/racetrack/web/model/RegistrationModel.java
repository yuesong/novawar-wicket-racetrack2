package org.novawar.racetrack.web.model;

import java.util.Date;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.RaceTrackApplication;

/**
 *
 * @author ywang29
 */
public class RegistrationModel extends CompoundPropertyModel<Registration> {

    public RegistrationModel(final Long id) {
        super(new LoadableDetachableModel<Registration>() {
            @Override
            protected Registration load() {
                if (id == null) {
                    Registration registration = new Registration();
                    registration.setCreatedAt(new Date());
                    return registration;
                } else {
                    return RaceTrackApplication.get().getService().getRegistration(id);
                }
            }
        });
    }

}
