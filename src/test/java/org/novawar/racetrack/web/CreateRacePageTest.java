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
public class CreateRacePageTest extends AbstractTestCase {

    @Test
    public void testCreate() {
        tester.startPage(new CreateRacePage());
        tester.assertRenderedPage(CreateRacePage.class);

        FormTester ft = tester.newFormTester("raceFormPanel:form");
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

}