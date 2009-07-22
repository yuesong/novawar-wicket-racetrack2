package org.novawar.racetrack.web;

import org.novawar.racetrack.domain.Filter;

/**
 * Interface for providing a Filter.
 * 
 * @author ywang29
 */
public interface FilterProvider {
    /**
     * Returns the filter.
     * @return
     */
    Filter getFilter();
}
