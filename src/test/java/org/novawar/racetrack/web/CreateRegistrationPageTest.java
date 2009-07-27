package org.novawar.racetrack.web;

import org.apache.wicket.util.tester.FormTester;
import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class CreateRegistrationPageTest extends AbstractTestCase {

    @Test
    public void testEmailValidation() {
        tester.startPage(new CreateRegistrationPage());
        tester.assertRenderedPage(CreateRegistrationPage.class);

        FormTester ft = tester.newFormTester("registrationFormPanel:form");
        ft.setValue("name", "Darth Vader");
        ft.setValue("email", "bogus email format");
        ft.select("race", 0);
        ft.submit();

        tester.assertErrorMessages(new String[]{"'bogus email format' is not a valid email address."});
        tester.assertRenderedPage(CreateRegistrationPage.class);
    }

}