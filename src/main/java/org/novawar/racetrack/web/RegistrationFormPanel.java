package org.novawar.racetrack.web;
import java.util.Arrays;
import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.novawar.racetrack.domain.Gender;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.domain.Registration;
import org.novawar.racetrack.service.RaceTrackService;
import org.novawar.racetrack.web.model.RaceListModel;
import org.novawar.racetrack.web.model.RegistrationModel;

/**
 *
 * @author ywang29
 */
public final class RegistrationFormPanel extends Panel {

    private static final long serialVersionUID = 1L;

    private Form<Registration> form;

    public RegistrationFormPanel(String id) {
        this(id, (Long)null);
    }

    public RegistrationFormPanel(String id, Long registrationId) {
        super(id);
        construct(new RegistrationModel(registrationId));
    }

    public RegistrationFormPanel(String id, IModel<Race> raceModel) {
        super(id);
        construct(new RegistrationModel(raceModel));
    }

    private void construct(RegistrationModel registrationModel) {
        add(new FeedbackPanel("feedback"));
        form = new Form<Registration>("form", registrationModel) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit() {
                Registration registration = getModelObject();
                String key = registration.getId() == null ? "created.message" : "updated.message";
                getService().saveRegistration(registration);
                info(getString(key, getModel()));
                setResponsePage(new ShowRegistrationPage(registration.getId()));
            }
        };
        add(form);
        form.add(new RequiredTextField("name"));
        form.add(new RequiredTextField("email").add(EmailAddressValidator.getInstance()));
        form.add(new RadioChoice<Gender>("gender", Arrays.asList(Gender.values())));
        form.add(new DateTextField("dateOfBirth", "yyyy-MM-dd"));
        form.add(new TextField("address"));
        DropDownChoice raceDropDown = new DropDownChoice("race", new RaceListModel(), new ChoiceRenderer("name", "id"));
        raceDropDown.setRequired(true);
        // Only allow Race selection if model does not have it.
        raceDropDown.setEnabled(!registrationModel.hasRace());
        form.add(raceDropDown);
        // Set every FormComponent's markup id
        form.visitChildren(FormComponent.class, new Component.IVisitor<FormComponent>() {

            public Object component(FormComponent fc) {
                fc.setMarkupId(fc.getId());
                return CONTINUE_TRAVERSAL;
            }
        });
    }

    public Form<Registration> getForm() {
        return form;
    }

    private RaceTrackService getService() {
        return RaceTrackApplication.get().getService();
    }

}
