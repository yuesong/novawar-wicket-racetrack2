package org.novawar.racetrack.web;           

import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author ywang29
 */

public class RaceTrackApplication extends WebApplication {

    public RaceTrackApplication() {
    }

    public Class getHomePage() {
        return HomePage.class;
    }
}
