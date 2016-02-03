package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class AppEvent {
    private final String eventName;
    private final HashMap<String, String> properties;
    private final long timestamp;

    protected AppEvent(String paramString) {
        this(paramString, -1L);
    }

    public AppEvent(String paramString, long paramLong) {
        this.eventName = paramString;
        this.timestamp = paramLong;
        this.properties = new HashMap();
    }

    public static AppEvent createAppEventWithTimestamp(AppEvent paramAppEvent, long paramLong) {
        return new AppEvent(paramAppEvent.eventName, paramLong);
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getProperty(String paramString) {
        return (String) this.properties.get(paramString);
    }

    public Set<Map.Entry<String, String>> getPropertyEntries() {
        return this.properties.entrySet();
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public AppEvent setProperty(String paramString1, String paramString2) {
        this.properties.put(paramString1, paramString2);
        return this;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder(65);
        localStringBuilder.append("Application Event {Name: ");
        localStringBuilder.append(this.eventName);
        localStringBuilder.append(", Timestamp: ");
        localStringBuilder.append(this.timestamp);
        Iterator localIterator = this.properties.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            localStringBuilder.append(", ");
            localStringBuilder.append(str);
            localStringBuilder.append(": ");
            localStringBuilder.append((String) this.properties.get(str));
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AppEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */