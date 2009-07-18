package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class RegistrationsPageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(RegistrationsPage.class);
        tester.assertRenderedPage(RegistrationsPage.class);
    }
}