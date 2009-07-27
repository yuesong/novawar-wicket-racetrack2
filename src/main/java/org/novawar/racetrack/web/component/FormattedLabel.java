package org.novawar.racetrack.web.component;

import java.text.Format;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


/**
 *
 * @author ywang29
 */
public class FormattedLabel extends Label {

    private Format format;

    public FormattedLabel(String id, Format format) {
        super(id);
        this.format = format;
    }

    public FormattedLabel(String id, IModel<?> model, Format format) {
        super(id, model);
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
        Object obj = getDefaultModelObject();
        String value;
        if (obj != null && getFormat() != null) {
            value = getFormat().format(obj);
        } else {
            value = getDefaultModelObjectAsString();
        }
		replaceComponentTagBody(markupStream, openTag, value);
    }


}
