package org.novawar.racetrack.web.component;

import java.text.DecimalFormat;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ywang29
 */
public class NumberLabel extends FormattedLabel {

    public NumberLabel(String id, IModel<?> model, String numberFormat) {
        super(id, model, new DecimalFormat(numberFormat));
    }

    public NumberLabel(String id, String numberFormat) {
        super(id, new DecimalFormat(numberFormat));
    }

}
