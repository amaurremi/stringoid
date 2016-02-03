package com.mopub.common.logging;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

final class b
        extends Handler {
    private static final Map<Level, Integer> a = new HashMap(7);

    static {
        a.put(Level.FINEST, Integer.valueOf(2));
        a.put(Level.FINER, Integer.valueOf(2));
        a.put(Level.FINE, Integer.valueOf(2));
        a.put(Level.CONFIG, Integer.valueOf(3));
        a.put(Level.INFO, Integer.valueOf(4));
        a.put(Level.WARNING, Integer.valueOf(5));
        a.put(Level.SEVERE, Integer.valueOf(6));
    }

    public void close() {
    }

    public void flush() {
    }

    public void publish(LogRecord paramLogRecord) {
        if (isLoggable(paramLogRecord)) {
            if (!a.containsKey(paramLogRecord.getLevel())) {
                break label110;
            }
        }
        label110:
        for (int i = ((Integer) a.get(paramLogRecord.getLevel())).intValue(); ; i = 2) {
            String str = paramLogRecord.getMessage() + "\n";
            Throwable localThrowable = paramLogRecord.getThrown();
            paramLogRecord = str;
            if (localThrowable != null) {
                paramLogRecord = str + Log.getStackTraceString(localThrowable);
            }
            Log.println(i, "MoPub", paramLogRecord);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/logging/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */