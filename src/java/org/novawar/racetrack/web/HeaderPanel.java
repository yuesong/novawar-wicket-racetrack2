/*
 * HeaderPanel.java
 *
 * Created on July 18, 2009, 8:46 AM
 */
 
package org.novawar.racetrack.web;           

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/** 
 *
 * @author ywang29
 * @version 
 */

public class HeaderPanel extends Panel {

    /**
     * Construct.
     * @param componentName name of the component
     * @param exampleTitle title of the example
     */

    public HeaderPanel(String componentName, String exampleTitle)
    {
        super(componentName);
        add(new Label("exampleTitle", exampleTitle));
    }

}
