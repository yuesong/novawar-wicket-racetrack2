package org.novawar.racetrack.service;

import java.util.List;
import org.novawar.racetrack.domain.Filter;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.domain.Registration;

/**
 *
 * @author ywang29
 */
public interface RaceTrackService {

    /**
     * Gets a Race by ID.
     *
     * @param id
     * @return
     */
    Race getRace(Long id);

    /**
     * Gets an ordered subset of Races.
     *
     * @param first
     * @param count
     * @param filter
     * @param orderBy
     * @return
     */
    List<Race> getRaces(int first, int count, Filter filter, OrderBy orderBy);

    /**
     * Gets the total number of Races.
     *
     * @return
     */
    int getRaceCount();

    /**
     * Gets a Registration by ID.
     * 
     * @param id
     * @return
     */
    Registration getRegistration(Long id);

    /**
     * Gets an ordered subset of Registrations.
     *
     * @param first index of the first Registration
     * @param count number of Registration to return
     * @param sortProperty sort property
     * @param asc sort order
     * @return
     */
    List<Registration> getRegistrations(int first, int count, OrderBy orderBy);

    /**
     * Gets the total number of Registrations.
     *
     * @return
     */
    int getRegistrationCount();

    /**
     * Saves a Race.
     *
     * @param race
     */
    void saveRace(Race race);

    /**
     * Saves a Registration.
     *
     * @param registration
     */
    void saveRegistration(Registration registration);

    /**
     * Deletes a Race.
     *
     * @param race
     */
    void deleteRace(Race race);

    /**
     * Deletes a Registration.
     * 
     * @param registration
     */
    void deleteRegistration(Registration registration);

}
