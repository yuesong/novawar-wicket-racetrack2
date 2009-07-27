package org.novawar.racetrack.web.model;

import java.util.List;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.novawar.racetrack.domain.OrderBy;
import org.novawar.racetrack.domain.Race;
import org.novawar.racetrack.web.RaceTrackApplication;

/**
 *
 * @author ywang29
 */
public class RaceListModel extends LoadableDetachableModel<List<Race>> implements IModel<List<Race>> {
    
    private static final long serialVersionUID = 1L;

    private String sortProperty;
    private boolean ascending;
    
    public RaceListModel() {
        this("name", true);
    }
    
    public RaceListModel(String sortProperty, boolean ascending) {
        this.sortProperty = sortProperty;
        this.ascending = ascending;
    }

    @Override
    protected List<Race> load() {
        return RaceTrackApplication.get().getService().getRaces(0, 100000, null,
                new OrderBy(sortProperty, ascending));
    }
}
