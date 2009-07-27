package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class ShowRacePageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(new ShowRacePage(1L));
        tester.assertRenderedPage(ShowRacePage.class);
    }
}