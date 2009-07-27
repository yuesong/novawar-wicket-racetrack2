package org.novawar.racetrack.web;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.novawar.racetrack.domain.Filter;

/**
 *
 * @author ywang29
 */
public final class SearchPage extends BasePage implements FilterProvider {

    private static final long serialVersionUID = 1L;

    private String state;

    private RaceDataTable dataTable;

    public SearchPage() {
        super ();
        Form form = new Form("form") {
            private static final long serialVersionUID = 1L;
            @Override
            protected void onSubmit() {
                dataTable.setVisible(state != null);
            }
        };
        add(form);

        TextField<String> fld = new TextField<String>("state", new PropertyModel<String>(this, "state"));
        fld.setMarkupId(fld.getId());
        form.add(fld);

        dataTable = new RaceDataTable("dataTable", this);
        dataTable.setVisible(false);
        add(dataTable);
    }

    public Filter getFilter() {
        return new Filter("state", state);
    }

}

