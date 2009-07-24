/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.novawar.racetrack.web;

import java.util.Iterator;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.service.RaceTrackService;

/**
 *
 * @author ywang29
 */
public class RegistrationDataProvider extends SortableDataProvider<Registration> {

    public RegistrationDataProvider() {
        // Set default sort
        setSort("id", true);
    }

    private RaceTrackService getService() {
        return RaceTrackApplication.get().getService();
    }

    public Iterator<? extends Registration> iterator(int first, int count) {
        OrderBy orderBy = new OrderBy(getSort().getProperty(), getSort().isAscending());
        return getService().getRegistrations(first, count, orderBy).iterator();
    }

    public int size() {
        return getService().getRegistrationCount();
    }

    public IModel<Registration> model(Registration registration) {
        final Long id = registration.getId();
        return new LoadableDetachableModel<Registration>() {

            @Override
            protected Registration load() {
                return getService().getRegistration(id);
            }
        };
    }
}

