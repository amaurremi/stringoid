package com.inmobi.commons.analytics.db;

import com.inmobi.commons.internal.Log;

class AnalyticsEventsQueue$a
        extends Thread {
    AnalyticsEventsQueue$a(AnalyticsEventsQueue paramAnalyticsEventsQueue) {
    }

    public void run() {
        try {
            while (!this.a.isEmpty()) {
                AnalyticsEventsQueue.a(this.a, (AnalyticsFunctions) this.a.remove(0));
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[Analytics]-4.5.1", "Exception processing function", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsEventsQueue$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */