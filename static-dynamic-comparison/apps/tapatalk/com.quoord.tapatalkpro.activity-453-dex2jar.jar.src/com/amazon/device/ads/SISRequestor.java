package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;

class SISRequestor {
    protected static final String API_LEVEL_ENDPOINT = "/api3";
    private final SISRequestorCallback sisRequestorCallback;
    private final SISRequest[] sisRequests;

    public SISRequestor(SISRequestorCallback paramSISRequestorCallback, SISRequest... paramVarArgs) {
        this.sisRequestorCallback = paramSISRequestorCallback;
        this.sisRequests = paramVarArgs;
    }

    public SISRequestor(SISRequest... paramVarArgs) {
        this(null, paramVarArgs);
    }

    protected static String getEndpoint(SISRequest paramSISRequest) {
        String str2 = Configuration.getInstance().getString(Configuration.ConfigOption.SIS_URL);
        String str1 = str2;
        int i;
        if (str2 != null) {
            i = str2.indexOf("/");
            if (i <= -1) {
                break label63;
            }
        }
        label63:
        for (str1 = str2.substring(i); ; str1 = "") {
            return str1 + "/api3" + paramSISRequest.getPath();
        }
    }

    protected static String getHostname() {
        String str2 = Configuration.getInstance().getString(Configuration.ConfigOption.SIS_URL);
        String str1 = str2;
        if (str2 != null) {
            int i = str2.indexOf("/");
            str1 = str2;
            if (i > -1) {
                str1 = str2.substring(0, i);
            }
        }
        return str1;
    }

    protected void callSIS() {
        SISRequest[] arrayOfSISRequest = this.sisRequests;
        int j = arrayOfSISRequest.length;
        int i = 0;
        while (i < j) {
            callSIS(arrayOfSISRequest[i]);
            i += 1;
        }
    }

    protected void callSIS(SISRequest paramSISRequest) {
        Object localObject = getWebRequest(paramSISRequest);
        try {
            localObject = ((WebRequest) localObject).makeCall();
            localObject = ((WebRequest.WebResponse) localObject).getJSONObjectBody();
            if (localObject == null) {
                return;
            }
        } catch (WebRequest.WebRequestException paramSISRequest) {
            return;
        }
        int i = JSONUtils.getIntegerFromJSON((JSONObject) localObject, "rcode", 0);
        String str = JSONUtils.getStringFromJSON((JSONObject) localObject, "msg", "");
        if (i == 1) {
            Log.i(paramSISRequest.getLogTag(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(i), str});
            paramSISRequest.onResponseReceived((JSONObject) localObject);
            return;
        }
        Log.w(paramSISRequest.getLogTag(), "Result - code: %d, msg: %s", new Object[]{Integer.valueOf(i), str});
    }

    protected SISRequestorCallback getSisRequestorCallback() {
        return this.sisRequestorCallback;
    }

    protected WebRequest getWebRequest(SISRequest paramSISRequest) {
        WebRequest localWebRequest = WebRequest.createNewWebRequest();
        localWebRequest.setExternalLogTag(paramSISRequest.getLogTag());
        localWebRequest.setHttpMethod(WebRequest.HttpMethod.POST);
        localWebRequest.setHost(getHostname());
        localWebRequest.setPath(getEndpoint(paramSISRequest));
        localWebRequest.enableLog(true);
        if (paramSISRequest.getPostParameters() != null) {
            localObject = paramSISRequest.getPostParameters().entrySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                Map.Entry localEntry = (Map.Entry) ((Iterator) localObject).next();
                localWebRequest.putPostParameter((String) localEntry.getKey(), (String) localEntry.getValue());
            }
        }
        Object localObject = paramSISRequest.getQueryParameters();
        ((WebRequest.QueryStringParameters) localObject).putUrlEncoded("appId", InternalAdRegistration.getInstance().getRegistrationInfo().getAppKey());
        ((WebRequest.QueryStringParameters) localObject).putUrlEncoded("sdkVer", Version.getSDKVersion());
        localWebRequest.setQueryStringParameters((WebRequest.QueryStringParameters) localObject);
        localWebRequest.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
        localWebRequest.setServiceCallLatencyMetric(paramSISRequest.getCallMetricType());
        return localWebRequest;
    }

    public void startCallSIS() {
        callSIS();
        SISRequestorCallback localSISRequestorCallback = getSisRequestorCallback();
        if (localSISRequestorCallback != null) {
            localSISRequestorCallback.onSISCallComplete();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/SISRequestor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */