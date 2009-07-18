/*
 * RaceTrackApplication.java
 *
 * Created on July 18, 2009, 8:46 AM
 */
 
package org.novawar.racetrack.web;           

import org.apache.wicket.protocol.http.WebApplication;
/** 
 *
 * @author ywang29
 * @version 
 */

public class RaceTrackApplication extends WebApplication {

    public RaceTrackApplication() {
    }

    public Class getHomePage() {
        return HomePage.class;
    }
}
