package com.facebook;

import a.f;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.a.n;
import android.util.Log;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import com.facebook.internal.Validate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static Context applicationContext;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static AppEventsLogger.FlushBehavior flushBehavior = AppEventsLogger.FlushBehavior.AUTO;
    private static String hashedDeviceAndAppId;
    private static boolean isOpenedByApplink;
    private static boolean requestInFlight;
    private static String sourceApplication;
    private static Map<AppEventsLogger.AccessTokenAppIdPair, AppEventsLogger.SessionEventsState> stateMap = new ConcurrentHashMap();
    private static Object staticLock = new Object();
    private final AppEventsLogger.AccessTokenAppIdPair accessTokenAppId;
    private final Context context;

    private AppEventsLogger(Context paramContext, String paramString, Session arg3) {
        Validate.notNull(paramContext, "context");
        this.context = paramContext;
        Session localSession =???;
        if (???==null){
            localSession = Session.getActiveSession();
        }
        if ((localSession != null) && ((paramString == null) || (paramString.equals(localSession.getApplicationId())))) {
            this.accessTokenAppId = new AppEventsLogger.AccessTokenAppIdPair(localSession);
        }
        synchronized (staticLock) {
            if (hashedDeviceAndAppId == null) {
                hashedDeviceAndAppId = Utility.getHashedDeviceAndAppID(paramContext, paramString);
            }
            if (applicationContext == null) {
                applicationContext = paramContext.getApplicationContext();
            }
            initializeTimersIfNeeded();
            return;
            ???=paramString;
            if (paramString == null) {
                ???=Utility.getMetadataApplicationId(paramContext);
            }
            this.accessTokenAppId = new AppEventsLogger.AccessTokenAppIdPair(null, ???);
            paramString =???;
        }
    }

    private static int accumulatePersistedEvents() {
        AppEventsLogger.PersistedEvents localPersistedEvents = AppEventsLogger.PersistedEvents.readAndClearStore(applicationContext);
        Iterator localIterator = localPersistedEvents.keySet().iterator();
        Object localObject;
        for (int i = 0; localIterator.hasNext(); i = ((List) localObject).size() + i) {
            localObject = (AppEventsLogger.AccessTokenAppIdPair) localIterator.next();
            AppEventsLogger.SessionEventsState localSessionEventsState = getSessionEventsState(applicationContext, (AppEventsLogger.AccessTokenAppIdPair) localObject);
            localObject = localPersistedEvents.getEvents((AppEventsLogger.AccessTokenAppIdPair) localObject);
            localSessionEventsState.accumulatePersistedEvents((List) localObject);
        }
        return i;
    }

    public static void activateApp(Context paramContext) {
        Settings.sdkInitialize(paramContext);
        activateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    }

    public static void activateApp(Context paramContext, String paramString) {
        if ((paramContext == null) || (paramString == null)) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        if ((paramContext instanceof Activity)) {
            setSourceApplication((Activity) paramContext);
        }
        for (; ; ) {
            Settings.publishInstallAsync(paramContext, paramString, null);
            paramContext = new AppEventsLogger(paramContext, paramString, null);
            long l = System.currentTimeMillis();
            paramString = getSourceApplication();
            backgroundExecutor.execute(new AppEventsLogger .1 (paramContext, l, paramString));
            return;
            resetSourceApplication();
            Log.d(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
        }
    }

    private static AppEventsLogger.FlushStatistics buildAndExecuteRequests(AppEventsLogger.FlushReason paramFlushReason, Set<AppEventsLogger.AccessTokenAppIdPair> paramSet) {
        AppEventsLogger.FlushStatistics localFlushStatistics = new AppEventsLogger.FlushStatistics(null);
        boolean bool = Settings.getLimitEventAndDataUsage(applicationContext);
        ArrayList localArrayList = new ArrayList();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
            Object localObject = (AppEventsLogger.AccessTokenAppIdPair) paramSet.next();
            AppEventsLogger.SessionEventsState localSessionEventsState = getSessionEventsState((AppEventsLogger.AccessTokenAppIdPair) localObject);
            if (localSessionEventsState != null) {
                localObject = buildRequestForSession((AppEventsLogger.AccessTokenAppIdPair) localObject, localSessionEventsState, bool, localFlushStatistics);
                if (localObject != null) {
                    localArrayList.add(localObject);
                }
            }
        }
        if (localArrayList.size() > 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flushing %d events due to %s.", new Object[]{Integer.valueOf(localFlushStatistics.numEvents), paramFlushReason.toString()});
            paramFlushReason = localArrayList.iterator();
            while (paramFlushReason.hasNext()) {
                ((Request) paramFlushReason.next()).executeAndWait();
            }
            return localFlushStatistics;
        }
        return null;
    }

    private static Request buildRequestForSession(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEventsLogger.SessionEventsState paramSessionEventsState, boolean paramBoolean, AppEventsLogger.FlushStatistics paramFlushStatistics) {
        Object localObject = paramAccessTokenAppIdPair.getApplicationId();
        Utility.FetchedAppSettings localFetchedAppSettings = Utility.queryAppSettings((String) localObject, false);
        Request localRequest = Request.newPostRequest(null, String.format("%s/activities", new Object[]{localObject}), null, null);
        Bundle localBundle = localRequest.getParameters();
        localObject = localBundle;
        if (localBundle == null) {
            localObject = new Bundle();
        }
        ((Bundle) localObject).putString("access_token", paramAccessTokenAppIdPair.getAccessToken());
        localRequest.setParameters((Bundle) localObject);
        if (localFetchedAppSettings == null) {
            return null;
        }
        int i = paramSessionEventsState.populateRequest(localRequest, localFetchedAppSettings.supportsImplicitLogging(), localFetchedAppSettings.supportsAttribution(), paramBoolean);
        if (i == 0) {
            return null;
        }
        paramFlushStatistics.numEvents = (i + paramFlushStatistics.numEvents);
        localRequest.setCallback(new AppEventsLogger .7
        (paramAccessTokenAppIdPair, localRequest, paramSessionEventsState, paramFlushStatistics));
        return localRequest;
    }

    public static void deactivateApp(Context paramContext) {
        deactivateApp(paramContext, Utility.getMetadataApplicationId(paramContext));
    }

    public static void deactivateApp(Context paramContext, String paramString) {
        if ((paramContext == null) || (paramString == null)) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        resetSourceApplication();
        paramContext = new AppEventsLogger(paramContext, paramString, null);
        long l = System.currentTimeMillis();
        backgroundExecutor.execute(new AppEventsLogger .2 (paramContext, l));
    }

    static void eagerFlush() {
        if (getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            flush(AppEventsLogger.FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    private static void flush(AppEventsLogger.FlushReason paramFlushReason) {
        Settings.getExecutor().execute(new AppEventsLogger .6 (paramFlushReason));
    }

    private static void flushAndWait(AppEventsLogger.FlushReason paramFlushReason) {
        HashSet localHashSet;
        synchronized (staticLock) {
            if (requestInFlight) {
                return;
            }
            requestInFlight = true;
            localHashSet = new HashSet(stateMap.keySet());
            accumulatePersistedEvents();
            ???=null;
        }
        try {
            paramFlushReason = buildAndExecuteRequests(paramFlushReason, localHashSet);
            return;
        } catch (Exception paramFlushReason) {
            synchronized (staticLock) {
                requestInFlight = false;
                if (paramFlushReason != null) {
                    ???=new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    ((Intent) ? ??).
                    putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", paramFlushReason.numEvents);
                    ((Intent) ? ??).putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", paramFlushReason.result);
                    n.a(applicationContext).a((Intent) ? ??);
                    return;
                    paramFlushReason =finally;
                    throw paramFlushReason;
                    paramFlushReason = paramFlushReason;
                    Utility.logd(TAG, "Caught unexpected exception while flushing: ", paramFlushReason);
                    paramFlushReason = (AppEventsLogger.FlushReason) ???;
                }
            }
        }
    }

    private static void flushIfNecessary() {
        synchronized (staticLock) {
            if ((getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) && (getAccumulatedEventCount() > 100)) {
                flush(AppEventsLogger.FlushReason.EVENT_THRESHOLD);
            }
            return;
        }
    }

    private static int getAccumulatedEventCount() {
        synchronized (staticLock) {
            Iterator localIterator = stateMap.values().iterator();
            for (int i = 0; localIterator.hasNext(); i = ((AppEventsLogger.SessionEventsState) localIterator.next()).getAccumulatedEventCount() + i) {
            }
            return i;
        }
    }

    public static AppEventsLogger.FlushBehavior getFlushBehavior() {
        synchronized (staticLock) {
            AppEventsLogger.FlushBehavior localFlushBehavior = flushBehavior;
            return localFlushBehavior;
        }
    }

    @Deprecated
    public static boolean getLimitEventUsage(Context paramContext) {
        return Settings.getLimitEventAndDataUsage(paramContext);
    }

    private static AppEventsLogger.SessionEventsState getSessionEventsState(Context paramContext, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair) {
        Object localObject1 = (AppEventsLogger.SessionEventsState) stateMap.get(paramAccessTokenAppIdPair);
        AttributionIdentifiers localAttributionIdentifiers = null;
        if (localObject1 == null) {
            localAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(paramContext);
        }
        synchronized (staticLock) {
            AppEventsLogger.SessionEventsState localSessionEventsState = (AppEventsLogger.SessionEventsState) stateMap.get(paramAccessTokenAppIdPair);
            localObject1 = localSessionEventsState;
            if (localSessionEventsState == null) {
                localObject1 = new AppEventsLogger.SessionEventsState(localAttributionIdentifiers, paramContext.getPackageName(), hashedDeviceAndAppId);
                stateMap.put(paramAccessTokenAppIdPair, localObject1);
            }
            return (AppEventsLogger.SessionEventsState) localObject1;
        }
    }

    private static AppEventsLogger.SessionEventsState getSessionEventsState(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair) {
        synchronized (staticLock) {
            paramAccessTokenAppIdPair = (AppEventsLogger.SessionEventsState) stateMap.get(paramAccessTokenAppIdPair);
            return paramAccessTokenAppIdPair;
        }
    }

    static String getSourceApplication() {
        String str1 = "Unclassified";
        if (isOpenedByApplink) {
            str1 = "Applink";
        }
        String str2 = str1;
        if (sourceApplication != null) {
            str2 = str1 + "(" + sourceApplication + ")";
        }
        return str2;
    }

    private static void handleResponse(AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair, Request paramRequest, Response paramResponse, AppEventsLogger.SessionEventsState paramSessionEventsState, AppEventsLogger.FlushStatistics paramFlushStatistics) {
        FacebookRequestError localFacebookRequestError = paramResponse.getError();
        Object localObject = AppEventsLogger.FlushResult.SUCCESS;
        String str1;
        if (localFacebookRequestError != null) {
            if (localFacebookRequestError.getErrorCode() == -1) {
                paramResponse = AppEventsLogger.FlushResult.NO_CONNECTIVITY;
                str1 = "Failed: No Connectivity";
            }
        }
        for (; ; ) {
            if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                localObject = (String) paramRequest.getTag();
            }
            String str2;
            try {
                localObject = new JSONArray((String) localObject).toString(2);
                Logger.log(LoggingBehavior.APP_EVENTS, TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[]{paramRequest.getGraphObject().toString(), str1, localObject});
                if (localFacebookRequestError != null) {
                    bool = true;
                    paramSessionEventsState.clearInFlightAndStats(bool);
                    if (paramResponse == AppEventsLogger.FlushResult.NO_CONNECTIVITY) {
                        AppEventsLogger.PersistedEvents.persistEvents(applicationContext, paramAccessTokenAppIdPair, paramSessionEventsState);
                    }
                    if ((paramResponse != AppEventsLogger.FlushResult.SUCCESS) && (paramFlushStatistics.result != AppEventsLogger.FlushResult.NO_CONNECTIVITY)) {
                        paramFlushStatistics.result = paramResponse;
                    }
                    return;
                    str1 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{paramResponse.toString(), localFacebookRequestError.toString()});
                    paramResponse = AppEventsLogger.FlushResult.SERVER_ERROR;
                }
            } catch (JSONException localJSONException) {
                for (; ; ) {
                    str2 = "<Can't encode events for debug logging>";
                    continue;
                    boolean bool = false;
                }
            }
            str1 = "Success";
            paramResponse = str2;
        }
    }

    private static void initializeTimersIfNeeded() {
        synchronized (staticLock) {
            if (backgroundExecutor != null) {
                return;
            }
            backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            ???=new AppEventsLogger .3 ();
            backgroundExecutor.scheduleAtFixedRate((Runnable) ? ??,0L, 15L, TimeUnit.SECONDS);
            ???=new AppEventsLogger .4 ();
            backgroundExecutor.scheduleAtFixedRate((Runnable) ? ??,0L, 86400L, TimeUnit.SECONDS);
            return;
        }
    }

    private void logAppSessionResumeEvent(long paramLong, String paramString) {
        AppEventsLogger.PersistedAppSessionInfo.onResume(applicationContext, this.accessTokenAppId, this, paramLong, paramString);
    }

    private void logAppSessionSuspendEvent(long paramLong) {
        AppEventsLogger.PersistedAppSessionInfo.onSuspend(applicationContext, this.accessTokenAppId, this, paramLong);
    }

    private static void logEvent(Context paramContext, AppEventsLogger.AppEvent paramAppEvent, AppEventsLogger.AccessTokenAppIdPair paramAccessTokenAppIdPair) {
        Settings.getExecutor().execute(new AppEventsLogger .5 (paramContext, paramAccessTokenAppIdPair, paramAppEvent));
    }

    private void logEvent(String paramString, Double paramDouble, Bundle paramBundle, boolean paramBoolean) {
        paramString = new AppEventsLogger.AppEvent(this.context, paramString, paramDouble, paramBundle, paramBoolean);
        logEvent(this.context, paramString, this.accessTokenAppId);
    }

    public static AppEventsLogger newLogger(Context paramContext) {
        return new AppEventsLogger(paramContext, null, null);
    }

    public static AppEventsLogger newLogger(Context paramContext, Session paramSession) {
        return new AppEventsLogger(paramContext, null, paramSession);
    }

    public static AppEventsLogger newLogger(Context paramContext, String paramString) {
        return new AppEventsLogger(paramContext, paramString, null);
    }

    public static AppEventsLogger newLogger(Context paramContext, String paramString, Session paramSession) {
        return new AppEventsLogger(paramContext, paramString, paramSession);
    }

    private static void notifyDeveloperError(String paramString) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", paramString);
    }

    public static void onContextStop() {
        AppEventsLogger.PersistedEvents.persistEvents(applicationContext, stateMap);
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByApplink = false;
    }

    public static void setFlushBehavior(AppEventsLogger.FlushBehavior paramFlushBehavior) {
        synchronized (staticLock) {
            flushBehavior = paramFlushBehavior;
            return;
        }
    }

    @Deprecated
    public static void setLimitEventUsage(Context paramContext, boolean paramBoolean) {
        Settings.setLimitEventAndDataUsage(paramContext, paramBoolean);
    }

    private static void setSourceApplication(Activity paramActivity) {
        Object localObject = paramActivity.getCallingActivity();
        if (localObject != null) {
            localObject = ((ComponentName) localObject).getPackageName();
            if (((String) localObject).equals(paramActivity.getPackageName())) {
                resetSourceApplication();
                return;
            }
            sourceApplication = (String) localObject;
        }
        paramActivity = paramActivity.getIntent();
        if ((paramActivity == null) || (paramActivity.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))) {
            resetSourceApplication();
            return;
        }
        localObject = f.a(paramActivity);
        if (localObject == null) {
            resetSourceApplication();
            return;
        }
        isOpenedByApplink = true;
        localObject = ((Bundle) localObject).getBundle("referer_app_link");
        if (localObject == null) {
            sourceApplication = null;
            return;
        }
        sourceApplication = ((Bundle) localObject).getString("package");
        paramActivity.putExtra("_fbSourceApplicationHasBeenSet", true);
    }

    static void setSourceApplication(String paramString, boolean paramBoolean) {
        sourceApplication = paramString;
        isOpenedByApplink = paramBoolean;
    }

    public void flush() {
        flush(AppEventsLogger.FlushReason.EXPLICIT);
    }

    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }

    boolean isValidForSession(Session paramSession) {
        paramSession = new AppEventsLogger.AccessTokenAppIdPair(paramSession);
        return this.accessTokenAppId.equals(paramSession);
    }

    public void logEvent(String paramString) {
        logEvent(paramString, null);
    }

    public void logEvent(String paramString, double paramDouble) {
        logEvent(paramString, paramDouble, null);
    }

    public void logEvent(String paramString, double paramDouble, Bundle paramBundle) {
        logEvent(paramString, Double.valueOf(paramDouble), paramBundle, false);
    }

    public void logEvent(String paramString, Bundle paramBundle) {
        logEvent(paramString, null, paramBundle, false);
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency) {
        logPurchase(paramBigDecimal, paramCurrency, null);
    }

    public void logPurchase(BigDecimal paramBigDecimal, Currency paramCurrency, Bundle paramBundle) {
        if (paramBigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (paramCurrency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
            localBundle = new Bundle();
        }
        localBundle.putString("fb_currency", paramCurrency.getCurrencyCode());
        logEvent("fb_mobile_purchase", paramBigDecimal.doubleValue(), localBundle);
        eagerFlush();
    }

    public void logSdkEvent(String paramString, Double paramDouble, Bundle paramBundle) {
        logEvent(paramString, paramDouble, paramBundle, true);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/AppEventsLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */