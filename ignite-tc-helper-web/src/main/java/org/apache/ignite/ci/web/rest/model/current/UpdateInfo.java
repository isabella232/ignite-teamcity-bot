package org.apache.ignite.ci.web.rest.model.current;

/**
 * Created by Дмитрий on 19.02.2018
 */
public class UpdateInfo {
    /** Update required, set by background updater. */
    public boolean updateRequired = false;

    /** Running updates is in progress, summary is ready, but it is subject to change */
    public int runningUpdates = 0;

    /** Hash code hexadecimal, protects from redraw and minimizing mode info in case data not changed */
    public String hashCodeHex;

    public UpdateInfo copyFrom(UpdateInfo info) {
        this.updateRequired = info.updateRequired;
        this.runningUpdates = info.runningUpdates;
        this.hashCodeHex = info.hashCodeHex;

        return this;
    }
}