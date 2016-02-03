package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;

public class Queuer {
    private StringBuffer a = new StringBuffer();
    private long b = 0L;

    long a() {
        return this.b;
    }

    public String get() {
        Log.internal("[InMobi]-4.5.1", "Reading from queue");
        synchronized (this.a) {
            String str = this.a.toString();
            return str;
        }
    }

    public void log(EventLog paramEventLog) {
        synchronized (this.a) {
            this.a.append(paramEventLog.toString()).append(',');
            this.b += 1L;
            return;
        }
    }

    public void reset() {
        Log.internal("[InMobi]-4.5.1", "Resetting queue");
        synchronized (this.a) {
            this.a = new StringBuffer();
            this.b = 0L;
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/metric/Queuer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */