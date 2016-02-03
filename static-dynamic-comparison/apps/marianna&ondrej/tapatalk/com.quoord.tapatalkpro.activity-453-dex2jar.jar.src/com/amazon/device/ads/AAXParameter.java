package com.amazon.device.ads;

import android.location.Location;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class AAXParameter<T> {
    static final AAXParameter<String> ADVERTISING_IDENTIFIER;
    static final AAXParameter<String> APP_KEY;
    static final AAXParameter<String> CHANNEL;
    static final AAXParameter<JSONObject> DEVICE_INFO;
    static final AAXParameter<Long> FLOOR_PRICE = new FloorPriceParameter();
    static final AAXParameter<String> GEOLOCATION;
    private static final String LOG_TAG = AAXParameter.class.getSimpleName();
    static final AAXParameter<String> MAX_SIZE;
    static final AAXParameter<String> MD5_UDID;
    static final AAXParameter<Boolean> OPT_OUT;
    static final AAXParameter<JSONObject> PACKAGE_INFO;
    static final AAXParameter<String> PAGE_TYPE;
    static final AAXParameter<JSONArray> PUBLISHER_ASINS;
    static final AAXParameter<JSONArray> PUBLISHER_KEYWORDS;
    static final AAXParameter<String> SDK_VERSION;
    static final AAXParameter<String> SHA1_UDID;
    static final AAXParameter<String> SIS_DEVICE_IDENTIFIER;
    static final AAXParameter<String> SIZE;
    static final AAXParameter<String> SLOT;
    static final AAXParameter<JSONArray> SLOTS;
    static final AAXParameter<Integer> SLOT_ID;
    static final AAXParameter<String> SLOT_POSITION;
    static final AAXParameter<Boolean> TEST;
    static final AAXParameter<String> USER_AGENT;
    static final AAXParameter<JSONObject> USER_INFO;
    private final String debugName;
    private final String name;

    static {
        APP_KEY = new AppKeyParameter();
        CHANNEL = new StringParameter("c", "debug.channel");
        PUBLISHER_KEYWORDS = new JSONArrayParameter("pk", "debug.pk");
        PUBLISHER_ASINS = new JSONArrayParameter("pa", "debug.pa");
        USER_AGENT = new UserAgentParameter();
        SDK_VERSION = new SDKVersionParameter();
        GEOLOCATION = new GeoLocationParameter();
        USER_INFO = new UserInfoParameter();
        DEVICE_INFO = new DeviceInfoParameter();
        PACKAGE_INFO = new PackageInfoParameter();
        TEST = new TestParameter();
        SIS_DEVICE_IDENTIFIER = new SISDeviceIdentifierParameter();
        SHA1_UDID = new SHA1UDIDParameter();
        MD5_UDID = new MD5UDIDParameter();
        SLOTS = new JSONArrayParameter("slots", "debug.slots");
        ADVERTISING_IDENTIFIER = new AdvertisingIdentifierParameter();
        OPT_OUT = new OptOutParameter();
        SIZE = new SizeParameter();
        PAGE_TYPE = new StringParameter("pt", "debug.pt");
        SLOT = new SlotParameter();
        SLOT_POSITION = new StringParameter("sp", "debug.sp");
        MAX_SIZE = new MaxSizeParameter();
        SLOT_ID = new SlotIdParameter();
    }

    AAXParameter(String paramString1, String paramString2) {
        this.name = paramString1;
        this.debugName = paramString2;
    }

    protected String getDebugName() {
        return this.debugName;
    }

    protected T getDerivedValue(ParameterData paramParameterData) {
        return null;
    }

    protected abstract T getFromDebugProperties();

    String getName() {
        return this.name;
    }

    T getValue(ParameterData paramParameterData) {
        if (hasDebugPropertiesValue()) {
            paramParameterData = getFromDebugProperties();
        }
        for (; ; ) {
            ParameterData localParameterData = paramParameterData;
            if ((paramParameterData instanceof String)) {
                localParameterData = paramParameterData;
                if (Utils.isNullOrWhiteSpace((String) paramParameterData)) {
                    localParameterData = null;
                }
            }
            return localParameterData;
            if (paramParameterData.advancedOptions.containsKey(this.name)) {
                paramParameterData = parseFromString((String) paramParameterData.advancedOptions.remove(this.name));
            } else {
                paramParameterData = getDerivedValue(paramParameterData);
            }
        }
    }

    protected boolean hasDebugPropertiesValue() {
        return DebugProperties.containsDebugProperty(this.debugName);
    }

    protected abstract T parseFromString(String paramString);

    static class AdvertisingIdentifierParameter
            extends AAXParameter.StringParameter {
        AdvertisingIdentifierParameter() {
            super("debug.idfa");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (AAXParameter.ParameterData.access$200(paramParameterData).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
                return AAXParameter.ParameterData.access$200(paramParameterData).getAdvertisingIdentifierInfo().getAdvertisingIdentifier();
            }
            return null;
        }
    }

    static class AppKeyParameter
            extends AAXParameter.StringParameter {
        AppKeyParameter() {
            super("debug.appid");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
        }
    }

    static class BooleanParameter
            extends AAXParameter<Boolean> {
        BooleanParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected Boolean getFromDebugProperties() {
            return DebugProperties.getDebugPropertyAsBoolean(getDebugName(), null);
        }

        protected Boolean parseFromString(String paramString) {
            return Boolean.valueOf(Boolean.parseBoolean(paramString));
        }
    }

    static class DeviceInfoParameter
            extends AAXParameter.JSONObjectParameter {
        DeviceInfoParameter() {
            super("debug.dinfo");
        }

        protected JSONObject getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return InternalAdRegistration.getInstance().getDeviceInfo().toJsonObject(AAXParameter.ParameterData.access$200(paramParameterData).getOrientation());
        }
    }

    static class FloorPriceParameter
            extends AAXParameter.LongParameter {
        FloorPriceParameter() {
            super("debug.ec");
        }

        protected Long getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (AAXParameter.ParameterData.access$300(paramParameterData).getAdTargetingOptions().hasFloorPrice()) {
                return Long.valueOf(AAXParameter.ParameterData.access$300(paramParameterData).getAdTargetingOptions().getFloorPrice());
            }
            return null;
        }
    }

    static class GeoLocationParameter
            extends AAXParameter.StringParameter {
        GeoLocationParameter() {
            super("debug.geoloc");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if ((Configuration.getInstance().getBoolean(Configuration.ConfigOption.SEND_GEO)) && (AAXParameter.ParameterData.access$200(paramParameterData).getAdTargetingOptions().isGeoLocationEnabled())) {
                paramParameterData = new AdLocation().getLocation();
                if (paramParameterData != null) {
                }
            } else {
                return null;
            }
            return paramParameterData.getLatitude() + "," + paramParameterData.getLongitude();
        }
    }

    static class IntegerParameter
            extends AAXParameter<Integer> {
        IntegerParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected Integer getFromDebugProperties() {
            return DebugProperties.getDebugPropertyAsInteger(getDebugName(), null);
        }

        protected Integer parseFromString(String paramString) {
            return Integer.valueOf(Integer.parseInt(paramString));
        }
    }

    static class JSONArrayParameter
            extends AAXParameter<JSONArray> {
        JSONArrayParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected JSONArray getFromDebugProperties() {
            return parseFromString(DebugProperties.getDebugPropertyAsString(getDebugName(), null));
        }

        protected JSONArray parseFromString(String paramString) {
            try {
                paramString = new JSONArray(paramString);
                return paramString;
            } catch (JSONException paramString) {
                Log.e(AAXParameter.LOG_TAG, "Unable to parse the following value into a JSONArray: %s", new Object[]{getName()});
            }
            return null;
        }
    }

    static class JSONObjectParameter
            extends AAXParameter<JSONObject> {
        JSONObjectParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected JSONObject getFromDebugProperties() {
            return parseFromString(DebugProperties.getDebugPropertyAsString(getDebugName(), null));
        }

        protected JSONObject parseFromString(String paramString) {
            try {
                paramString = new JSONObject(paramString);
                return paramString;
            } catch (JSONException paramString) {
                Log.e(AAXParameter.LOG_TAG, "Unable to parse the following value into a JSONObject: %s", new Object[]{getName()});
            }
            return null;
        }
    }

    static class LongParameter
            extends AAXParameter<Long> {
        LongParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected Long getFromDebugProperties() {
            return DebugProperties.getDebugPropertyAsLong(getDebugName(), null);
        }

        protected Long parseFromString(String paramString) {
            return Long.valueOf(Long.parseLong(paramString));
        }
    }

    static class MD5UDIDParameter
            extends AAXParameter.StringParameter {
        MD5UDIDParameter() {
            super("debug.md5udid");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (!AAXParameter.ParameterData.access$200(paramParameterData).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
                return InternalAdRegistration.getInstance().getDeviceInfo().getUdidMd5();
            }
            return null;
        }
    }

    static class MaxSizeParameter
            extends AAXParameter.StringParameter {
        MaxSizeParameter() {
            super("debug.mxsz");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return AAXParameter.ParameterData.access$300(paramParameterData).getAdData().getMaxSize();
        }
    }

    static class OptOutParameter
            extends AAXParameter.BooleanParameter {
        OptOutParameter() {
            super("debug.optOut");
        }

        protected Boolean getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (AAXParameter.ParameterData.access$200(paramParameterData).getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
                return Boolean.valueOf(AAXParameter.ParameterData.access$200(paramParameterData).getAdvertisingIdentifierInfo().isLimitAdTrackingEnabled());
            }
            return null;
        }
    }

    static class PackageInfoParameter
            extends AAXParameter.JSONObjectParameter {
        PackageInfoParameter() {
            super("debug.pkg");
        }

        protected JSONObject getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return InternalAdRegistration.getInstance().getAppInfo().getPackageInfoJSON();
        }
    }

    static class ParameterData {
        private AdRequest adRequest;
        private Map<String, String> advancedOptions;
        private AdRequest.LOISlot loiSlot;

        ParameterData setAdRequest(AdRequest paramAdRequest) {
            this.adRequest = paramAdRequest;
            return this;
        }

        ParameterData setAdvancedOptions(Map<String, String> paramMap) {
            this.advancedOptions = paramMap;
            return this;
        }

        ParameterData setLOISlot(AdRequest.LOISlot paramLOISlot) {
            this.loiSlot = paramLOISlot;
            return this;
        }
    }

    static class SDKVersionParameter
            extends AAXParameter.StringParameter {
        SDKVersionParameter() {
            super("debug.ver");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return Version.getSDKVersion();
        }
    }

    static class SHA1UDIDParameter
            extends AAXParameter.StringParameter {
        SHA1UDIDParameter() {
            super("debug.sha1udid");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (!paramParameterData.adRequest.getAdvertisingIdentifierInfo().hasAdvertisingIdentifier()) {
                return InternalAdRegistration.getInstance().getDeviceInfo().getUdidSha1();
            }
            return null;
        }
    }

    static class SISDeviceIdentifierParameter
            extends AAXParameter.StringParameter {
        SISDeviceIdentifierParameter() {
            super("debug.adid");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return paramParameterData.adRequest.getAdvertisingIdentifierInfo().getSISDeviceIdentifier();
        }
    }

    static class SizeParameter
            extends AAXParameter.StringParameter {
        SizeParameter() {
            super("debug.size");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return paramParameterData.loiSlot.getAdData().getRequestedAdSize().toString();
        }
    }

    static class SlotIdParameter
            extends AAXParameter.IntegerParameter {
        SlotIdParameter() {
            super("debug.slotId");
        }

        protected Integer getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return Integer.valueOf(paramParameterData.loiSlot.getAdData().getSlotId());
        }
    }

    static class SlotParameter
            extends AAXParameter.StringParameter {
        SlotParameter() {
            super("debug.slot");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return paramParameterData.adRequest.getOrientation();
        }
    }

    static class StringParameter
            extends AAXParameter<String> {
        StringParameter(String paramString1, String paramString2) {
            super(paramString2);
        }

        protected String getFromDebugProperties() {
            return DebugProperties.getDebugPropertyAsString(getDebugName(), null);
        }

        protected String parseFromString(String paramString) {
            return paramString;
        }
    }

    static class TestParameter
            extends AAXParameter.BooleanParameter {
        TestParameter() {
            super("debug.test");
        }

        protected Boolean getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return Settings.getInstance().getBoolean("testingEnabled", null);
        }
    }

    static class UserAgentParameter
            extends AAXParameter.StringParameter {
        UserAgentParameter() {
            super("debug.ua");
        }

        protected String getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            return DeviceInfo.getUserAgentString();
        }
    }

    static class UserInfoParameter
            extends AAXParameter.JSONObjectParameter {
        UserInfoParameter() {
            super("debug.ui");
        }

        protected JSONObject getDerivedValue(AAXParameter.ParameterData paramParameterData) {
            if (paramParameterData.adRequest.getAdTargetingOptions().hasAge()) {
                int i = paramParameterData.adRequest.getAdTargetingOptions().getAge();
                paramParameterData = new JSONObject();
                JSONUtils.put(paramParameterData, "age", String.valueOf(i));
                return paramParameterData;
            }
            return null;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AAXParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */