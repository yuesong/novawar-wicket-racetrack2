package org.novawar.racetrack.web.component;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.novawar.racetrack.domain.PersistentEntity;

/**
 * DefaultPropertyColumn for id property rendered as an IdLink that opens a page.
 * 
 * @author ywang29
 */
public abstract class IdColumn<T extends PersistentEntity> extends DefaultPropertyColumn<T> {

    public IdColumn() {
        super("id");
    }

    @Override
    public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> rowModel) {
        item.add(new IdLink(componentId, rowModel.getObject().getId()){
            @Override
            protected void onClick(Long entityId) {
                setResponsePage(createOnClickResponsePage(entityId));
            }
        });
    }

    /**
     * Returns a Page in response to the IdLink click.
     *
     * @param entityId
     * @return
     */
    protected abstract Page createOnClickResponsePage(Long entityId);
}

