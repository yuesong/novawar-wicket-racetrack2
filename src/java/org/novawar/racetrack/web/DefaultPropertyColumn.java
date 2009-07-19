package org.novawar.racetrack.web;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;

/**
 *
 * @author ywang29
 */
public class DefaultPropertyColumn<T> extends PropertyColumn<T> {

    public DefaultPropertyColumn(String property) {
        this(property, true);
    }

    public DefaultPropertyColumn(String property, boolean sortable) {
        super(new ResourceModel("header." + property), sortable ? property : null, property);
    }

    @Override
    public String getCssClass() {
        return getPropertyExpression();
    }
}
