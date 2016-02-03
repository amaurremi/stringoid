package com.amazon.device.ads;

import java.util.HashMap;

import org.json.JSONObject;

abstract interface SISRequest {
    public abstract Metrics.MetricType getCallMetricType();

    public abstract String getLogTag();

    public abstract String getPath();

    public abstract HashMap<String, String> getPostParameters();

    public abstract WebRequest.QueryStringParameters getQueryParameters();

    public abstract void onResponseReceived(JSONObject paramJSONObject);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */