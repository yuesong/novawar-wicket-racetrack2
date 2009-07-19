package org.novawar.racetrack.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ywang29
 */
public class OrderBy implements Comparator<Object> {

    private String sortProperty;
    private boolean ascending;

    public OrderBy(String sortProperty, boolean ascending) {
        this.sortProperty = sortProperty;
        this.ascending = ascending;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public String getSortProperty() {
        return sortProperty;
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = sortProperty;
    }

    public int compare(Object o1, Object o2) {
        Comparable v1 = (Comparable) Utils.getPropertyValue(o1, getSortProperty());
        Comparable v2 = (Comparable) Utils.getPropertyValue(o2, getSortProperty());
        int result;
        if (v1 == null && v2 == null) {
            result = 0;
        } else if (v1 == null && v2 != null) {
            result = 1;
        } else if (v1 != null && v2 == null) {
            result = -1;
        } else {
            result = v1.compareTo(v2);
        }
        return isAscending() ? result : -result;
    }

    public void sort(List<?> list) {
        if (getSortProperty() != null) {
            Collections.sort(list, this);
        }
    }

}
