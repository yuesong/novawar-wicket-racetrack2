package org.novawar.racetrack.web;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.novawar.racetrack.service.RaceTrackService;

/**
 *
 * @author ywang29
 */
public class AbstractTestCase {

    protected WicketTester tester;

    @Before
    public void setUp() throws Exception {
        tester = new WicketTester(new RaceTrackApplication());
    }

    protected RaceTrackService getService() {
        return ((RaceTrackApplication)tester.getApplication()).getService();
    }
}
