package org.novawar.racetrack.web;

import org.apache.wicket.markup.html.form.FormComponent;
import org.junit.Assert;
import org.junit.Test;
import org.novawar.racetrack.domain.Race;

/**
 *
 * @author ywang29
 */
public class EditRegistrationPageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(new EditRegistrationPage(1L));
        tester.assertRenderedPage(EditRegistrationPage.class);

        FormComponent raceDropDown = (FormComponent) tester.getComponentFromLastRenderedPage("registrationFormPanel:form:race");
        Assert.assertFalse("race should be disabled", raceDropDown.isEnabled());
    }
}