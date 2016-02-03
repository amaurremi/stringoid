package com.amazon.device.ads;

import org.json.JSONObject;

class SISUpdateDeviceInfoRequest
        extends SISDeviceRequest {
    private static final Metrics.MetricType CALL_METRIC_TYPE = Metrics.MetricType.SIS_LATENCY_UPDATE_DEVICE_INFO;
    private static final String LOG_TAG = "SISUpdateDeviceInfoRequest";
    private static final String PATH = "/update_dev_info";

    public SISUpdateDeviceInfoRequest() {
        setCallMetricType(CALL_METRIC_TYPE);
        setLogTag("SISUpdateDeviceInfoRequest");
        setPath("/update_dev_info");
    }

    public WebRequest.QueryStringParameters getQueryParameters() {
        String str = DebugProperties.getDebugPropertyAsString("debug.adid", getAdvertisingIdentifierInfo().getSISDeviceIdentifier());
        WebRequest.QueryStringParameters localQueryStringParameters = super.getQueryParameters();
        if (!Utils.isNullOrEmpty(str)) {
            localQueryStringParameters.putUrlEncoded("adId", str);
        }
        return localQueryStringParameters;
    }

    public void onResponseReceived(JSONObject paramJSONObject) {
        String str = JSONUtils.getStringFromJSON(paramJSONObject, "adId", "");
        if (JSONUtils.getBooleanFromJSON(paramJSONObject, "idChanged", false)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED);
        }
        if (str.length() > 0) {
            InternalAdRegistration.getInstance().getRegistrationInfo().putAdId(str, getAdvertisingIdentifierInfo());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISUpdateDeviceInfoRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */