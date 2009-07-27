package org.novawar.racetrack.web;           

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.markup.html.resources.StyleSheetReference;
import org.novawar.racetrack.service.RaceTrackService;

/** 
 *
 * @author ywang29
 */
public abstract class BasePage extends WebPage {

    /**
     * Constructor
     */
    public BasePage() {
        this(null);
    }
    
    /**
     * Construct.
     * @param model
     */
    public BasePage(IModel model) {
        super(model);
        add(new StyleSheetReference("stylesheet", BasePage.class, "style.css"));
    }

    public RaceTrackService getService() {
        return ((RaceTrackApplication)Application.get()).getService();
    }
}
