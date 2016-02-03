package com.amazon.device.ads;

import android.annotation.SuppressLint;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AdRequest {
    private static final String AAX_ENDPOINT = "/e/msdk/ads";
    private static final String LOG_TAG = AdRequest.class.getSimpleName();
    private static final AAXParameter<?>[] PARAMETERS = {AAXParameter.APP_KEY, AAXParameter.CHANNEL, AAXParameter.PUBLISHER_KEYWORDS, AAXParameter.PUBLISHER_ASINS, AAXParameter.USER_AGENT, AAXParameter.SDK_VERSION, AAXParameter.GEOLOCATION, AAXParameter.USER_INFO, AAXParameter.DEVICE_INFO, AAXParameter.PACKAGE_INFO, AAXParameter.TEST, AAXParameter.SIS_DEVICE_IDENTIFIER, AAXParameter.SHA1_UDID, AAXParameter.MD5_UDID, AAXParameter.ADVERTISING_IDENTIFIER, AAXParameter.OPT_OUT};
    private AdvertisingIdentifier.Info advertisingIdentifierInfo;
    private final String connectionType;
    private String instrPixelUrl;
    private final JSONObjectBuilder jsonObjectBuilder;
    private final AdTargetingOptions opt;
    private final String orientation;
    private final Size screenSize;
    protected final Map<Integer, LOISlot> slots;

    @SuppressLint({"UseSparseArrays"})
    AdRequest(AdTargetingOptions paramAdTargetingOptions) {
        this.opt = paramAdTargetingOptions;
        this.slots = new HashMap();
        paramAdTargetingOptions = InternalAdRegistration.getInstance().getDeviceInfo();
        this.orientation = paramAdTargetingOptions.getOrientation();
        this.screenSize = paramAdTargetingOptions.getScreenSize(this.orientation);
        this.connectionType = paramAdTargetingOptions.getConnectionType();
        paramAdTargetingOptions = this.opt.getCopyOfAdvancedOptions();
        AAXParameter.ParameterData localParameterData = new AAXParameter.ParameterData().setAdvancedOptions(paramAdTargetingOptions).setAdRequest(this);
        this.jsonObjectBuilder = new JSONObjectBuilder().setAAXParameters(PARAMETERS).setAdvancedOptions(paramAdTargetingOptions).setParameterData(localParameterData);
    }

    AdTargetingOptions getAdTargetingOptions() {
        return this.opt;
    }

    AdvertisingIdentifier.Info getAdvertisingIdentifierInfo() {
        return this.advertisingIdentifierInfo;
    }

    public String getInstrumentationPixelURL() {
        return this.instrPixelUrl;
    }

    String getOrientation() {
        return this.orientation;
    }

    protected JSONArray getSlots() {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.slots.values().iterator();
        while (localIterator.hasNext()) {
            localJSONArray.put(((LOISlot) localIterator.next()).getJSON());
        }
        return localJSONArray;
    }

    public WebRequest getWebRequest() {
        WebRequest localWebRequest = WebRequest.createNewWebRequest();
        localWebRequest.setExternalLogTag(LOG_TAG);
        localWebRequest.setHttpMethod(WebRequest.HttpMethod.POST);
        localWebRequest.setHost(Configuration.getInstance().getString(Configuration.ConfigOption.AAX_HOSTNAME));
        localWebRequest.setPath("/e/msdk/ads");
        localWebRequest.enableLog(true);
        localWebRequest.setContentType("application/json");
        setParametersInWebRequest(localWebRequest);
        return localWebRequest;
    }

    public void putSlot(AdData paramAdData, AdTargetingOptions paramAdTargetingOptions) {
        paramAdData.setConnectionType(this.connectionType);
        paramAdData.setScreenHeight(this.screenSize.getHeight());
        paramAdData.setScreenWidth(this.screenSize.getWidth());
        if (getAdvertisingIdentifierInfo().hasSISDeviceIdentifier()) {
            paramAdData.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_IDENTIFIED_DEVICE);
        }
        paramAdData = new LOISlot(paramAdData, paramAdTargetingOptions, this);
        this.slots.put(Integer.valueOf(paramAdData.getAdData().getSlotId()), paramAdData);
    }

    AdRequest setAdvertisingIdentifierInfo(AdvertisingIdentifier.Info paramInfo) {
        this.advertisingIdentifierInfo = paramInfo;
        return this;
    }

    public void setInstrumentationPixelURL(String paramString) {
        this.instrPixelUrl = paramString;
    }

    protected void setParametersInWebRequest(WebRequest paramWebRequest) {
        this.jsonObjectBuilder.build();
        Object localObject2 = AAXParameter.SLOTS.getValue(this.jsonObjectBuilder.getParameterData());
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = getSlots();
        }
        this.jsonObjectBuilder.putIntoJSON(AAXParameter.SLOTS, localObject1);
        localObject1 = this.jsonObjectBuilder.getJSON();
        localObject2 = DebugProperties.getDebugPropertyAsString("debug.aaxAdParams", null);
        if (!Utils.isNullOrEmpty((String) localObject2)) {
            paramWebRequest.setAdditionalQueryParamsString((String) localObject2);
        }
        setRequestBodyString(paramWebRequest, (JSONObject) localObject1);
    }

    protected void setRequestBodyString(WebRequest paramWebRequest, JSONObject paramJSONObject) {
        paramWebRequest.setRequestBodyString(paramJSONObject.toString());
    }

    static class JSONObjectBuilder {
        private AAXParameter<?>[] aaxParameters;
        private Map<String, String> advancedOptions;
        private final JSONObject json = new JSONObject();
        private AAXParameter.ParameterData parameterData;

        void build() {
            Object localObject1 = this.aaxParameters;
            int j = localObject1.length;
            int i = 0;
            Object localObject2;
            while (i < j) {
                localObject2 = localObject1[i];
                putIntoJSON((AAXParameter) localObject2, ((AAXParameter) localObject2).getValue(this.parameterData));
                i += 1;
            }
            if (this.advancedOptions != null) {
                localObject1 = this.advancedOptions.entrySet().iterator();
                while (((Iterator) localObject1).hasNext()) {
                    localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                    if (!Utils.isNullOrWhiteSpace((String) ((Map.Entry) localObject2).getValue())) {
                        putIntoJSON((String) ((Map.Entry) localObject2).getKey(), ((Map.Entry) localObject2).getValue());
                    }
                }
            }
        }

        JSONObject getJSON() {
            return this.json;
        }

        AAXParameter.ParameterData getParameterData() {
            return this.parameterData;
        }

        void putIntoJSON(AAXParameter<?> paramAAXParameter, Object paramObject) {
            putIntoJSON(paramAAXParameter.getName(), paramObject);
        }

        void putIntoJSON(String paramString, Object paramObject) {
            if (paramObject != null) {
            }
            try {
                this.json.put(paramString, paramObject);
                return;
            } catch (JSONException localJSONException) {
                Log.d(AdRequest.LOG_TAG, "Could not add parameter to JSON %s: %s", new Object[]{paramString, paramObject});
            }
        }

        JSONObjectBuilder setAAXParameters(AAXParameter<?>[] paramArrayOfAAXParameter) {
            this.aaxParameters = paramArrayOfAAXParameter;
            return this;
        }

        JSONObjectBuilder setAdvancedOptions(Map<String, String> paramMap) {
            this.advancedOptions = paramMap;
            return this;
        }

        JSONObjectBuilder setParameterData(AAXParameter.ParameterData paramParameterData) {
            this.parameterData = paramParameterData;
            return this;
        }
    }

    static class LOISlot {
        static final AAXParameter<?>[] PARAMETERS = {AAXParameter.SIZE, AAXParameter.PAGE_TYPE, AAXParameter.SLOT, AAXParameter.SLOT_POSITION, AAXParameter.MAX_SIZE, AAXParameter.SLOT_ID, AAXParameter.FLOOR_PRICE};
        private final AdData adData;
        private final AdRequest.JSONObjectBuilder jsonObjectBuilder;
        private final AdTargetingOptions opt;

        LOISlot(AdData paramAdData, AdTargetingOptions paramAdTargetingOptions, AdRequest paramAdRequest) {
            this.adData = paramAdData;
            this.opt = paramAdTargetingOptions;
            paramAdData = this.opt.getCopyOfAdvancedOptions();
            paramAdTargetingOptions = new AAXParameter.ParameterData().setAdvancedOptions(paramAdData).setLOISlot(this).setAdRequest(paramAdRequest);
            this.jsonObjectBuilder = new AdRequest.JSONObjectBuilder().setAAXParameters(PARAMETERS).setAdvancedOptions(paramAdData).setParameterData(paramAdTargetingOptions);
        }

        AdData getAdData() {
            return this.adData;
        }

        AdTargetingOptions getAdTargetingOptions() {
            return this.opt;
        }

        JSONObject getJSON() {
            this.jsonObjectBuilder.build();
            return this.jsonObjectBuilder.getJSON();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */