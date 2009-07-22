package org.novawar.racetrack.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.novawar.racetrack.domain.Filter;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.domain.Registration;

/**
 *
 * @author ywang29
 */
public class RaceTrackServiceImpl implements RaceTrackService {

    private long raceSeq = 0;
    private long registrationSeq = 0;
    private List<Race> races = new ArrayList<Race>(10);
    private List<Registration> registrations = new ArrayList<Registration>(5);

    public RaceTrackServiceImpl() {
        initMockData();
    }

    public Race getRace(Long id) {
        if (id == null) throw new IllegalArgumentException("id must not be null.");

        for (Race race : races) {
            if (id.equals(race.getId())) {
                return race;
            }
        }
        return null;
    }

    public List<Race> getRaces(int first, int count, Filter filter, OrderBy orderBy) {
        return getFilteredOrderedSubList(races, filter, orderBy, first, count);
    }

    public int getRaceCount(Filter filter) {
        return filter == null ? races.size() : filter.filter(races).size();
    }

    public Registration getRegistration(Long id) {
        if (id == null) throw new IllegalArgumentException("id must not be null.");

        for (Registration registration : registrations) {
            if (id.equals(registration.getId())) {
                return registration;
            }
        }
        return null;
    }

    public List<Registration> getRegistrations(int first, int count, OrderBy orderBy) {
        return getFilteredOrderedSubList(registrations, null, orderBy, first, count);
    }

    public int getRegistrationCount() {
        return registrations.size();
    }

    public void saveRace(Race race) {
        if (race.getId() == null) {
            raceSeq++;
            race.setId(raceSeq);
            races.add(race);
        }
    }

    public void saveRegistration(Registration registration) {
        if (registration.getId() == null) {
            registrationSeq++;
            registration.setId(registrationSeq);
            registrations.add(registration);
        }
    }

    public void deleteRace(Race race) {
        registrations.removeAll(race.getRegistrations());
        races.remove(race);
    }

    public void deleteRegistration(Registration registration) {
        registrations.remove(registration);
    }

    private <T> List<T> getFilteredOrderedSubList(List<T> list, Filter filter, OrderBy orderBy, int first, int count) {
        if (first >= list.size()) {
            return Collections.emptyList();
        }
        List<T> result;
        if (filter != null) {
            result = filter.filter(list);
        } else {
            result = new ArrayList<T>(list);
        }
        if (orderBy != null) {
            orderBy.sort(result);
        }
        int toIndex = first + count;
        if (toIndex > result.size()) {
            toIndex = result.size();
        }
        return Collections.unmodifiableList(result.subList(first, toIndex));
    }

    private void initMockData() {
        Race race = newRace("Vienna", "VA");
        newRegistration(race, "John Doe");
        newRegistration(race, "Jane Doe");
        newRegistration(race, "Darth Vader");
        newRegistration(race, "Luke Skywalker");

        race = newRace("Falls Church", "VA");
        newRegistration(race, "Bush");
        newRegistration(race, "Obama");
        newRegistration(race, "Clinton");

        newRace("Chantilly", "VA");
        newRace("Arlington", "VA");
        newRace("Alexandria", "VA");
        newRace("Fairfax City", "VA");
        newRace("McLean", "VA");
        newRace("Rockville", "MD");
        newRace("College Park", "MD");
        newRace("Germantown", "MD");
        newRace("Annapolis", "MD");
    }

    private Race newRace(String city, String state) {
        Race race = new Race();
        raceSeq++;
        long id = raceSeq;
        race.setId(id);
        race.setName(city + " Race");
        race.setCity(city);
        race.setState(state);
        race.setDistance(randomDouble(10));
        race.setMaxRunners(randomInt(10000));
        race.setCost(randomDouble(50));
        race.setStartDateTime(randomDate(100));
        races.add(race);
        return race;
    }

    private int randomInt(int max) {
        return (int)(Math.random() * max);
    }

    private double randomDouble(int max) {
        return randomInt(max * 100)/100.0;
    }

    private Date randomDate(int maxDaysFromToday) {
        long ms = randomInt(maxDaysFromToday) * 24L * 3600L * 1000L;
        return new Date(System.currentTimeMillis() + ms);
    }

    private Registration newRegistration(Race race, String name) {
        Registration reg = new Registration();
        registrationSeq++;
        long id = registrationSeq;
        reg.setId(id);
        reg.setName(name);
        reg.setEmail(name.replace(" ", ".").toLowerCase() + "@novawar.org");
        reg.setCreatedAt(randomDate(-30));
        race.addRegistration(reg);
        registrations.add(reg);
        return reg;
    }

}
