package com.amazon.device.ads;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

class SISRegisterEventRequest
        implements SISRequest {
    private static final Metrics.MetricType CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_REGISTER_EVENT;
    private static final String LOG_TAG = "SISRegisterEventRequest";
    private static final String PATH = "/register_event";
    private final AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final JSONArray appEvents;

    public SISRegisterEventRequest(AdvertisingIdentifier.Info paramInfo, JSONArray paramJSONArray) {
        this.advertisingIdentifierInfo = paramInfo;
        this.appEvents = paramJSONArray;
    }

    public Metrics.MetricType getCallMetricType() {
        return CALL_METRIC_TYPE;
    }

    public String getLogTag() {
        return "SISRegisterEventRequest";
    }

    public String getPath() {
        return "/register_event";
    }

    public HashMap<String, String> getPostParameters() {
        HashMap localHashMap = new HashMap();
        localHashMap.put("events", this.appEvents.toString());
        return localHashMap;
    }

    public WebRequest.QueryStringParameters getQueryParameters() {
        WebRequest.QueryStringParameters localQueryStringParameters = new WebRequest.QueryStringParameters();
        localQueryStringParameters.putUrlEncoded("adId", this.advertisingIdentifierInfo.getSISDeviceIdentifier());
        localQueryStringParameters.putUrlEncoded("dt", DeviceInfo.getDeviceType());
        RegistrationInfo localRegistrationInfo = InternalAdRegistration.getInstance().getRegistrationInfo();
        localQueryStringParameters.putUrlEncoded("app", localRegistrationInfo.getAppName());
        localQueryStringParameters.putUrlEncoded("appId", localRegistrationInfo.getAppKey());
        localQueryStringParameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration.ConfigOption.SIS_DOMAIN));
        return localQueryStringParameters;
    }

    public void onResponseReceived(JSONObject paramJSONObject) {
        int i = JSONUtils.getIntegerFromJSON(paramJSONObject, "rcode", 0);
        if (i == 1) {
            Log.d("SISRegisterEventRequest", "Application events registered successfully.");
            AppEventRegistrationHandler.getInstance().onAppEventsRegistered();
            return;
        }
        Log.d("SISRegisterEventRequest", "Application events not registered. rcode:" + i);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISRegisterEventRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */