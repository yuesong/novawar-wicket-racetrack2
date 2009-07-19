package org.novawar.racetrack.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.novawar.racetrack.domain.Filter;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.domain.Registration;

/**
 *
 * @author ywang29
 */
public class RaceTrackServiceImplTest {

    private RaceTrackServiceImpl impl;

    @Before
    public void setUp() {
        impl = new RaceTrackServiceImpl();
    }

    @Test
    public void testGetRaces() {
        List<Race> list = impl.getRaces(0, 5, new Filter("state", "MD"), new OrderBy("id", true));
        Assert.assertEquals("state MD", 4, list.size());

        list = impl.getRaces(0, 20, null, null);
        Assert.assertEquals("no filter no sort", 11, list.size());
    }

    @Test
    public void testGetRegistrations() {
        List<Registration> list = impl.getRegistrations(5, 5, new OrderBy("id", true));
        Assert.assertEquals(2, list.size());
    }

}