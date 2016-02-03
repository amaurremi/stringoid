package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import org.json.JSONObject;

class AdMetrics {
    public static final String LOG_TAG = "AdMetrics";
    private AdData adData;
    private MetricsCollector globalMetrics;

    public AdMetrics(AdData paramAdData) {
        this.adData = paramAdData;
    }

    protected static void addMetricsToJSON(JSONObject paramJSONObject, MetricsCollector paramMetricsCollector) {
        if (paramMetricsCollector == null) {
        }
        for (; ; ) {
            return;
            Object localObject3 = new HashMap();
            Object localObject4 = new HashMap();
            Object localObject2 = paramMetricsCollector.getAdTypeMetricTag();
            Object localObject1 = localObject2;
            if (localObject2 != null) {
                localObject1 = (String) localObject2 + "_";
            }
            MetricsCollector.MetricHit[] arrayOfMetricHit = (MetricsCollector.MetricHit[]) paramMetricsCollector.getMetricHits().toArray(new MetricsCollector.MetricHit[paramMetricsCollector.getMetricHits().size()]);
            int k = arrayOfMetricHit.length;
            int i = 0;
            if (i < k) {
                Object localObject5 = arrayOfMetricHit[i];
                localObject2 = ((MetricsCollector.MetricHit) localObject5).metric.getAaxName();
                paramMetricsCollector = (MetricsCollector) localObject2;
                if (localObject1 != null) {
                    paramMetricsCollector = (MetricsCollector) localObject2;
                    if (((MetricsCollector.MetricHit) localObject5).metric.isAdTypeSpecific()) {
                        paramMetricsCollector = (String) localObject1 + (String) localObject2;
                    }
                }
                if ((localObject5 instanceof MetricsCollector.MetricHitStartTime)) {
                    paramMetricsCollector = (MetricsCollector.MetricHitStartTime) localObject5;
                    ((HashMap) localObject3).put(((MetricsCollector.MetricHit) localObject5).metric, Long.valueOf(paramMetricsCollector.startTime));
                }
                for (; ; ) {
                    i += 1;
                    break;
                    if ((localObject5 instanceof MetricsCollector.MetricHitStopTime)) {
                        localObject2 = (MetricsCollector.MetricHitStopTime) localObject5;
                        localObject5 = (Long) ((HashMap) localObject3).get(((MetricsCollector.MetricHit) localObject5).metric);
                        if (localObject5 != null) {
                            JSONUtils.put(paramJSONObject, paramMetricsCollector, ((MetricsCollector.MetricHitStopTime) localObject2).stopTime - ((Long) localObject5).longValue());
                        }
                    } else if ((localObject5 instanceof MetricsCollector.MetricHitTotalTime)) {
                        JSONUtils.put(paramJSONObject, paramMetricsCollector, ((MetricsCollector.MetricHitTotalTime) localObject5).totalTime);
                    } else {
                        if ((localObject5 instanceof MetricsCollector.MetricHitIncrement)) {
                            paramMetricsCollector = (MetricsCollector.MetricHitIncrement) localObject5;
                            localObject2 = (Integer) ((HashMap) localObject4).get(((MetricsCollector.MetricHit) localObject5).metric);
                            if (localObject2 == null) {
                            }
                            for (int j = paramMetricsCollector.increment; ; j = ((Integer) localObject2).intValue() + paramMetricsCollector.increment) {
                                ((HashMap) localObject4).put(((MetricsCollector.MetricHit) localObject5).metric, Integer.valueOf(j));
                                break;
                            }
                        }
                        if ((localObject5 instanceof MetricsCollector.MetricHitString)) {
                            JSONUtils.put(paramJSONObject, paramMetricsCollector, ((MetricsCollector.MetricHitString) localObject5).text);
                        }
                    }
                }
            }
            localObject3 = ((HashMap) localObject4).entrySet().iterator();
            while (((Iterator) localObject3).hasNext()) {
                localObject4 = (Map.Entry) ((Iterator) localObject3).next();
                localObject2 = ((Metrics.MetricType) ((Map.Entry) localObject4).getKey()).getAaxName();
                paramMetricsCollector = (MetricsCollector) localObject2;
                if (localObject1 != null) {
                    paramMetricsCollector = (MetricsCollector) localObject2;
                    if (((Metrics.MetricType) ((Map.Entry) localObject4).getKey()).isAdTypeSpecific()) {
                        paramMetricsCollector = (String) localObject1 + (String) localObject2;
                    }
                }
                JSONUtils.put(paramJSONObject, paramMetricsCollector, ((Integer) ((Map.Entry) localObject4).getValue()).intValue());
            }
        }
    }

    private String getAaxUrlAndResetAdMetrics() {
        String str = Utils.getURLEncodedString(getAaxJson());
        str = this.adData.getInstrumentationPixelUrl() + str;
        this.adData.resetMetricsCollector();
        return str;
    }

    public void addGlobalMetrics(MetricsCollector paramMetricsCollector) {
        this.globalMetrics = paramMetricsCollector;
    }

    public boolean canSubmit() {
        if (this.adData == null) {
        }
        do {
            return false;
            str = this.adData.getInstrumentationPixelUrl();
        } while ((str == null) || (str.equals("")));
        String str = InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey();
        if ((str == null) || (str.equals("123"))) {
            Log.d("AdMetrics", "Not submitting metrics because the AppKey is either not set or set to a test key.");
            return false;
        }
        return true;
    }

    protected String getAaxJson() {
        Object localObject = new JSONObject();
        JSONUtils.put((JSONObject) localObject, "c", "msdk");
        JSONUtils.put((JSONObject) localObject, "v", Version.getRawSDKVersion());
        addMetricsToJSON((JSONObject) localObject, this.adData.getMetricsCollector());
        addMetricsToJSON((JSONObject) localObject, this.globalMetrics);
        localObject = ((JSONObject) localObject).toString();
        return ((String) localObject).substring(1, ((String) localObject).length() - 1);
    }

    public WebRequest getAaxWebRequestAndResetAdMetrics() {
        WebRequest localWebRequest = WebRequest.createNewWebRequest();
        localWebRequest.setUrlString(getAaxUrlAndResetAdMetrics());
        return localWebRequest;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AdMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */