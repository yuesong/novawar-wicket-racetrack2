package org.novawar.racetrack.web.component;

import java.text.SimpleDateFormat;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ywang29
 */
public class DateLabel extends FormattedLabel {

    public DateLabel(String id, IModel<?> model, String dateFormat) {
        super(id, model, new SimpleDateFormat(dateFormat));
    }

    public DateLabel(String id, String dateFormat) {
        super(id, new SimpleDateFormat(dateFormat));
    }

}
