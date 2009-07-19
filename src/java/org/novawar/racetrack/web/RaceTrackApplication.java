package org.novawar.racetrack.web;           

import org.apache.wicket.protocol.http.WebApplication;
import org.novawar.racetrack.service.RaceTrackService;
import org.novawar.racetrack.service.RaceTrackServiceImpl;
/** 
 *
 * @author ywang29
 */

public class RaceTrackApplication extends WebApplication {

    private RaceTrackService service;

    public RaceTrackApplication() {
        service = new RaceTrackServiceImpl();
    }

    public Class getHomePage() {
        return HomePage.class;
    }

    public RaceTrackService getService() {
        return service;
    }
}
