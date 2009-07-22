package org.novawar.racetrack.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;

/**
 *
 * @author ywang29
 */
public final class RacesPage extends BasePage {

    public RacesPage() {
        super ();
        List<IColumn<Race>> columns = new ArrayList<IColumn<Race>>(7);
        columns.add(new DefaultPropertyColumn<Race>("id"));
        columns.add(new DefaultPropertyColumn<Race>("name"));
        columns.add(new DefaultPropertyColumn<Race>("city"));
        columns.add(new DefaultPropertyColumn<Race>("state"));
        columns.add(new NumberPropertyColumn<Race>("cost", "$#0.00"));
        columns.add(new NumberPropertyColumn<Race>("distance", "#0.00"));
        columns.add(new NumberPropertyColumn<Race>("maxRunners", "#,###"));
        columns.add(new DatePropertyColumn<Race>("startDateTime", "yyyy-MM-dd HH:mm"));
        add(new DefaultDataTable<Race>("dataTable", columns, new RaceDataProvider(), 10));
    }

    private class RaceDataProvider extends SortableDataProvider<Race> {

        public RaceDataProvider() {
            // Set default sort
            setSort("id", true);
        }

        public Iterator<? extends Race> iterator(int first, int count) {
            OrderBy orderBy = new OrderBy(getSort().getProperty(), getSort().isAscending());
            return getService().getRaces(first, count, null, orderBy).iterator();
        }

        public int size() {
            return getService().getRaceCount();
        }

        public IModel<Race> model(Race registration) {
            final Long id = registration.getId();
            return new LoadableDetachableModel<Race>(){
                @Override
                protected Race load() {
                    return getService().getRace(id);
                }
            };
        }

    }
}

