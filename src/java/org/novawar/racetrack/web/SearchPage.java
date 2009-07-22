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

    private String state;

    public SearchPage() {
        super ();
        Form form = new Form("form");
        add(form);

        TextField fld = new TextField("state", new PropertyModel<String>(this, "state"));
        fld.setMarkupId(fld.getId());
        form.add(fld);

        add(new RaceDataTable("dataTable", this));
    }

    public Filter getFilter() {
        return state == null ? null : new Filter("state", state);
    }

}

