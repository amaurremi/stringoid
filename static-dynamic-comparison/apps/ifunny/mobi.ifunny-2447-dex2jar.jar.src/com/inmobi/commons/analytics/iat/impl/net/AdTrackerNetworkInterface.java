package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import com.inmobi.commons.analytics.iat.impl.AdTrackerConstants.StatusCode;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class AdTrackerNetworkInterface {
    private static GoalList a;
    private static AtomicBoolean b = null;
    private static AtomicBoolean c;
    private static Thread d;
    private static Handler e;
    private static AtomicBoolean f = null;
    private static AtomicBoolean g = null;
    private static AdTrackerWebViewLoader h;
    private static boolean i = false;
    private static int j = 0;
    private static String k = "https://d.appsdt.com/download/tracker/?";
    private static String l = "https://d.appsdt.com/sdkdwnldbeacon.html";
    private static String m = "https://d.appsdt.com/download/tracker/iatsdkconfs?";
    private static Timer n = new Timer();

    static String a() {
        return k;
    }

    private static void a(Goal arg0) {
        for (; ; ) {
            long l2;
            int i1;
            long l1;
            try {
                String str =???.getGoalName();
                l2 =???.getRetryTime();
                i1 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
                if (true == f.get()) {
                    l1 = 0L;
                    if (l1 > 0L) {
                        Log.debug("[InMobi]-[AdTracker]-4.5.1", "Retrying goalname: " + str + " after " + l1 / 1000L + " secs");
                    }
                    synchronized (d) {
                        Thread.sleep(l1);
                        return;
                    }
                }
                l1 = l2;
            } catch (Exception???)
            {
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to reduce wait time exception", ???);
                return;
            }
            if (l2 > i1) {
                l1 = i1;
            }
        }
    }

    private static void a(String paramString, Goal paramGoal) {
        boolean bool = paramGoal.isDuplicateGoal();
        int i1 = paramGoal.getGoalCount();
        String str = paramGoal.getGoalName();
        if (!h()) {
        }
        for (paramString = Boolean.valueOf(reportUsingWebview(paramString, paramGoal)); paramString.booleanValue(); paramString = Boolean.valueOf(reportUsingNetwork(paramString, paramGoal))) {
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
            a.removeGoal(str, i1);
            if ("download".equals(str)) {
                AdTrackerUtils.updateStatus();
            }
            return;
        }
        a.increaseRetryTime(str, i1, bool);
    }

    static String b() {
        return l;
    }

    private static void b(String paramString) {
        try {
            a.saveGoals();
            i = AdTrackerInitializer.getLogger().startNewSample();
            Goal localGoal = (Goal) a.get(0);
            if (!InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Network Unavailable");
                j = 1;
                deinit();
                return;
            }
            a(localGoal);
            g();
            a(paramString, localGoal);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer", true);
            j = 0;
            return;
        } catch (Exception paramString) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to process IAT goals", paramString);
        }
    }

    public static void deinit() {
        if (b != null) {
            b.set(false);
        }
        if ((a != null) && (!a.isEmpty())) {
            a.saveGoals();
        }
        c.set(false);
        a = null;
    }

    private static void g() {
        try {
            long l1;
            if ((!i()) && (!l())) {
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Getting wait time for referrer");
                l1 = j();
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Waiting for referrer for " + l1 + "secs");
                if (i()) {
                }
            }
            synchronized (d) {
                d.wait(l1 * 1000L);
                if (!i()) {
                    ???=AdTrackerUtils.getReferrerFromLogs();
                    if (???!=null)
                    {
                        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Saving referrer from logs: " + (String) ? ??);
                        AdTrackerUtils.setReferrerFromLogs(InternalSDKUtil.getContext(), (String) ? ??);
                    }
                }
                return;
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to set referrer", localException);
        }
    }

    public static GoalList getGoalList() {
        return a;
    }

    public static Thread getNetworkThread() {
        return d;
    }

    public static Handler getUIHandler() {
        return e;
    }

    public static AtomicBoolean getWebviewUploadStatus() {
        return g;
    }

    private static boolean h() {
        try {
            String str = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive");
            Object localObject = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.setTime(new Date());
            localCalendar.getTime().toString();
            if (str != null) {
                if (localObject == null) {
                    return false;
                }
                localObject = localCalendar.getTime();
                localCalendar.add(11, Integer.parseInt(str));
                boolean bool = localCalendar.getTime().after((Date) localObject);
                if (bool) {
                    return true;
                }
            }
        } catch (Exception localException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Error parsing ttl", localException);
        }
        return false;
    }

    private static boolean i() {
        return FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer") != null;
    }

    public static void init() {
        if (a == null) {
            a = GoalList.getLoggedGoals();
        }
        if (b == null) {
            b = new AtomicBoolean(false);
        }
        c = new AtomicBoolean(false);
        if (e == null) {
            e = new Handler();
        }
        f = new AtomicBoolean(true);
        g = new AtomicBoolean(false);
    }

    public static boolean isMetricSample() {
        return i;
    }

    public static boolean isSynced() {
        return c.get();
    }

    public static int isUnstableNetwork() {
        return j;
    }

    private static long j() {
        long l1;
        try {
            int i1 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
            int i2 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryInterval();
            int i3 = AdTrackerInitializer.getConfigParams().getReferrerWaitTime();
            int i4 = (i1 * i2 + 0) * i1 / 2;
            new RetryMechanism(i1 - 1, i2, n).rescheduleTimer(new AdTrackerNetworkInterface.a());
            long l2;
            synchronized (d) {
                d.wait(i4);
                l1 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime");
                l2 = l1;
                if (0L != l1) {
                }
            }
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to get wait time", localException1);
        } catch (Exception localException1) {
            l1 = 0L;
        }
        return l1;
    }

    private static void k() {
        Object localObject2 = new DefaultHttpClient();
        Object localObject1 = m + "t=" + System.currentTimeMillis();
        Log.internal("[InMobi]-[AdTracker]-4.5.1", "Fetch Wait time URL: " + (String) localObject1);
        HttpGet localHttpGet = new HttpGet((String) localObject1);
        localObject1 = null;
        try {
            localObject2 = ((DefaultHttpClient) localObject2).execute(localHttpGet);
            localObject1 = localObject2;
        } catch (Exception localException2) {
            for (; ; ) {
                try {
                    localObject1 = EntityUtils.toString(((HttpResponse) localObject1).getEntity());
                    Log.internal("[InMobi]-[AdTracker]-4.5.1", "Wait time received for referrer: " + (String) localObject1);
                    long l1 = new JSONObject((String) localObject1).getLong("referrerWaitTime");
                    FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime", l1);
                    return;
                } catch (Exception localException1) {
                    Log.internal("[InMobi]-[AdTracker]-4.5.1", "Error fetching wait time for referrer", localException1);
                    return;
                }
                localException2 = localException2;
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Error fetching wait time for referrer", localException2);
            }
        }
        if (((HttpResponse) localObject1).getStatusLine().getStatusCode() == 200) {
        }
        throw new CommonsException(-1);
    }

    private static boolean l() {
        return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer");
    }

    public static void notifyThread() {
        try {
            synchronized (d) {
                d.notify();
                return;
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to notify thread", localException);
        }
    }

    public static AdTrackerConstants.StatusCode reportToServer(String paramString) {
        try {
            if (b.compareAndSet(false, true)) {
                d = new Thread(new AdTrackerNetworkInterface.b(paramString));
                d.setPriority(1);
                d.start();
            }
            paramString = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS;
            return paramString;
        } finally {
        }
    }

    protected static boolean reportUsingNetwork(String paramString, Goal paramGoal) {
        String str1 = paramGoal.getGoalName();
        try {
            String str2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
            AdTrackerConstants.StatusCode localStatusCode = AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_FAILURE;
            paramString = AdTrackerRequestResponseBuilder.sendHTTPRequest(paramString, paramGoal, str2);
            if (AdTrackerConstants.StatusCode.APP_ANALYTICS_UPLOAD_SUCCESS == paramString) {
                f.set(true);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Successfully uploaded goal: " + str1);
            }
            for (; ; ) {
                return f.get();
                if (AdTrackerConstants.StatusCode.RELOAD_WEBVIEW_ERROR != paramString) {
                    break;
                }
                f.set(false);
            }
        } catch (Exception paramString) {
            for (; ; ) {
                f.set(false);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Failed to upload goal: " + str1);
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to report goal: ", paramString);
                continue;
                f.set(false);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Failed to upload goal: " + str1);
            }
        }
    }

    protected static boolean reportUsingWebview(String arg0, Goal paramGoal) {
        for (; ; ) {
            try {
                i1 = AdTrackerInitializer.getConfigParams().getWebviewTimeout();
                h = new AdTrackerWebViewLoader();
                AdTrackerRequestResponseBuilder.saveWebviewRequestParam( ???,paramGoal);
                h.loadWebview(paramGoal);
            } catch (Exception???)
            {
                int i1;
                f.set(false);
                Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to load webview Exception", ???);
                continue;
                f.set(true);
                Log.debug("[InMobi]-[AdTracker]-4.5.1", "Uploaded goal successfully: " + paramGoal.getGoalName());
                continue;
            }
            synchronized (d) {
                d.wait(i1);
                if (true == AdTrackerWebViewLoader.isWebviewLoading()) {
                    AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, paramGoal, 0, 0L, 408, null);
                }
                if (!g.get()) {
                    f.set(false);
                    Log.debug("[InMobi]-[AdTracker]-4.5.1", "Failed to upload goal: " + paramGoal.getGoalName());
                    h.deinit(i1);
                    return g.get();
                }
            }
        }
    }

    public static void setSynced(boolean paramBoolean) {
        c.set(paramBoolean);
    }

    public static void setWebviewUploadStatus(boolean paramBoolean) {
        g.set(paramBoolean);
    }

    public static void waitThread(int paramInt) {
        try {
            synchronized (d) {
                d.wait(paramInt);
                return;
            }
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[AdTracker]-4.5.1", "Failed to notify thread", localException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/analytics/iat/impl/net/AdTrackerNetworkInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */