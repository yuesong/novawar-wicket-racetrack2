package org.novawar.racetrack.web;

import java.util.Iterator;
import org.apache.wicket.Application;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.Filter;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.service.RaceTrackService;

/**
 *
 * @author ywang29
 */
public class RaceDataProvider extends SortableDataProvider<Race> {

    private FilterProvider filterProvider;

    public RaceDataProvider() {
        this(null);
    }

    public RaceDataProvider(FilterProvider filterProvider) {
        this.filterProvider = filterProvider;
        // Set default sort
        setSort("id", true);
    }

    private RaceTrackService getService() {
        return RaceTrackApplication.get().getService();
    }

    private Filter getFilter() {
        return filterProvider == null ? null : filterProvider.getFilter();
    }

    public Iterator<? extends Race> iterator(int first, int count) {
        OrderBy orderBy = new OrderBy(getSort().getProperty(), getSort().isAscending());
        return getService().getRaces(first, count, getFilter(), orderBy).iterator();
    }

    public int size() {
        return getService().getRaceCount(getFilter());
    }

    public IModel<Race> model(Race registration) {
        final Long id = registration.getId();
        return new LoadableDetachableModel<Race>() {

            @Override
            protected Race load() {
                return getService().getRace(id);
            }
        };
    }
}
