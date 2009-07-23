package org.novawar.racetrack.web;

import java.util.List;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Assert;
import org.junit.Test;
import org.novawar.racetrack.domain.Race;

/**
 *
 * @author ywang29
 */
public class EditRacePageTest extends AbstractTestCase {

    @Test
    public void testCreate() {
        tester.startPage(new EditRacePage());
        tester.assertRenderedPage(EditRacePage.class);

        FormTester ft = tester.newFormTester("form");
        ft.setValue("name", "my race");
        ft.setValue("city", "Vienna");
        ft.select("state", 2); // VA
        ft.setValue("cost", "10.0");
        ft.setValue("distance", "5.0");
        ft.setValue("startDateTime", "2009-08-05 10:30");
        ft.submit();

        tester.assertNoErrorMessage();
        tester.assertRenderedPage(ShowRacePage.class);

        // The last Race should be the newly created one.
        List<Race> all = getService().getRaces(0, 100, null, null);
        Race race = all.get(all.size() - 1);
        tester.assertInfoMessages(new String[]{"Race " + race.getId() + " created"});
    }

    @Test
    public void testUpdate() {
        tester.startPage(new EditRacePage(1L));
        tester.assertRenderedPage(EditRacePage.class);

        FormTester ft = tester.newFormTester("form");
        ft.setValue("cost", "10.0");
        ft.submit();

        tester.assertNoErrorMessage();
        tester.assertRenderedPage(ShowRacePage.class);

        // The last Race should be the newly created one.
        Race race = getService().getRace(1L);
        Assert.assertEquals("cost", new Double(10.0), race.getCost());
        tester.assertInfoMessages(new String[]{"Race 1 updated"});
    }
}