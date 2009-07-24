package org.novawar.racetrack.web;

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
    public void testUpdate() {
        tester.startPage(new EditRacePage(1L));
        tester.assertRenderedPage(EditRacePage.class);

        FormTester ft = tester.newFormTester("raceFormPanel:form");
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