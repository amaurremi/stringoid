package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONException;
import org.json.JSONObject;

public final class Settings {
    private static final String ANALYTICS_EVENT = "event";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI;
    private static final String ATTRIBUTION_KEY = "attribution";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger counter = new AtomicInteger(0);

        public Thread newThread(Runnable paramAnonymousRunnable) {
            return new Thread(paramAnonymousRunnable, "FacebookSdk #" + this.counter.incrementAndGet());
        }
    };
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE;
    private static final Object LOCK;
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static volatile Executor executor;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static volatile boolean shouldAutoPublishInstall;

    static {
        LOCK = new Object();
        ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    }

    public static final void addLoggingBehavior(LoggingBehavior paramLoggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.add(paramLoggingBehavior);
            return;
        }
    }

    public static final void clearLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            loggingBehaviors.clear();
            return;
        }
    }

    private static Executor getAsyncTaskExecutor() {
        try {
            Field localField = AsyncTask.class.getField("THREAD_POOL_EXECUTOR");
            if (localField == null) {
                return null;
            }
        } catch (NoSuchFieldException localNoSuchFieldException) {
            return null;
        }
        try {
            Object localObject = localNoSuchFieldException.get(null);
            if (localObject == null) {
                return null;
            }
        } catch (IllegalAccessException localIllegalAccessException) {
            return null;
        }
        if (!(localIllegalAccessException instanceof Executor)) {
            return null;
        }
        return (Executor) localIllegalAccessException;
    }

    public static String getAttributionId(ContentResolver paramContentResolver) {
        paramContentResolver = paramContentResolver.query(ATTRIBUTION_ID_CONTENT_URI, new String[]{"aid"}, null, null, null);
        if ((paramContentResolver == null) || (!paramContentResolver.moveToFirst())) {
            return null;
        }
        String str = paramContentResolver.getString(paramContentResolver.getColumnIndex("aid"));
        paramContentResolver.close();
        return str;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                Executor localExecutor = getAsyncTaskExecutor();
                Object localObject1 = localExecutor;
                if (localExecutor == null) {
                    localObject1 = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, DEFAULT_WORK_QUEUE, DEFAULT_THREAD_FACTORY);
                }
                executor = (Executor) localObject1;
            }
            return executor;
        }
    }

    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        synchronized (loggingBehaviors) {
            Set localSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
            return localSet;
        }
    }

    public static String getMigrationBundle() {
        return "fbsdk:20121026";
    }

    public static String getSdkVersion() {
        return "3.0.1";
    }

    public static boolean getShouldAutoPublishInstall() {
        return shouldAutoPublishInstall;
    }

    public static final boolean isLoggingBehaviorEnabled(LoggingBehavior arg0) {
        synchronized (loggingBehaviors) {
            return false;
        }
    }

    public static boolean publishInstallAndWait(Context paramContext, String paramString) {
        paramContext = publishInstallAndWaitForResponse(paramContext, paramString);
        return (paramContext != null) && (paramContext.getError() == null);
    }

    public static Response publishInstallAndWaitForResponse(Context paramContext, String paramString) {
        if ((paramContext == null) || (paramString == null)) {
            try {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            } catch (Exception paramContext) {
                Utility.logd("Facebook-publish", paramContext);
                return new Response(null, null, new FacebookRequestError(null, paramContext));
            }
        }
        String str3 = getAttributionId(paramContext.getContentResolver());
        SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        paramContext = paramString + "ping";
        String str1 = paramString + "json";
        long l = localSharedPreferences.getLong(paramContext, 0L);
        String str2 = localSharedPreferences.getString(str1, null);
        Object localObject = GraphObject.Factory.create();
        ((GraphObject) localObject).setProperty("event", "MOBILE_APP_INSTALL");
        ((GraphObject) localObject).setProperty("attribution", str3);
        localObject = Request.newPostRequest(null, String.format("%s/activities", new Object[]{paramString}), (GraphObject) localObject, null);
        if (l != 0L) {
            paramString = null;
            paramContext = paramString;
            if (str2 == null) {
            }
        }
        try {
            paramContext = GraphObject.Factory.create(new JSONObject(str2));
            if (paramContext == null) {
                return (Response) Response.createResponsesFromString("true", null, new RequestBatch(new Request[]{localObject}), true).get(0);
            }
            return new Response(null, null, paramContext, true);
            if (str3 == null) {
                throw new FacebookException("No attribution id returned from the Facebook application");
            }
            if (!Utility.queryAppAttributionSupportAndWait(paramString)) {
                throw new FacebookException("Install attribution has been disabled on the server.");
            }
            paramString = ((Request) localObject).executeAndWait();
            localObject = localSharedPreferences.edit();
            ((SharedPreferences.Editor) localObject).putLong(paramContext, System.currentTimeMillis());
            if ((paramString.getGraphObject() != null) && (paramString.getGraphObject().getInnerJSONObject() != null)) {
                ((SharedPreferences.Editor) localObject).putString(str1, paramString.getGraphObject().getInnerJSONObject().toString());
            }
            ((SharedPreferences.Editor) localObject).commit();
            return paramString;
        } catch (JSONException paramContext) {
            for (; ; ) {
                paramContext = paramString;
            }
        }
    }

    public static void publishInstallAsync(Context paramContext, String paramString) {
        publishInstallAsync(paramContext, paramString, null);
    }

    public static void publishInstallAsync(Context paramContext, final String paramString, final Request.Callback paramCallback) {
        paramContext = paramContext.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public void run() {
                final Response localResponse = Settings.publishInstallAndWaitForResponse(Settings.this, paramString);
                if (paramCallback != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            this.val$callback.onCompleted(localResponse);
                        }
                    });
                }
            }
        });
    }

    public static final void removeLoggingBehavior(LoggingBehavior paramLoggingBehavior) {
        synchronized (loggingBehaviors) {
            loggingBehaviors.remove(paramLoggingBehavior);
            return;
        }
    }

    public static void setExecutor(Executor paramExecutor) {
        Validate.notNull(paramExecutor, "executor");
        synchronized (LOCK) {
            executor = paramExecutor;
            return;
        }
    }

    public static void setShouldAutoPublishInstall(boolean paramBoolean) {
        shouldAutoPublishInstall = paramBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */