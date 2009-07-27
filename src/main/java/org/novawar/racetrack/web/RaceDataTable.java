package org.novawar.racetrack.web;

import org.apache.wicket.Page;
import org.novawar.racetrack.web.component.DefaultPropertyColumn;
import org.novawar.racetrack.web.component.NumberPropertyColumn;
import org.novawar.racetrack.web.component.DatePropertyColumn;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.web.component.IdColumn;

/**
 *
 * @author ywang29
 */
public class RaceDataTable extends DefaultDataTable<Race> {

    public RaceDataTable(String id) {
        this(id, null);
    }

    public RaceDataTable(String id, FilterProvider filterProvider) {
        super(id, createColumns(), new RaceDataProvider(filterProvider), 10);
    }
    
    private static List<IColumn<Race>> createColumns() {
        List<IColumn<Race>> columns = new ArrayList<IColumn<Race>>(8);
        columns.add(new IdColumn<Race>(){
            @Override
            protected Page createOnClickResponsePage(Long entityId) {
                return new ShowRacePage(entityId);
            }
        });
        columns.add(new DefaultPropertyColumn<Race>("name"));
        columns.add(new DefaultPropertyColumn<Race>("city"));
        columns.add(new DefaultPropertyColumn<Race>("state"));
        columns.add(new NumberPropertyColumn<Race>("cost", "$#0.00"));
        columns.add(new NumberPropertyColumn<Race>("distance", "#0.00"));
        columns.add(new NumberPropertyColumn<Race>("maxRunners", "#,###"));
        columns.add(new DatePropertyColumn<Race>("startDateTime", "yyyy-MM-dd HH:mm"));
        return columns;
    }

}
