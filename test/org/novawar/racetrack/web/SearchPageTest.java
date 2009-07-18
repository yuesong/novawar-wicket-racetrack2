package org.novawar.racetrack.web;

import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class SearchPageTest extends AbstractTestCase {

    @Test
    public void testRender() {
        tester.startPage(SearchPage.class);
        tester.assertRenderedPage(SearchPage.class);
    }
}