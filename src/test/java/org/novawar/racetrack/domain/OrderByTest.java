/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.novawar.racetrack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ywang29
 */
public class OrderByTest {

    private OrderBy nameAsc;
    private OrderBy nameDesc;
    private List<Race> list;
    private Race race1;
    private Race race2;
    private Race race3;

    @Before
    public void setUp() {
        nameAsc = new OrderBy("name", true);
        nameDesc = new OrderBy("name", false);
        race1 = new Race("Race 1");
        race2 = new Race();
        race3 = new Race("Race 3");
        list = new ArrayList<Race>(Arrays.asList(race1, race2, race3));
    }

    @Test
    public void testSortAsc() {
        nameAsc.sort(list);
        Assert.assertEquals(Arrays.asList(race1, race3, race2), list);
    }

    @Test
    public void testSortDesc() {
        nameDesc.sort(list);
        Assert.assertEquals(Arrays.asList(race2, race3, race1), list);
    }

}