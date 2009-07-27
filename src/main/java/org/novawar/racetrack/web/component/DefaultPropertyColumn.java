package org.novawar.racetrack.web.component;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.ResourceModel;

/**
 * Convenience PropertyColumn that uses a ResourceModel for display and that
 * uses the same property for sorting.
 * <p>
 * The display ResourceModel uses <code>"header." + property</code> as key.
 *
 * @param <T> Type of model object whose property is to be displayed.
 * @author ywang29
 */
public class DefaultPropertyColumn<T> extends PropertyColumn<T> {

    /**
     * Constructor. Sortable.
     *
     * @param property Property expression
     */
    public DefaultPropertyColumn(String property) {
        this(property, true);
    }

    /**
     * Constructor.
     *
     * @param property Property expression
     * @param sortable
     */
    public DefaultPropertyColumn(String property, boolean sortable) {
        super(new ResourceModel("header." + property), sortable ? property : null, property);
    }

    @Override
    public String getCssClass() {
        return getPropertyExpression();
    }
}
