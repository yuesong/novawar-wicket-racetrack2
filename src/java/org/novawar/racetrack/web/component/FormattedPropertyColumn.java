package org.novawar.racetrack.web.component;

import java.text.Format;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * DefaultPropertyColumn that formats the label value using a Format object.
 * <p>
 * Typically you would use one of the subclasses: DatePropertyColumn or
 * NumberPropertyColumn.
 * 
 * @author ywang29
 */
public class FormattedPropertyColumn<T> extends DefaultPropertyColumn<T> {

    private Format format;

    /**
     * Constructor.
     *
     * @param property
     * @param format
     */
    public FormattedPropertyColumn(String property, Format format) {
        this(property, true, format);
    }

    /**
     * Constructor.
     * 
     * @param property
     * @param sortable
     * @param format
     */
    public FormattedPropertyColumn(String property, boolean sortable, Format format) {
        super(property, sortable);
        this.format = format;
    }

    @Override
    protected IModel<?> createLabelModel(IModel<T> rowModel) {
        // super class creates a PropertyModel. We use it here to resolve the property value
        IModel<?> model = super.createLabelModel(rowModel);
        Object obj = model.getObject();
        if (obj != null && getFormat() != null) {
            model = new Model<String>(getFormat().format(obj));
        }
        return model;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    
}
