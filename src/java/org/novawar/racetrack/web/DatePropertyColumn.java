package org.novawar.racetrack.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author ywang29
 */
public class DatePropertyColumn extends DefaultPropertyColumn<Date> {

    private String dateFormat;

    public DatePropertyColumn(String property, String dateFormat) {
        this(property, true, dateFormat);
    }

    public DatePropertyColumn(String property, boolean sortable, String dateFormat) {
        super(property, sortable);
        this.dateFormat = dateFormat;
    }

    @Override
    public String getCssClass() {
        return getPropertyExpression();
    }

    @Override
    protected IModel<?> createLabelModel(IModel<Date> rowModel) {
        IModel<?> model = super.createLabelModel(rowModel);
        Date date = (Date) model.getObject();
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat(getDateFormat());
            model = new Model<String>(format.format(date));
        }
        return model;
    }

    protected String getDateFormat() {
        return dateFormat;
    }

    
}
