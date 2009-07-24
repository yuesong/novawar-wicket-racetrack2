package org.novawar.racetrack.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ywang29
 */
public class Race implements PersistentEntity {
    private Long id;
    private String name;
    private String city;
    private String state;
    private Double cost;
    private Double distance;
    private Integer maxRunners;
    private Date startDateTime;
    private List<Registration> registrations;

    public Race() {}

    public Race(String name) {
        this.name = name;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMaxRunners() {
        return maxRunners;
    }

    public void setMaxRunners(Integer maxRunners) {
        this.maxRunners = maxRunners;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Registration> getRegistrations() {
        if (registrations == null) {
            registrations = new ArrayList<Registration>();
        }
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void addRegistration(Registration registration) {
        getRegistrations().add(registration);
        registration.setRace(this);
    }

    @Override
    public String toString() {
        return "Race[name=" + getName() + "]";
    }

}
