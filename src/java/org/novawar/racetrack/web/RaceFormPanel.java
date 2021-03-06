package org.novawar.racetrack.web;
import java.util.Arrays;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.validation.validator.MinimumValidator;
import org.apache.wicket.validation.validator.RangeValidator;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.service.RaceTrackService;
import org.novawar.racetrack.web.model.RaceModel;

/**
 *
 * @author ywang29
 */
public final class RaceFormPanel extends Panel {

    private Form<Race> form;

    public RaceFormPanel(String id) {
        this(id, null);
    }

    public RaceFormPanel(String id, Long raceId) {
        super(id);

        add(new FeedbackPanel("feedback"));

        form = new Form<Race>("form", new RaceModel(raceId)) {
            @Override
            protected void onSubmit() {
                Race race = getModelObject();
                String key = race.getId() == null ? "created.message" : "updated.message";
                getService().saveRace(race);
                info(getString(key, getModel()));
                setResponsePage(new ShowRacePage(race.getId()));
            }
        };
        add(form);

        form.add(new RequiredTextField("name"));
        form.add(new RequiredTextField("city"));
        form.add(new DropDownChoice("state", Arrays.asList("MD", "NC", "VA", "WV")).setRequired(true));
        form.add(new RequiredTextField("cost", Double.class).add(new RangeValidator(0.0, 100.0)));
        form.add(new RequiredTextField("distance", Double.class).add(new MinimumValidator(0.0)));
        form.add(new RequiredTextField("maxRunners", Integer.class).add(new MinimumValidator(0)));
        form.add(new DateTextField("startDateTime", "yyyy-MM-dd HH:mm").setRequired(true));

        // Set every FormComponent's markup id
        form.visitChildren(FormComponent.class, new Component.IVisitor<FormComponent>() {
            public Object component(FormComponent fc) {
                fc.setMarkupId(fc.getId());
                return CONTINUE_TRAVERSAL;
            }
        });
    }
    
    public Form<Race> getForm() {
        return form;
    }

    private RaceTrackService getService() {
        return RaceTrackApplication.get().getService();
    }

}
