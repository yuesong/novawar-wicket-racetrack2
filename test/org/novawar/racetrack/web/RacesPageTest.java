package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class RacesPageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(RacesPage.class);
        tester.assertRenderedPage(RacesPage.class);
    }
}