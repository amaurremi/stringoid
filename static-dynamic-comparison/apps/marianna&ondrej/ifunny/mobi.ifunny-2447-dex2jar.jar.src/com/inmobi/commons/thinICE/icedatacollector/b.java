package com.inmobi.commons.thinICE.icedatacollector;

import android.util.Log;

final class b
        implements Runnable {
    public void run() {
        try {
            if (BuildSettings.DEBUG) {
                Log.d("IceDataCollector", "** stop runnable");
            }
            if (!IceDataCollector.a()) {
                if (BuildSettings.DEBUG) {
                    Log.d("IceDataCollector", "ignoring, stop not requested");
                }
                return;
            }
            if (BuildSettings.DEBUG) {
                Log.d("IceDataCollector", "terminating sampling and flushing");
            }
            IceDataCollector.b();
            IceDataCollector.flush();
            IceDataCollector.a(null);
            IceDataCollector.a(null);
            IceDataCollector.a(null);
            return;
        } finally {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/thinICE/icedatacollector/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */