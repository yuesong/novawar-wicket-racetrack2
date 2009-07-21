package org.novawar.racetrack.web;

import java.text.DecimalFormat;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author ywang29
 */
public class NumberPropertyColumn<T extends Number> extends DefaultPropertyColumn<T> {

    private DecimalFormat format;

    public NumberPropertyColumn(String property, String numberFormat) {
        this(property, true, numberFormat);
    }

    public NumberPropertyColumn(String property, boolean sortable, String numberFormat) {
        super(property, sortable);
        format = new DecimalFormat(numberFormat);
    }

    @Override
    public String getCssClass() {
        return getPropertyExpression();
    }

    @Override
    protected IModel<?> createLabelModel(IModel<T> rowModel) {
        IModel<?> model = super.createLabelModel(rowModel);
        T date = (T) model.getObject();
        if (date != null) {
            model = new Model<String>(getFormat().format(date));
        }
        return model;
    }

    protected DecimalFormat getFormat() {
        return format;
    }

    
}
