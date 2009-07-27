package org.novawar.racetrack.web.component;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.link.Link;

/**
 * Link that displays a PersistentEntity's ID.
 * 
 * @author ywang29
 */
public abstract class IdLink extends Link {

        private Long entityId;

        public IdLink(String id, Long entityId) {
            super(id);
            this.entityId = entityId;
        }

        @Override
        public void onClick() {
            onClick(entityId);
        }

        protected abstract void onClick(Long entityId);

        @Override
        protected void onComponentTag(ComponentTag tag) {
            tag.setName("a");
            super.onComponentTag(tag);
        }

        @Override
        protected void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
            replaceComponentTagBody(markupStream, openTag, entityId.toString());
        }
    }

