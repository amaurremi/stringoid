package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.a.n;

import java.util.Iterator;
import java.util.Set;

public class BoltsMeasurementEventListener
        extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private static BoltsMeasurementEventListener _instance;
    private Context applicationContext;

    private BoltsMeasurementEventListener(Context paramContext) {
        this.applicationContext = paramContext.getApplicationContext();
    }

    private void close() {
        n.a(this.applicationContext).a(this);
    }

    static BoltsMeasurementEventListener getInstance(Context paramContext) {
        if (_instance != null) {
            return _instance;
        }
        _instance = new BoltsMeasurementEventListener(paramContext);
        _instance.open();
        return _instance;
    }

    private void open() {
        n.a(this.applicationContext).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    protected void finalize() {
        try {
            close();
            return;
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        paramContext = AppEventsLogger.newLogger(paramContext);
        String str1 = "bf_" + paramIntent.getStringExtra("event_name");
        paramIntent = paramIntent.getBundleExtra("event_args");
        Bundle localBundle = new Bundle();
        Iterator localIterator = paramIntent.keySet().iterator();
        while (localIterator.hasNext()) {
            String str2 = (String) localIterator.next();
            localBundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) paramIntent.get(str2));
        }
        paramContext.logEvent(str1, localBundle);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/BoltsMeasurementEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */