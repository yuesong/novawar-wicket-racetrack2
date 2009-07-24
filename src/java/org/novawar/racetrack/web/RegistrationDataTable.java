/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.novawar.racetrack.web;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.Page;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.web.component.DatePropertyColumn;
import org.novawar.racetrack.web.component.DefaultPropertyColumn;
import org.novawar.racetrack.web.component.IdColumn;

/**
 *
 * @author ywang29
 */
public class RegistrationDataTable extends DefaultDataTable<Registration> {

    public RegistrationDataTable(String id) {
        super(id, createColumns(), new RegistrationDataProvider(), 5);
    }

    private static List<IColumn<Registration>> createColumns() {
        List<IColumn<Registration>> columns = new ArrayList<IColumn<Registration>>(7);
        columns.add(new IdColumn<Registration>(){
            @Override
            protected Page createOnClickResponsePage(Long entityId) {
                return new ShowRegistrationPage(entityId);
            }
        });
        columns.add(new DefaultPropertyColumn<Registration>("name"));
        columns.add(new DefaultPropertyColumn<Registration>("email", false));
        columns.add(new DefaultPropertyColumn<Registration>("gender"));
        columns.add(new DatePropertyColumn<Registration>("dateOfBirth", "yyyy-MM-dd"));
        columns.add(new DatePropertyColumn<Registration>("createdAt", "yyyy-MM-dd HH:mm"));
        return columns;
    }
}
