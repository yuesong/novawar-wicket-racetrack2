package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class ShowRegistrationPageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(new ShowRegistrationPage(1L));
        tester.assertRenderedPage(ShowRegistrationPage.class);
    }
}