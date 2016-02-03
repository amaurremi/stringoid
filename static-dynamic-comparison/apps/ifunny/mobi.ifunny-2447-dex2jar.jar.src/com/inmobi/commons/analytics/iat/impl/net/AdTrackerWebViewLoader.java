package com.inmobi.commons.analytics.iat.impl.net;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

import java.net.URLDecoder;
import java.util.concurrent.atomic.AtomicBoolean;

import org.json.JSONObject;

public class AdTrackerWebViewLoader {
    private static WebView a = null;
    private static AtomicBoolean b;
    private long c = 0L;
    private long d = 0L;
    private Goal e;

    @SuppressLint({"SetJavaScriptEnabled"})
    public AdTrackerWebViewLoader() {
        AdTrackerNetworkInterface.getUIHandler().post(new AdTrackerWebViewLoader.e(this));
    }

    private AdTrackerWebViewLoader.d a(String paramString) {
        AdTrackerWebViewLoader.d locald = new AdTrackerWebViewLoader.d();
        try {
            arrayOfString1 = paramString.split("&");
            k = 0;
            paramString = null;
            i = 0;
        } catch (Exception paramString) {
            for (; ; ) {
                String[] arrayOfString1;
                int k;
                int m;
                int n;
                int j = 0;
                continue;
                m += 1;
                int i = n;
                continue;
                k += 1;
            }
        }
        j = i;
        try {
            if (k < arrayOfString1.length) {
                j = i;
                String[] arrayOfString2 = arrayOfString1[k].split("=");
                m = 0;
                j = i;
                if (m >= arrayOfString2.length) {
                    break label407;
                }
                j = i;
                if ("err".equals(arrayOfString2[m])) {
                    j = i;
                    n = Integer.parseInt(arrayOfString2[(m + 1)]);
                    break label395;
                }
                j = i;
                n = i;
                if (!"res".equals(arrayOfString2[m])) {
                    break label395;
                }
                paramString = arrayOfString2[(m + 1)];
                n = i;
                break label395;
            }
            j = i;
            AdTrackerWebViewLoader.d.a(locald, i);
            j = i;
            AdTrackerWebViewLoader.d.a(locald, paramString);
            if (5003 == i) {
                j = i;
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Webview Timeout " + paramString);
            } else if (5001 == i) {
                j = i;
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Invalid params passed " + paramString);
            }
        } catch (Exception paramString) {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, j, null);
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Check content Exception", paramString);
            return null;
        }
        if (5002 == i) {
            j = i;
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "XMLHTTP request not supported " + paramString);
        } else if (5005 == i) {
            j = i;
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Invalid JSON Response " + paramString);
        } else if (5004 == i) {
            j = i;
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Webview Server Error " + paramString);
        } else if (5000 == i) {
            j = i;
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Webview response " + URLDecoder.decode(paramString, "utf-8"));
        }
        label395:
        label407:
        return locald;
    }

    private boolean b(String paramString) {
        try {
            paramString = new JSONObject(URLDecoder.decode(paramString, "utf-8"));
            JSONObject localJSONObject = paramString.getJSONObject("iat_ids");
            String str = paramString.getString("errmsg");
            int i = paramString.getInt("timetoLive");
            int j = paramString.getInt("errcode");
            if (j != 6000) {
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, j, null);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Failed to upload goal in webview" + str);
                return false;
            }
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, this.e, 0, this.d, 0, null);
            paramString = localJSONObject.toString();
            if (j == 6001) {
                paramString = null;
            }
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", paramString);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive", Integer.toString(i));
            return true;
        } catch (Exception paramString) {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, this.e, 0, 0L, 424, paramString.getMessage());
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to upload goal in webview", paramString);
        }
        return false;
    }

    public static WebView getWebview() {
        return a;
    }

    public static boolean isWebviewLoading() {
        return b.get();
    }

    public void deinit(int paramInt) {
        AdTrackerNetworkInterface.getUIHandler().postDelayed(new AdTrackerWebViewLoader.a(this), paramInt);
    }

    public boolean loadWebview(Goal paramGoal) {
        this.e = paramGoal;
        try {
            AdTrackerNetworkInterface.getUIHandler().post(new AdTrackerWebViewLoader.b(this));
            return true;
        } catch (Exception paramGoal) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", paramGoal.toString());
        }
        return false;
    }

    public void stopLoading() {
        AdTrackerNetworkInterface.getUIHandler().post(new AdTrackerWebViewLoader.c(this));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerWebViewLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */