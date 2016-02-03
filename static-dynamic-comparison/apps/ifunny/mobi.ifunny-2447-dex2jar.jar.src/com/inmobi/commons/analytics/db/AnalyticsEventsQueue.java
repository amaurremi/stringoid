package com.inmobi.commons.analytics.db;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnalyticsEventsQueue
        extends Vector<AnalyticsFunctions> {
    private static AnalyticsEventsQueue a;
    private static final long serialVersionUID = -1291938489149189478L;
    private AtomicBoolean b = new AtomicBoolean(false);

    private void a(AnalyticsFunctions paramAnalyticsFunctions) {
        paramAnalyticsFunctions.processFunction();
    }

    public static AnalyticsEventsQueue getInstance() {
        try {
            if (a == null) {
                a = new AnalyticsEventsQueue();
            }
            AnalyticsEventsQueue localAnalyticsEventsQueue = a;
            return localAnalyticsEventsQueue;
        } finally {
        }
    }

    public boolean isEmpty() {
        try {
            boolean bool = super.isEmpty();
            if (bool) {
                this.b.set(false);
            }
            return bool;
        } finally {
        }
    }

    public void processFunctions() {
        try {
            if (!this.b.get()) {
                this.b.set(true);
                new AnalyticsEventsQueue.a(this).start();
            }
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/db/AnalyticsEventsQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */