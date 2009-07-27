package org.novawar.racetrack.web.component;

import java.text.DecimalFormat;

/**
 * FormattedPropertyColumn for Number properties.
 * 
 * @author ywang29
 */
public class NumberPropertyColumn<T> extends FormattedPropertyColumn<T> {

    public NumberPropertyColumn(String property, String numberFormat) {
        this(property, true, numberFormat);
    }

    public NumberPropertyColumn(String property, boolean sortable, String numberFormat) {
        super(property, sortable, new DecimalFormat(numberFormat));
    }

}
