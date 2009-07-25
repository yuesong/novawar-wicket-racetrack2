package org.novawar.racetrack.web.behavior;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 *
 * @author ywang29
 */
public class OnClickComfirm extends AttributeModifier {

    private static final long serialVersionUID = 1L;

    public static final String DEFAULT_MESSAGE = "Are you sure?";

    public OnClickComfirm() {
        this(DEFAULT_MESSAGE);
    }

    public OnClickComfirm(String message) {
        this(new Model<String>(message));
    }

    public OnClickComfirm(IModel<?> messageModel) {
        super("onclick", true, messageModel);
    }

    @Override
    protected String newValue(String currentValue, String replacementValue) {
        return "var answer = confirm('" + replacementValue + "'); "
                + "if (answer) {" + currentValue + ";} return answer;";

    }



}
