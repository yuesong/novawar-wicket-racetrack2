package org.novawar.racetrack.web.model;

import java.util.Date;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.RaceTrackApplication;

/**
 *
 * @author ywang29
 */
public class RegistrationModel extends CompoundPropertyModel<Registration> {

    private static final long serialVersionUID = 1L;

    private Long id;
    private IModel<Race> raceModel;

    public RegistrationModel(IModel<Race> raceModel) {
        this(null, raceModel);
    }

    public RegistrationModel(final Long id) {
        this(id, null);
    }

    public RegistrationModel(final Long id, final IModel<Race> raceModel) {
        super(new LoadableDetachableModel<Registration>() {
            private static final long serialVersionUID = 1L;
            @Override
            protected Registration load() {
                if (id == null) {
                    Registration registration = new Registration();
                    registration.setCreatedAt(new Date());
                    if (raceModel != null) {
                        registration.setRace(raceModel.getObject());
                    }
                    return registration;
                } else {
                    return RaceTrackApplication.get().getService().getRegistration(id);
                }
            }
        });
        this.id = id;
        this.raceModel = raceModel;
    }

    public boolean hasRace() {
        return id != null || raceModel != null;
    }

}
