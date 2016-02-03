package com.amazon.device.ads;

import org.json.JSONObject;

class SISGenerateDIDRequest
        extends SISDeviceRequest {
    private static final Metrics.MetricType CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_REGISTER;
    private static final String LOG_TAG = "SISGenerateDIDRequest";
    private static final String PATH = "/generate_did";

    public SISGenerateDIDRequest() {
        setCallMetricType(CALL_METRIC_TYPE);
        setLogTag("SISGenerateDIDRequest");
        setPath("/generate_did");
    }

    public void onResponseReceived(JSONObject paramJSONObject) {
        paramJSONObject = JSONUtils.getStringFromJSON(paramJSONObject, "adId", "");
        if (paramJSONObject.length() > 0) {
            InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(paramJSONObject, getAdvertisingIdentifierInfo());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISGenerateDIDRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */