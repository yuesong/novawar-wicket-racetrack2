package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class HomePageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(HomePage.class);
        tester.assertRenderedPage(HomePage.class);
    }
}