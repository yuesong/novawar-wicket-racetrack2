package org.novawar.racetrack.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.ResourceModel;
import org.novawar.racetrack.domain.Gender;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Registration;

/**
 *
 * @author ywang29
 */
public final class RegistrationsPage extends BasePage {

    public RegistrationsPage() {
        super ();
        List<IColumn<?>> columns = new ArrayList<IColumn<?>>(7);
        columns.add(new DefaultPropertyColumn<Long>("id"));
        columns.add(new DefaultPropertyColumn<String>("name"));
        columns.add(new DefaultPropertyColumn<String>("email", false));
        columns.add(new DefaultPropertyColumn<Gender>("gender"));
        columns.add(new DatePropertyColumn("dateOfBirth", "yyyy-MM-dd"));
        columns.add(new DatePropertyColumn("createdAt", "yyyy-MM-dd"));
        add(new DefaultDataTable("dataTable", columns, new RegistrationDataProvider(), 5));
    }

    private class RegistrationDataProvider extends SortableDataProvider<Registration> {

        public RegistrationDataProvider() {
            // Set default sort
            setSort("id", true);
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
            return new LoadableDetachableModel<Registration>(){
                @Override
                protected Registration load() {
                    return getService().getRegistration(id);
                }
            };
        }

    }

}

