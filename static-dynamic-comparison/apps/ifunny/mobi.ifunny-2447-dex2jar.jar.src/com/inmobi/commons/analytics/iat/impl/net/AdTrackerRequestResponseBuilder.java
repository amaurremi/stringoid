package com.inmobi.commons.analytics.iat.impl.net;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AdTrackerRequestResponseBuilder {
    private static String a = null;
    private static long b = 0L;

    protected static String formHTTPRequest(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3) {
        LinkedList localLinkedList = new LinkedList();
        String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
        if ((paramString1 != null) && (!paramString1.trim().equals(""))) {
            localLinkedList.add(new BasicNameValuePair("mk-siteid", paramString1));
        }
        paramString1 = AdTrackerInitializer.getConfigParams().getDeviceIdMaskMap();
        paramString1 = UID.getInstance().getMapForEncryption(paramString1);
        if (UID.getInstance().isLimitAdTrackingEnabled()) {
            localLinkedList.add(new BasicNameValuePair("u-id-adt", "1"));
        }
        for (; ; ) {
            localLinkedList.add(new BasicNameValuePair("u-id-map", (String) paramString1.get("u-id-map")));
            localLinkedList.add(new BasicNameValuePair("u-id-key", (String) paramString1.get("u-id-key")));
            localLinkedList.add(new BasicNameValuePair("u-key-ver", (String) paramString1.get("u-key-ver")));
            if ((paramString2 != null) && (!paramString2.trim().equals(""))) {
                localLinkedList.add(new BasicNameValuePair("goalName", paramString2));
            }
            if (paramBoolean) {
                localLinkedList.add(new BasicNameValuePair("lp", "1"));
                localLinkedList.add(new BasicNameValuePair("src", "and"));
                if (paramInt > 0) {
                    localLinkedList.add(new BasicNameValuePair("goalCount", Integer.toString(paramInt)));
                }
                paramString1 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.1") + "-" + "20140918";
                localLinkedList.add(new BasicNameValuePair("mk-version", paramString1));
                localLinkedList.add(new BasicNameValuePair("mk-rel-version", paramString1));
                localLinkedList.add(new BasicNameValuePair("osV", String.valueOf(Build.VERSION.SDK_INT)));
                paramString2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rlc");
                paramString1 = paramString2;
                if (paramString2 == null) {
                    paramString1 = "0";
                }
                localLinkedList.add(new BasicNameValuePair("rlc", paramString1));
            }
            try {
                paramString1 = InternalSDKUtil.getContext().getPackageManager().getPackageInfo(InternalSDKUtil.getContext().getPackageName(), 0).versionName;
                if ((paramString1 != null) && (!paramString1.trim().equals(""))) {
                    localLinkedList.add(new BasicNameValuePair("u-appver", paramString1));
                }
                if ((paramString3 != null) && (!paramString3.trim().equals(""))) {
                    localLinkedList.add(new BasicNameValuePair("iat_ids", paramString3));
                }
                if (str != null) {
                    paramInt = FileOperations.getIntPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "rfs");
                    long l1 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t1");
                    long l2 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "t2");
                    localLinkedList.add(new BasicNameValuePair("rfs", Integer.toString(paramInt)));
                    localLinkedList.add(new BasicNameValuePair("rd", Long.toString(l2 - l1)));
                }
                if (1 == AdTrackerNetworkInterface.isUnstableNetwork()) {
                    localLinkedList.add(new BasicNameValuePair("nus", Integer.toString(AdTrackerNetworkInterface.isUnstableNetwork())));
                }
                localLinkedList.add(new BasicNameValuePair("ts", Long.toString(System.currentTimeMillis())));
                return URLEncodedUtils.format(localLinkedList, "utf-8");
                localLinkedList.add(new BasicNameValuePair("u-id-adt", "0"));
                continue;
                localLinkedList.add(new BasicNameValuePair("lp", "0"));
            } catch (PackageManager.NameNotFoundException paramString1) {
                for (; ; ) {
                    Log.internal("[InMobi]-[AdTracker]-4.5.1", "Cant get appversion", paramString1);
                    paramString1 = null;
                }
            }
        }
    }

    public static String getWebViewRequestParam() {
        return a;
    }

    public static void saveWebviewRequestParam(String paramString, Goal paramGoal) {
        a = formHTTPRequest(paramString, paramGoal.getGoalName(), paramGoal.getGoalCount(), paramGoal.isDuplicateGoal(), null);
    }

    public static AdTrackerConstants.StatusCode sendHTTPRequest(String paramString1, Goal paramGoal, String paramString2) {
        Object localObject1 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        Object localObject2 = localObject1;
        try {
            b = System.currentTimeMillis();
            localObject2 = localObject1;
            DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
            localObject2 = localObject1;
            String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer");
            localObject2 = localObject1;
            paramString2 = formHTTPRequest(paramString1, paramGoal.getGoalName(), paramGoal.getGoalCount(), paramGoal.isDuplicateGoal(), paramString2);
            localObject2 = localObject1;
            int i = AdTrackerInitializer.getConfigParams().getConnectionTimeout();
            localObject2 = localObject1;
            Object localObject3 = AdTrackerNetworkInterface.a() + paramString2;
            paramString2 = (String) localObject3;
            if (str != null) {
                localObject2 = localObject1;
                paramString2 = (String) localObject3 + "&referrer=" + str;
            }
            localObject2 = localObject1;
            Log.debug("[InMobi]-[AdTracker]-4.5.1", paramString2);
            localObject2 = localObject1;
            paramString2 = new HttpGet(paramString2);
            localObject2 = localObject1;
            localObject3 = new BasicHttpParams();
            localObject2 = localObject1;
            HttpConnectionParams.setConnectionTimeout((HttpParams) localObject3, i);
            localObject2 = localObject1;
            HttpConnectionParams.setSoTimeout((HttpParams) localObject3, i);
            localObject2 = localObject1;
            localDefaultHttpClient.setParams((HttpParams) localObject3);
            localObject2 = localObject1;
            paramString2 = localDefaultHttpClient.execute(paramString2);
            localObject2 = localObject1;
            if (paramString2.getStatusLine().getStatusCode() != 200) {
                break label509;
            }
            localObject2 = localObject1;
            paramString2 = EntityUtils.toString(paramString2.getEntity());
            localObject2 = localObject1;
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "RESPONSE: " + paramString2);
            localObject2 = localObject1;
            paramString2 = new JSONObject(paramString2);
            localObject2 = localObject1;
            localObject3 = paramString2.getString("errmsg");
            localObject2 = localObject1;
            i = paramString2.getInt("errcode");
            if (6000 == i) {
                localObject2 = localObject1;
                long l1 = System.currentTimeMillis();
                localObject2 = localObject1;
                long l2 = b;
                localObject2 = localObject1;
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, paramGoal, 1, l1 - l2, 0, null);
                localObject2 = localObject1;
            }
            for (paramString2 = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS; ; paramString2 = (String) localObject1) {
                localObject1 = paramString2;
                if (6001 != i) {
                    break label534;
                }
                localObject2 = paramString2;
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Error uploading ping " + (String) localObject3 + "\nReloading webview");
                localObject2 = paramString2;
                FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids", null);
                localObject2 = paramString2;
                if (!AdTrackerNetworkInterface.reportUsingWebview(paramString1, paramGoal)) {
                    break;
                }
                localObject2 = paramString2;
                return AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
                localObject2 = localObject1;
                AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, i, null);
            }
            localObject2 = paramString2;
        } catch (Exception paramString1) {
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, 424, paramString1.getMessage());
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Error uploading Goal Ping", paramString1);
            return (AdTrackerConstants.StatusCode) localObject2;
        }
        return AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
        label509:
        localObject2 = localObject1;
        AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 1, 0L, paramString2.getStatusLine().getStatusCode(), null);
        label534:
        return (AdTrackerConstants.StatusCode) localObject1;
    }

    public static boolean serverReachable(String paramString) {
        try {
            int i = new DefaultHttpClient().execute(new HttpGet(paramString)).getStatusLine().getStatusCode();
            if (i == 200) {
                return true;
            }
        } catch (Exception paramString) {
            Log.debug("[InMobi]-[AdTracker]-4.5.1", "Server not reachable..Logging events");
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerRequestResponseBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */