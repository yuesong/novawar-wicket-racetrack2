package org.novawar.racetrack.web;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.web.component.DefaultPropertyColumn;
import org.novawar.racetrack.web.component.NumberPropertyColumn;
import org.novawar.racetrack.web.component.DatePropertyColumn;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.markup.html.link.Link;
import org.novawar.racetrack.domain.Race;

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
        columns.add(new IdColumn("id"));
        columns.add(new DefaultPropertyColumn<Race>("name"));
        columns.add(new DefaultPropertyColumn<Race>("city"));
        columns.add(new DefaultPropertyColumn<Race>("state"));
        columns.add(new NumberPropertyColumn<Race>("cost", "$#0.00"));
        columns.add(new NumberPropertyColumn<Race>("distance", "#0.00"));
        columns.add(new NumberPropertyColumn<Race>("maxRunners", "#,###"));
        columns.add(new DatePropertyColumn<Race>("startDateTime", "yyyy-MM-dd HH:mm"));
        return columns;
    }

    private static class IdColumn extends DefaultPropertyColumn<Race> {

        public IdColumn(String id) {
            super(id);
        }

        @Override
        public void populateItem(Item<ICellPopulator<Race>> item, String componentId, IModel<Race> rowModel) {
            item.add(new IdLink(componentId, rowModel.getObject().getId()));
        }

    }

    private static class IdLink extends Link {

        private Long raceId;

        public IdLink(String id, Long raceId) {
            super(id);
            this.raceId = raceId;
        }

        @Override
        public void onClick() {
            setResponsePage(new ShowRacePage(raceId));
        }

        @Override
        protected void onComponentTag(ComponentTag tag) {
            tag.setName("a");
            super.onComponentTag(tag);
        }

        @Override
        protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
            replaceComponentTagBody(markupStream, openTag, raceId.toString());
        }
    }
}
