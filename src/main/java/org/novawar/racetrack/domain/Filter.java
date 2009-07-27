package org.novawar.racetrack.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ywang29
 */
public class Filter {
    private String property;
    private Object value;

    public Filter(String property, Object value) {
        this.property = property;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public <T> List<T> filter(List<T> list) {
        if (getProperty() == null) {
            return list;
        }
        List<T> result = new ArrayList<T>(list.size());
        for(T obj : list) {
            Object actualValue = Utils.getPropertyValue(obj, getProperty());
            if ((getValue() == null && actualValue == null) ||
                    (getValue() != null && getValue().equals(actualValue))) {
                result.add(obj);
            }
        }
        return result;
    }
}
