package com.facebook;

import android.os.Bundle;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;

class AppEventsLogger$SessionEventsState {
    public static final String ENCODED_EVENTS_KEY = "encoded_events";
    public static final String EVENT_COUNT_KEY = "event_count";
    public static final String NUM_SKIPPED_KEY = "num_skipped";
    private final int MAX_ACCUMULATED_LOG_EVENTS = 1000;
    private List<AppEventsLogger.AppEvent> accumulatedEvents = new ArrayList();
    private AttributionIdentifiers attributionIdentifiers;
    private String hashedDeviceAndAppId;
    private List<AppEventsLogger.AppEvent> inFlightEvents = new ArrayList();
    private int numSkippedEventsDueToFullBuffer;
    private String packageName;

    public AppEventsLogger$SessionEventsState(AttributionIdentifiers paramAttributionIdentifiers, String paramString1, String paramString2) {
        this.attributionIdentifiers = paramAttributionIdentifiers;
        this.packageName = paramString1;
        this.hashedDeviceAndAppId = paramString2;
    }

    private byte[] getStringAsByteArray(String paramString) {
        try {
            paramString = paramString.getBytes("UTF-8");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            Utility.logd("Encoding exception: ", paramString);
        }
        return null;
    }

    private void populateRequest(Request paramRequest, int paramInt, JSONArray paramJSONArray, boolean paramBoolean1, boolean paramBoolean2) {
        Object localObject = GraphObject.Factory.create();
        ((GraphObject) localObject).setProperty("event", "CUSTOM_APP_EVENTS");
        if (this.numSkippedEventsDueToFullBuffer > 0) {
            ((GraphObject) localObject).setProperty("num_skipped_events", Integer.valueOf(paramInt));
        }
        if (paramBoolean1) {
            Utility.setAppEventAttributionParameters((GraphObject) localObject, this.attributionIdentifiers, this.hashedDeviceAndAppId, paramBoolean2);
        }
        try {
            Utility.setAppEventExtendedDeviceInfoParameters((GraphObject) localObject, AppEventsLogger.access$1000());
            ((GraphObject) localObject).setProperty("application_package_name", this.packageName);
            paramRequest.setGraphObject((GraphObject) localObject);
            Bundle localBundle = paramRequest.getParameters();
            localObject = localBundle;
            if (localBundle == null) {
                localObject = new Bundle();
            }
            paramJSONArray = paramJSONArray.toString();
            if (paramJSONArray != null) {
                ((Bundle) localObject).putByteArray("custom_events_file", getStringAsByteArray(paramJSONArray));
                paramRequest.setTag(paramJSONArray);
            }
            paramRequest.setParameters((Bundle) localObject);
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public void accumulatePersistedEvents(List<AppEventsLogger.AppEvent> paramList) {
        try {
            this.accumulatedEvents.addAll(paramList);
            return;
        } finally {
            paramList =finally;
            throw paramList;
        }
    }

    /* Error */
    public void addEvent(AppEventsLogger.AppEvent paramAppEvent) {
        // Byte code:
        //   0: aload_0
        //   1: monitorenter
        //   2: aload_0
        //   3: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
        //   6: invokeinterface 162 1 0
        //   11: aload_0
        //   12: getfield 37	com/facebook/AppEventsLogger$SessionEventsState:inFlightEvents	Ljava/util/List;
        //   15: invokeinterface 162 1 0
        //   20: iadd
        //   21: sipush 1000
        //   24: if_icmplt +16 -> 40
        //   27: aload_0
        //   28: aload_0
        //   29: getfield 87	com/facebook/AppEventsLogger$SessionEventsState:numSkippedEventsDueToFullBuffer	I
        //   32: iconst_1
        //   33: iadd
        //   34: putfield 87	com/facebook/AppEventsLogger$SessionEventsState:numSkippedEventsDueToFullBuffer	I
        //   37: aload_0
        //   38: monitorexit
        //   39: return
        //   40: aload_0
        //   41: getfield 35	com/facebook/AppEventsLogger$SessionEventsState:accumulatedEvents	Ljava/util/List;
        //   44: aload_1
        //   45: invokeinterface 166 2 0
        //   50: pop
        //   51: goto -14 -> 37
        //   54: astore_1
        //   55: aload_0
        //   56: monitorexit
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	SessionEventsState
        //   0	59	1	paramAppEvent	AppEventsLogger.AppEvent
        // Exception table:
        //   from	to	target	type
        //   2	37	54	finally
        //   40	51	54	finally
    }

    public void clearInFlightAndStats(boolean paramBoolean) {
        if (paramBoolean) {
        }
        try {
            this.accumulatedEvents.addAll(this.inFlightEvents);
            this.inFlightEvents.clear();
            this.numSkippedEventsDueToFullBuffer = 0;
            return;
        } finally {
        }
    }

    public int getAccumulatedEventCount() {
        try {
            int i = this.accumulatedEvents.size();
            return i;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public List<AppEventsLogger.AppEvent> getEventsToPersist() {
        try {
            List localList = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            return localList;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public int populateRequest(Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        int i;
        JSONArray localJSONArray;
        try {
            i = this.numSkippedEventsDueToFullBuffer;
            this.inFlightEvents.addAll(this.accumulatedEvents);
            this.accumulatedEvents.clear();
            localJSONArray = new JSONArray();
            Iterator localIterator = this.inFlightEvents.iterator();
            while (localIterator.hasNext()) {
                AppEventsLogger.AppEvent localAppEvent = (AppEventsLogger.AppEvent) localIterator.next();
                if ((paramBoolean1) || (!localAppEvent.getIsImplicit())) {
                    localJSONArray.put(localAppEvent.getJSONObject());
                }
            }
            if (localJSONArray.length() != 0) {
                break label116;
            }
        } finally {
        }
        return 0;
        label116:
        populateRequest(paramRequest, i, localJSONArray, paramBoolean2, paramBoolean3);
        return localJSONArray.length();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger$SessionEventsState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */