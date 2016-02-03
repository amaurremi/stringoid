package com.amazon.device.ads;

import java.util.HashMap;

abstract class SISDeviceRequest
        implements SISRequest {
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private Metrics.MetricType callMetricType;
    private String logTag;
    private String path;

    private static String convertOptOutBooleanToStringInt(boolean paramBoolean) {
        if (paramBoolean) {
            return "1";
        }
        return "0";
    }

    public static String getDInfoProperty() {
        return String.format("{\"make\":\"%s\",\"model\":\"%s\",\"os\":\"%s\",\"osVersion\":\"%s\"}", new Object[]{DeviceInfo.getMake(), DeviceInfo.getModel(), DeviceInfo.getOS(), DeviceInfo.getOSVersion()});
    }

    protected AdvertisingIdentifier.Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }

    public Metrics.MetricType getCallMetricType() {
        return this.callMetricType;
    }

    public String getLogTag() {
        return this.logTag;
    }

    public String getPath() {
        return this.path;
    }

    public HashMap<String, String> getPostParameters() {
        return null;
    }

    public WebRequest.QueryStringParameters getQueryParameters() {
        WebRequest.QueryStringParameters localQueryStringParameters = new WebRequest.QueryStringParameters();
        localQueryStringParameters.putUrlEncoded("dt", DeviceInfo.getDeviceType());
        localQueryStringParameters.putUrlEncoded("app", InternalAdRegistration.getInstance().getRegistrationInfo().getAppName());
        localQueryStringParameters.putUrlEncoded("aud", Configuration.getInstance().getString(Configuration.ConfigOption.SIS_DOMAIN));
        localQueryStringParameters.putUrlEncoded("ua", Utils.getURLEncodedString(DeviceInfo.getUserAgentString()));
        localQueryStringParameters.putUrlEncoded("dinfo", Utils.getURLEncodedString(getDInfoProperty()));
        localQueryStringParameters.putUrlEncoded("pkg", Utils.getURLEncodedString(InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSONString()));
        Object localObject;
        if (this.advertisingIdentifierInfo.hasAdvertisingIdentifier()) {
            localQueryStringParameters.putUrlEncoded("idfa", this.advertisingIdentifierInfo.getAdvertisingIdentifier());
            localQueryStringParameters.putUrlEncoded("oo", convertOptOutBooleanToStringInt(this.advertisingIdentifierInfo.isLimitAdTrackingEnabled()));
            localObject = AdvertisingIdentifier.getAndClearTransition();
            if (localObject == null) {
                break label230;
            }
        }
        label230:
        for (boolean bool = true; ; bool = false) {
            localQueryStringParameters.putUrlEncodedIfTrue("aidts", (String) localObject, bool);
            return localQueryStringParameters;
            localObject = InternalAdRegistration.getInstance().getDeviceInfo();
            localQueryStringParameters.putUrlEncoded("sha1_mac", ((DeviceInfo) localObject).getMacSha1());
            localQueryStringParameters.putUrlEncoded("sha1_serial", ((DeviceInfo) localObject).getSerialSha1());
            localQueryStringParameters.putUrlEncoded("sha1_udid", ((DeviceInfo) localObject).getUdidSha1());
            localQueryStringParameters.putUrlEncodedIfTrue("badMac", "true", ((DeviceInfo) localObject).isMacBad());
            localQueryStringParameters.putUrlEncodedIfTrue("badSerial", "true", ((DeviceInfo) localObject).isSerialBad());
            localQueryStringParameters.putUrlEncodedIfTrue("badUdid", "true", ((DeviceInfo) localObject).isUdidBad());
            break;
        }
    }

    public SISDeviceRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier.Info paramInfo) {
        this.advertisingIdentifierInfo = paramInfo;
        return this;
    }

    public SISDeviceRequest setCallMetricType(Metrics.MetricType paramMetricType) {
        this.callMetricType = paramMetricType;
        return this;
    }

    public SISDeviceRequest setLogTag(String paramString) {
        this.logTag = paramString;
        return this;
    }

    public SISDeviceRequest setPath(String paramString) {
        this.path = paramString;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */