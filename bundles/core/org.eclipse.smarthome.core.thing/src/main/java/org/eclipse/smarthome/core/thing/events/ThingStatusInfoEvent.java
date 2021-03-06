/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.thing.events;

import org.eclipse.smarthome.core.events.AbstractEvent;
import org.eclipse.smarthome.core.thing.ThingStatusInfo;
import org.eclipse.smarthome.core.thing.ThingUID;

/**
 * {@link ThingStatusInfoEvent}s will be delivered through the Eclipse SmartHome event bus if the status of a thing has
 * been updated. Thing status info objects must be created with the {@link ThingEventFactory}.
 *
 * @author Stefan Bußweiler - Initial contribution
 */
public class ThingStatusInfoEvent extends AbstractEvent {

    /**
     * The thing status event type.
     */
    public final static String TYPE = ThingStatusInfoEvent.class.getSimpleName();

    private final ThingUID thingUID;

    private final ThingStatusInfo thingStatusInfo;

    /**
     * Creates a new thing status event object.
     *
     * @param topic the topic
     * @param payload the payload
     * @param thingUID the thing UID
     * @param thingStatusInfo the thing status info object
     */
    protected ThingStatusInfoEvent(String topic, String payload, ThingUID thingUID, ThingStatusInfo thingStatusInfo) {
        super(topic, payload, null);
        this.thingUID = thingUID;
        this.thingStatusInfo = thingStatusInfo;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    /**
     * Gets the thing UID.
     *
     * @return the thing UID
     */
    public ThingUID getThingUID() {
        return thingUID;
    }

    /**
     * Gets the thing status info.
     *
     * @return the thing status info
     */
    public ThingStatusInfo getStatusInfo() {
        return thingStatusInfo;
    }

    @Override
    public String toString() {
        return "'" + thingUID + "' updated: " + thingStatusInfo.toString();
    }

}
