package org.novawar.racetrack.domain;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class FilterTest {

    private Filter myRaceFilter;
    private Filter nullNameFilter;
    private Filter nullPropFilter;
    private Filter noMatchFilter;
    private Race race1;
    private Race race2;
    private Race race3;
    private List<Race> list;

    @Before
    public void setUp() {
        myRaceFilter = new Filter("name", "My Race");
        nullNameFilter = new Filter("name", null);
        nullPropFilter = new Filter(null, "value");
        noMatchFilter = new Filter("name", "Her Race");

        race1 = new Race("My Race");
        race2 = new Race();
        race3 = new Race("My Race");
        list = Arrays.asList(race1, race2, race3);
    }

    @Test
    public void testFilter() {
        Assert.assertEquals("My Race", 2, myRaceFilter.filter(list).size());
        Assert.assertEquals("null name", 1, nullNameFilter.filter(list).size());
        Assert.assertEquals("null prop", 3, nullPropFilter.filter(list).size());
        Assert.assertEquals("no match", 0, noMatchFilter.filter(list).size());
    }

}