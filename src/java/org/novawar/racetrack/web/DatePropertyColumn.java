package org.novawar.racetrack.web;

import java.text.SimpleDateFormat;

/**
 * FormattedPropertyColumn for Date properties.
 * 
 * @author ywang29
 */
public class DatePropertyColumn<T> extends FormattedPropertyColumn<T> {

    public DatePropertyColumn(String property, String dateFormat) {
        this(property, true, dateFormat);
    }

    public DatePropertyColumn(String property, boolean sortable, String dateFormat) {
        super(property, sortable, new SimpleDateFormat(dateFormat));
    }

}
