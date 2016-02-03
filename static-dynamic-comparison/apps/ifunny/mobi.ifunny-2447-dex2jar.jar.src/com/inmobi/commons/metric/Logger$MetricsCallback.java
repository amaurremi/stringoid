package com.inmobi.commons.metric;

public abstract interface Logger$MetricsCallback {
    public abstract void dataCollected(EventLog paramEventLog);

    public abstract void movedMetricDataToFileMemory(String paramString);

    public abstract void reportingFailure();

    public abstract void reportingStartedWithRequest(String paramString);

    public abstract void reportingSuccess();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/metric/Logger$MetricsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */