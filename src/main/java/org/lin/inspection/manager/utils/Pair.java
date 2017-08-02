package org.lin.inspection.manager.utils;

public class Pair<H extends Object, M extends Object> {
    private H hour;
    private M minute;

    public Pair(H hour, M minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public H getHour() {
        return hour;
    }

    public void setHour(H hour) {
        this.hour = hour;
    }

    public M getMinute() {
        return minute;
    }

    public void setMinute(M minute) {
        this.minute = minute;
    }
}
