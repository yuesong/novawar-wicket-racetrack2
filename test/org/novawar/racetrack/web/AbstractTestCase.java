package org.novawar.racetrack.web;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.BeforeClass;

/**
 *
 * @author ywang29
 */
public class AbstractTestCase {

    protected static WicketTester tester;

    @BeforeClass
    public static void setUpClass() throws Exception {
        tester = new WicketTester(new RaceTrackApplication());
    }
}
